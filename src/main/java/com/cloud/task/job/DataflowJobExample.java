package com.cloud.task.job;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import com.cloud.task.annotation.ScheduledTask;
import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.dataflow.DataflowJob;

/**
 * DataflowJob类型的的例子
 * @author White Stone
 *
 * 2021年12月14日
 */
@ScheduledTask(name = "DataflowJobExample", cron = "0/30 * * * * ?", shardingTotalCount = 2, overwrite = true)
public class DataflowJobExample implements DataflowJob {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
  
    /**
     * 获取待处理数据.
     *
     * @param shardingContext 分片上下文
     * @return 待处理的数据集合
     */
    @Override
    public List fetchData(ShardingContext shardingContext) {
        log.info("Fetch actity data");
        return null;
    }

    /**
     * process data
     *
     * @param shardingContext 分片上下文
     * @param data 待处理数据集合
     */
    @Override
    public void processData(ShardingContext shardingContext, List data) {
        // print activity task info
        log.info("任务名={}, 片数={}, sharding item={}, data size={}", shardingContext.getJobName(),
            shardingContext.getShardingTotalCount(), shardingContext.getShardingItem(),
            CollectionUtils.isEmpty(data) ? 0 : data.size());
    }
}
