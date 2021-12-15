package com.cloud.task.model;

import java.time.Clock;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 〈关闭应用事件〉<br>
 *
 * @author number68
 * @date 2019/4/25
 * @since 0.1
 */
public class ShutDownApplicationEvent extends ApplicationEvent {
  private ConfigurableApplicationContext context;
  private Throwable                      exception;

  public ShutDownApplicationEvent(String applicationName, ConfigurableApplicationContext context,
      Throwable exception) {
    super(applicationName);
    this.context = context;
    this.exception = exception;
  }

  public ConfigurableApplicationContext getContext() {
    return context;
  }

  public void setContext(ConfigurableApplicationContext context) {
    this.context = context;
  }

  public Throwable getException() {
    return exception;
  }

  public void setException(Throwable exception) {
    this.exception = exception;
  }

  @Override
  public String toString() {
    return "ShutDownApplicationEvent [context=" + context + ", exception=" + exception + "]";
  }

}
