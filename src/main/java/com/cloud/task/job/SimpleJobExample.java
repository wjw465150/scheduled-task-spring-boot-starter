package com.cloud.task.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cloud.task.annotation.ScheduledTask;
import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;

/**
 * SimpleJob类型的的例子,这个类演示在管理页面上手工添加!
 * @author White Stone
 *
 * 2021年12月14日
 */
//@ScheduledTask(name = "SimpleJobExample", cron = "0/45 * * * * ?", shardingTotalCount = 3, shardingItemParameters="0=Beijing,1=Shanghai,2=Guangzhou", overwrite = true)
public class SimpleJobExample implements SimpleJob {
  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  @Override
  public void execute(ShardingContext shardingContext) {
    //打印出任务相关信息，JobParameter用于传递任务的ID
    logger.info("JobName：{}, ShardingTotalCount：{}, JobParameter={}, ShardingItem: {}, ShardingParameter: {}",
        shardingContext.getJobName(),
        shardingContext.getShardingTotalCount(),
        shardingContext.getJobParameter(),
        shardingContext.getShardingItem(),
        shardingContext.getShardingParameter()
        );
  }
}
