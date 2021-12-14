package com.cloud.task.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

/**
 * 〈JobProperties，用于注册zookeeper节点信息〉<br>
 *
 * @author number68
 * @date 2019/4/25
 * @since 0.1
 */
public class JobProperties {

  /**
   * 自定义异常处理类
   * 
   * @return
   */
  @JsonProperty("job_exception_handler")
  @SerializedName("job_exception_handler")
  private String jobExceptionHandler = "com.dangdang.ddframe.job.executor.handler.impl.DefaultJobExceptionHandler";

  /**
   * 自定义业务处理线程池
   * 
   * @return
   */
  @JsonProperty("executor_service_handler")
  @SerializedName("executor_service_handler")
  private String executorServiceHandler = "com.dangdang.ddframe.job.executor.handler.impl.DefaultExecutorServiceHandler";

  public String getJobExceptionHandler() {
    return jobExceptionHandler;
  }

  public void setJobExceptionHandler(String jobExceptionHandler) {
    this.jobExceptionHandler = jobExceptionHandler;
  }

  public String getExecutorServiceHandler() {
    return executorServiceHandler;
  }

  public void setExecutorServiceHandler(String executorServiceHandler) {
    this.executorServiceHandler = executorServiceHandler;
  }

  public JobProperties() {
    super();
    // TODO Auto-generated constructor stub
  }

  @Override
  public String toString() {
    return "JobProperties [jobExceptionHandler=" + jobExceptionHandler + ", executorServiceHandler=" + executorServiceHandler + "]";
  }

}
