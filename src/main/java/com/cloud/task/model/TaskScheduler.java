package com.cloud.task.model;

import com.cloud.task.annotation.ScheduledTask;
import com.dangdang.ddframe.job.lite.spring.api.SpringJobScheduler;

/**
 * 〈SpringJobScheduler 包装类〉<br>
 *
 * @author number68
 * @date 2019/4/25
 * @since 0.1
 */
public class TaskScheduler {
  private SpringJobScheduler springJobScheduler;

  private ScheduledTask scheduledTask;

  public TaskScheduler(SpringJobScheduler springJobScheduler, ScheduledTask scheduledTask) {
    this.springJobScheduler = springJobScheduler;
    this.scheduledTask = scheduledTask;
  }

  public SpringJobScheduler getSpringJobScheduler() {
    return springJobScheduler;
  }

  public void setSpringJobScheduler(SpringJobScheduler springJobScheduler) {
    this.springJobScheduler = springJobScheduler;
  }

  public ScheduledTask getScheduledTask() {
    return scheduledTask;
  }

  public void setScheduledTask(ScheduledTask scheduledTask) {
    this.scheduledTask = scheduledTask;
  }

}
