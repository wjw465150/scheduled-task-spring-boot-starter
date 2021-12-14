package com.cloud.task.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dangdang.ddframe.job.executor.ShardingContexts;
import com.dangdang.ddframe.job.lite.api.listener.ElasticJobListener;

/**
 *〈ScheduledTaskListener〉<br>
 *
 * @author number68
 * @date 2019/4/24
 * @since 0.1
 */
public class ScheduledTaskExecutionListener implements ElasticJobListener {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    public ScheduledTaskExecutionListener() {}

    @Override
    public void beforeJobExecuted(ShardingContexts shardingContexts) {
        log.info("Job:{} shards are starting execution.", shardingContexts.getJobName());
    }

    @Override
    public void afterJobExecuted(ShardingContexts shardingContexts) {
        log.info("Congratulations, Job:{} shards have been finished successfully in this instance.",
            shardingContexts.getJobName());
    }
}
