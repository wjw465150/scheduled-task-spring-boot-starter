package com.cloud.task.annotation;

import java.lang.annotation.*;

import org.springframework.stereotype.Component;

/**
 * 〈ScheduledTask〉<br>
 *
 * @author number68
 * @create 2019/4/25
 * @since 0.1
 */
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface ScheduledTask {

  /**
   * job名称
   */
  String name();

  /**
   * job描述信息
   */
  String description() default "";

  /**
   * cron表达式，用于控制作业触发时间
   */
  String cron() default "";

  /**
   * job分片总数.
   * 为1的时候,整个集群中只会有一个进程去执行该Job,在服务器数量没有波动的情况下,任务总会在固定某个进程上执行。
   * 在作业执行前进程如果挂了,那作业会被分配到集群某一个存活的进程中.
   */
  int shardingTotalCount() default 1;

  /**
   * 分片序列号和参数用等号分隔，多个键值对用逗号分隔<br>
   * 分片序列号从0开始，不可大于或等于作业分片总数<br>
   * 如：0=a,1=b,2=c
   */
  String shardingItemParameters() default "";

  /**
   * 作业自定义参数<br>
   * 作业自定义参数，可通过传递该参数为作业调度的业务方法传参，用于实现带参数的作业<br>
   * 例：每次获取的数据量、作业实例从数据库读取的主键等
   */
  String jobParameter() default "";

  /**
   * 是否开启任务执行失效转移<br>
   * 如果为true,当作业在执行过程中异常中断,作业会被分发到集群中存活的结点
   */
  boolean failover() default true;

  /**
   * 是否开启错过任务重新执行
   */
  boolean misfire() default false;

  /**
   * 是否用SpringBoot里的覆盖Zookeeper里的Job配置 
   */
  boolean overwrite() default false;

  /**
   * 是否流式处理数据<br>
   * 如果流式处理数据, 则fetchData不返回空结果将持续执行作业<br>
   * 如果非流式处理数据, 则处理数据完成后作业结束<br>
   */
  boolean streamingProcess() default false;

  /**
   * 监控作业运行时状态<br>
   * 每次作业执行时间和间隔时间均非常短的情况，建议不监控作业运行时状态以提升效率。<br>
   * 因为是瞬时状态，所以无必要监控。请用户自行增加数据堆积监控。并且不能保证数据重复选取，应在作业中实现幂等性。<br>
   * 每次作业执行时间和间隔时间均较长的情况，建议监控作业运行时状态，可保证数据不会重复选取。<br>
   */
  boolean monitorExecution() default true;

  /**
   * 作业监控端口<br>
   * 建议配置作业监控端口, 方便开发者dump作业信息。<br>
   * 使用方法: echo “dump” | nc 127.0.0.1 9888<br>
   */
  int monitorPort() default -1;

  /**
   * 最大允许的本机与注册中心的时间误差秒数<br>
   * 如果时间误差超过配置秒数则作业启动时将抛异常<br>
   * 配置为-1表示不校验时间误差<br>
   */
  int maxTimeDiffSeconds() default -1;

  /**
   * 作业分片策略实现类全路径,默认使用平均分配策略<br>
   */
  String jobShardingStrategyClass() default "";

  /**
   * 修复作业服务器不一致状态服务调度间隔时间<br>
   * 配置为小于1的任意值表示不执行修复,单位：分钟
   */
  int reconcileIntervalMinutes() default 10;

  /**
   * 作业事件追踪的datasource数据源Bean引用<br>
   * 如果没有指定就使用SB缺省的datasource
   */
  String eventTraceRdbDataSource() default "";

  /**
   * 作业是否禁止自动启动<br>
   * 如果为true,在开始部署的时候作业不会自启动,即使到了触发时间,需要在控制台手动触发。
   */
  boolean disabled() default false;

  /**
   * 前置后置任务监听实现类，需实现ElasticJobListener接口<br>
   */
  String listener() default "";

  /**
   * 前置后置任务分布式监听实现类，需继承AbstractDistributeOnceElasticJobListener类<br>
   */
  String distributedListener() default "";

  /**
   * 最后一个作业执行前的执行方法的超时时间,单位：毫秒<br>
   */
  long startedTimeoutMilliseconds() default Long.MAX_VALUE;

  /**
   * 最后一个作业执行后的执行方法的超时时间,单位：毫秒<br>
   */
  long completedTimeoutMilliseconds() default Long.MAX_VALUE;

  /**
   * 自定义异常处理类<br>
   */
  String jobExceptionHandler() default "com.dangdang.ddframe.job.executor.handler.impl.DefaultJobExceptionHandler";

  /**
   * 自定义业务处理线程池
   */
  String executorServiceHandler() default "com.dangdang.ddframe.job.executor.handler.impl.DefaultExecutorServiceHandler";
}
