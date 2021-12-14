package com.cloud.task.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *〈应用程序错误监听器〉<br> 
 *
 * @author number68
 * @date 2019/4/25
 * @since 0.1
 */

import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;

import com.cloud.task.model.ShutDownApplicationEvent;

@Configuration
public class ApplicationErrorListener implements ApplicationListener<ShutDownApplicationEvent> {
  private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public void onApplicationEvent(ShutDownApplicationEvent event) {
        if (null != event) {
            log.error("errMsg = {}, stackTrace = ", event.getException().getMessage(), event.getException());
            event.getContext().close();
            System.exit(-1);
        }
    }
}
