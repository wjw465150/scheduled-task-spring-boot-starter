package com.cloud.task.model;

import com.dangdang.ddframe.job.lite.config.LiteJobConfiguration;
import com.dangdang.ddframe.job.lite.internal.server.ServerService;
import com.dangdang.ddframe.job.lite.spring.api.SpringJobScheduler;

/**
 * 〈SpringJobScheduler的包装类〉<br>
 *
 * @author number68
 * @date 2019/6/4
 * @since 0.1
 */
public class SpringJobSchedulerFacade {

  private LiteJobConfiguration jobConfiguration;

  private SpringJobScheduler springJobScheduler;

  private ServerService serverService;

  public LiteJobConfiguration getJobConfiguration() {
    return jobConfiguration;
  }

  public SpringJobScheduler getSpringJobScheduler() {
    return springJobScheduler;
  }

  public ServerService getServerService() {
    return serverService;
  }

  public SpringJobSchedulerFacade(LiteJobConfiguration jobConfiguration, SpringJobScheduler springJobScheduler, ServerService serverService) {
    super();
    this.jobConfiguration = jobConfiguration;
    this.springJobScheduler = springJobScheduler;
    this.serverService = serverService;
  }

}
