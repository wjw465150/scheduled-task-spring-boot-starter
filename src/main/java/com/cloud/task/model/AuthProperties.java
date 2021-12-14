package com.cloud.task.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * 〈鉴权属性配置〉<br> 
 *
 * @author number68
 * @date 2019/5/20
 * @since 0.1
 */
@Configuration
public class AuthProperties {
    @Value("${auth.username}")
    private String username;

    @Value("${auth.password}")
    private String password;

    public String getUsername() {
      return username;
    }

    public void setUsername(String username) {
      this.username = username;
    }

    public String getPassword() {
      return password;
    }

    public void setPassword(String password) {
      this.password = password;
    }

    public AuthProperties() {
      super();
    }

    @Override
    public String toString() {
      return "AuthProperties [username=" + username + ", password=" + password + "]";
    }
}
