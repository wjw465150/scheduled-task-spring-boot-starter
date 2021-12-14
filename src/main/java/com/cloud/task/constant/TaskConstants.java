package com.cloud.task.constant;

/**
 *〈任务常量定义〉<br>
 *
 * @author number68
 * @date 2019/4/25
 * @since 0.1
 */
public class TaskConstants {
    /**
     * 定时任务操作人
     */
    public static final String TASK_USER = "task";

    public static final String CRON = "cron";

    public static final String SHARDING_TOTAL_COUNT = "shardingTotalCount";

    public static final String SHARDING_ITEM_PARAMETERS = "shardingItemParameters";

    public static final String JOB_PARAMETER = "jobParameter";

    public static final String MONITOR_EXECUTION = "monitorExecution";

    public static final String MONITOR_PORT = "monitorPort";

    public static final String FAILOVER = "failover";

    public static final String MAX_TIME_DIFF_SECONDS = "maxTimeDiffSeconds";

    public static final String MISFIRE = "misfire";

    public static final String JOB_SHARDING_STRATEGY_CLASS = "jobShardingStrategyClass";

    public static final String DESCRIPTION = "description";

    public static final String DISABLED = "disabled";

    public static final String OVERWRITE = "overwrite";

    public static final String LISTENER = "listener";

    public static final String DISTRIBUTED_LISTENER = "distributedListener";

    public static final String EXECUTOR_SERVICE_HANDLER = "executorServiceHandler";

    public static final String JOB_EXCEPTION_HANDLER = "jobExceptionHandler";

    public static final String EVENT_TRACE_RDB_DATA_SOURCE = "eventTraceRdbDataSource";

    public static final String RECONCILE_INTERVAL_MINUTES = "reconcileIntervalMinutes";

    public static final String STREAMING_PROCESS = "streamingProcess";

    public static final String PATH_DELIMITER = "/";

    public static final String CONFIG_PATH = "/config";

    public static final String SIMPLE_JOB_TYPE = "SIMPLE";

    public static final String DATAFLOW_JOB_TYPE = "DATAFLOW";

    public static final String SCRIPT_JOB_TYPE = "SCRIPT";

    /**
     * 执行一次的任务
     */
    public static final String RUN_ONCE = "runOnce";

    public static final String JOB_PARAMETER_DELIMETER = "@_@";

    public static final String AUTHORIZATION = "authorization";

    public static final String LOGOUT = "/logout";
}
