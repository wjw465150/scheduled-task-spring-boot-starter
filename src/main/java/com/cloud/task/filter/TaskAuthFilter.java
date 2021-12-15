package com.cloud.task.filter;

import java.io.IOException;
import java.util.Base64;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.cloud.task.constant.TaskConstants;
import com.cloud.task.model.AuthProperties;

/**
 * 认证过滤器.
 */
@Configuration
@WebFilter(filterName = "authFilter", urlPatterns = {"/", "/api/*", "/logout", "*.html"})
public class TaskAuthFilter implements Filter {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    private AuthProperties authProperties;

    private static final String AUTH_PREFIX = "Basic ";

    private static final String ADMIN_IDENTIFY = "admin";

    @Override
    public void init(final FilterConfig filterConfig) throws ServletException {
        log.info("AuthFilter init.");
    }

    @Override
    public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain)
        throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest)request;
        HttpServletResponse httpResponse = (HttpServletResponse)response;
        String authorization = httpRequest.getHeader(TaskConstants.AUTHORIZATION);
        if (null == authorization || authorization.length() <= AUTH_PREFIX.length()) {
            needAuthenticate(httpResponse);
            return;
        }

        // 浏览器会话关闭前主动登出
        if (TaskConstants.LOGOUT.equals(((HttpServletRequest) request).getRequestURI())) {
            httpResponse.setStatus(401);
            return;
        }

        authorization = authorization.substring(AUTH_PREFIX.length());
        if (!(authProperties.getUsername() + ":" + authProperties.getPassword())
            .equals(new String(Base64.getDecoder().decode(authorization)))) {
            needAuthenticate(httpResponse);
            return;
        }

        authenticateSuccess(httpResponse);
        chain.doFilter(httpRequest, httpResponse);
    }

    private void authenticateSuccess(final HttpServletResponse response) {
        response.setStatus(200);
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-store");
        response.setDateHeader("Expires", 0);
        response.setHeader("identify", ADMIN_IDENTIFY);
    }

    private void needAuthenticate(final HttpServletResponse response) {
        response.setStatus(401);
        response.setHeader("Cache-Control", "no-store");
        response.setDateHeader("Expires", 0);
        response.setHeader("WWW-authenticate", AUTH_PREFIX + "Realm=\"Elastic Job Console Auth\"");
    }

    @Override
    public void destroy() {
        log.info("AuthFilter destroyed.");
    }
}
