package com.cloud.task.model;

import java.io.Serializable;

/**
 * 〈Job，用于向zookeeper注册节点信息〉<br>
 *
 * @author number68
 * @date 2019/4/25
 * @since 0.1
 */
public class Job implements Serializable {

  private static final long serialVersionUID = -6532210090618686688L;

  /**
   * job名称<br>
   */
  private String jobName;

  /**
   * job描述信息<br>
   */
  private String description = "";

  /**
   * job类型（SIMPLE，DATAFLOW，SCRIPT）<br>
   */
  private String jobType;

  /**
   * job类全路径名<br>
   */
  private String jobClass;

  /**
   * cron表达式，用于控制job触发时间<br>
   */
  private String cron;

  /**
   * job分片总数<br>
   * 为1的时候,整个集群中只会有一个进程去执行该Job,在服务器数量没有波动的情况下,任务总会在固定某个进程上执行。
   * 在作业执行前进程如果挂了,那作业会被分配到集群某一个存活的进程中.
   */
  private int shardingTotalCount = 1;

  /**
   * 分片序列号和参数用等号分隔，多个键值对用逗号分隔<br>
   * 分片序列号从0开始，不可大于或等于job分片总数<br>
   * 如：0=a,1=b,2=c<br>
   */
  private String shardingItemParameters = "";

  /**
   * job自定义参数<br>
   * job自定义参数，可通过传递该参数为job调度的业务方法传参，用于实现带参数的job<br>
   * 例：每次获取的数据量、作业实例从数据库读取的主键等<br>
   */
  private String jobParameter = "";

  /**
   * 是否开启任务执行失效转移<br>
   * 如果为true,当作业在执行过程中异常中断,作业会被分发到集群中存活的结点
   */
  private boolean failover = true;

  /**
   * 是否开启错过任务重新执行<br>
   */
  private boolean misfire = false;

  /**
   * 是否用SpringBoot里的覆盖Zookeeper里的Job配置
   */
  private boolean overwrite = false;

  /**
   * 是否流式处理数据<br>
   * 如果流式处理数据, 则fetchData不返回空结果将持续执行作业<br>
   * 如果非流式处理数据, 则处理数据完成后作业结束<br>
   */
  private boolean streamingProcess = false;

  /**
   * 脚本型作业执行命令行<br>
   */
  private String scriptCommandLine = "";

  /**
   * 监控作业运行时状态,幂等机制(monitorExecution)，来确保同一条数据不会被多个Job同时处理，避免同一条数据被同一个Job实例的多个线程处理。<br>
   * 每次作业执行时间和间隔时间均非常短的情况，建议不监控作业运行时状态以提升效率。<br>
   * 因为是瞬时状态，所以无必要监控。请用户自行增加数据堆积监控。并且不能保证数据重复选取，应在作业中实现幂等性。<br>
   * 每次作业执行时间和间隔时间均较长的情况，建议监控作业运行时状态，可保证数据不会重复选取。<br>
   */
  private boolean monitorExecution = true;

  /**
   * 作业监控端口<br>
   * 建议配置作业监控端口, 方便开发者dump作业信息。<br>
   * 使用方法: echo “dump” | nc 127.0.0.1 9888<br>
   */
  private int monitorPort = -1;

  /**
   * 最大允许的本机与注册中心的时间误差秒数<br>
   * 如果时间误差超过配置秒数则作业启动时将抛异常<br>
   * 配置为-1表示不校验时间误差<br>
   */
  private int maxTimeDiffSeconds = -1;

  /**
   * 作业分片策略实现类全路径,默认使用平均分配策略<br>
   */
  private String jobShardingStrategyClass = "";

  /**
   * 修复作业服务器不一致状态服务调度间隔时间<br>
   * 配置为小于1的任意值表示不执行修复,单位：分钟
   */
  private int reconcileIntervalMinutes = 10;

  /**
   * 任务执行日志数据源，以名称获取(注意不是DataSource而是{@link com.dangdang.ddframe.job.event.JobEventConfiguration})<br>
   * 如果为空就使用系统缺省的:由`com.cloud.task.config.ScheduledTaskConfig`自动创建的`defaultJobEventConfiguration`Bean,参见{@link com.cloud.task.config.JobEventRdbConfiguration}
   */
  private String eventTraceRdbDataSource = "";

  /**
   * 作业是否禁止自动启动<br>
   * 如果为true,在开始部署的时候作业不会自启动,即使到了触发时间,需要在控制台手动触发。
   */
  private boolean disabled = false;

  /**
   * 前置后置任务监听实现类，需实现ElasticJobListener接口<br>
   */
  private String listener = "";

  /**
   * 前置后置任务分布式监听实现类，需继承AbstractDistributeOnceElasticJobListener类<br>
   */
  private String distributedListener = "";

  /**
   * 最后一个作业执行前的执行方法的超时时间,单位：毫秒<br>
   */
  private long startedTimeoutMilliseconds = Long.MAX_VALUE;

  /**
   * 最后一个作业执行后的执行方法的超时时间,单位：毫秒<br>
   */
  private long completedTimeoutMilliseconds = Long.MAX_VALUE;

  /**
   * 扩展属性<br>
   */
  private JobProperties jobProperties = new JobProperties();

  /**
   * 是否仅执行一次
   */
  private boolean runOnce = false;

  public String getJobName() {
    return jobName;
  }

  public void setJobName(String jobName) {
    this.jobName = jobName;
  }

  public String getJobType() {
    return jobType;
  }

  public void setJobType(String jobType) {
    this.jobType = jobType;
  }

  public String getJobClass() {
    return jobClass;
  }

  public void setJobClass(String jobClass) {
    this.jobClass = jobClass;
  }

  public String getCron() {
    return cron;
  }

  public void setCron(String cron) {
    this.cron = cron;
  }

  public int getShardingTotalCount() {
    return shardingTotalCount;
  }

  public void setShardingTotalCount(int shardingTotalCount) {
    this.shardingTotalCount = shardingTotalCount;
  }

  public String getShardingItemParameters() {
    return shardingItemParameters;
  }

  public void setShardingItemParameters(String shardingItemParameters) {
    this.shardingItemParameters = shardingItemParameters;
  }

  public String getJobParameter() {
    return jobParameter;
  }

  public void setJobParameter(String jobParameter) {
    this.jobParameter = jobParameter;
  }

  public boolean isFailover() {
    return failover;
  }

  public void setFailover(boolean failover) {
    this.failover = failover;
  }

  public boolean isMisfire() {
    return misfire;
  }

  public void setMisfire(boolean misfire) {
    this.misfire = misfire;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public boolean isOverwrite() {
    return overwrite;
  }

  public void setOverwrite(boolean overwrite) {
    this.overwrite = overwrite;
  }

  public boolean isStreamingProcess() {
    return streamingProcess;
  }

  public void setStreamingProcess(boolean streamingProcess) {
    this.streamingProcess = streamingProcess;
  }

  public String getScriptCommandLine() {
    return scriptCommandLine;
  }

  public void setScriptCommandLine(String scriptCommandLine) {
    this.scriptCommandLine = scriptCommandLine;
  }

  public boolean isMonitorExecution() {
    return monitorExecution;
  }

  public void setMonitorExecution(boolean monitorExecution) {
    this.monitorExecution = monitorExecution;
  }

  public int getMonitorPort() {
    return monitorPort;
  }

  public void setMonitorPort(int monitorPort) {
    this.monitorPort = monitorPort;
  }

  public int getMaxTimeDiffSeconds() {
    return maxTimeDiffSeconds;
  }

  public void setMaxTimeDiffSeconds(int maxTimeDiffSeconds) {
    this.maxTimeDiffSeconds = maxTimeDiffSeconds;
  }

  public String getJobShardingStrategyClass() {
    return jobShardingStrategyClass;
  }

  public void setJobShardingStrategyClass(String jobShardingStrategyClass) {
    this.jobShardingStrategyClass = jobShardingStrategyClass;
  }

  public int getReconcileIntervalMinutes() {
    return reconcileIntervalMinutes;
  }

  public void setReconcileIntervalMinutes(int reconcileIntervalMinutes) {
    this.reconcileIntervalMinutes = reconcileIntervalMinutes;
  }

  public String getEventTraceRdbDataSource() {
    return eventTraceRdbDataSource;
  }

  public void setEventTraceRdbDataSource(String eventTraceRdbDataSource) {
    this.eventTraceRdbDataSource = eventTraceRdbDataSource;
  }

  public String getListener() {
    return listener;
  }

  public void setListener(String listener) {
    this.listener = listener;
  }

  public boolean isDisabled() {
    return disabled;
  }

  public void setDisabled(boolean disabled) {
    this.disabled = disabled;
  }

  public String getDistributedListener() {
    return distributedListener;
  }

  public void setDistributedListener(String distributedListener) {
    this.distributedListener = distributedListener;
  }

  public long getStartedTimeoutMilliseconds() {
    return startedTimeoutMilliseconds;
  }

  public void setStartedTimeoutMilliseconds(long startedTimeoutMilliseconds) {
    this.startedTimeoutMilliseconds = startedTimeoutMilliseconds;
  }

  public long getCompletedTimeoutMilliseconds() {
    return completedTimeoutMilliseconds;
  }

  public void setCompletedTimeoutMilliseconds(long completedTimeoutMilliseconds) {
    this.completedTimeoutMilliseconds = completedTimeoutMilliseconds;
  }

  public JobProperties getJobProperties() {
    return jobProperties;
  }

  public void setJobProperties(JobProperties jobProperties) {
    this.jobProperties = jobProperties;
  }

  public boolean isRunOnce() {
    return runOnce;
  }

  public void setRunOnce(boolean runOnce) {
    this.runOnce = runOnce;
  }

  public static long getSerialversionuid() {
    return serialVersionUID;
  }

  public Job() {
    super();
  }

  @Override
  public String toString() {
    return "Job [jobName=" + jobName + ", jobType=" + jobType + ", jobClass=" + jobClass + ", cron=" + cron + ", shardingTotalCount=" + shardingTotalCount + ", shardingItemParameters=" + shardingItemParameters + ", jobParameter=" + jobParameter + ", failover=" + failover + ", misfire=" + misfire + ", description=" + description + ", overwrite=" + overwrite + ", streamingProcess=" + streamingProcess + ", scriptCommandLine=" + scriptCommandLine + ", monitorExecution=" + monitorExecution + ", monitorPort=" + monitorPort + ", maxTimeDiffSeconds=" + maxTimeDiffSeconds + ", jobShardingStrategyClass=" + jobShardingStrategyClass + ", reconcileIntervalMinutes=" + reconcileIntervalMinutes + ", eventTraceRdbDataSource=" + eventTraceRdbDataSource + ", listener=" + listener + ", disabled=" + disabled + ", distributedListener=" + distributedListener + ", startedTimeoutMilliseconds=" + startedTimeoutMilliseconds + ", completedTimeoutMilliseconds=" + completedTimeoutMilliseconds + ", jobProperties=" + jobProperties + ", runOnce=" + runOnce + "]";
  }

}
