package com.cloud.task.model;

/**
 * 〈作业执行事件查询body〉<br>
 *
 * @author number68
 * @date 2019/5/14
 * @since 0.1
 */
public class JobExecutionQueryInfo {
  private String perPage;

  private String page;

  private String sort;

  private String order;

  private String startTime;

  private String endTime;

  private String jobName;

  private String source;

  private String executionType;

  private String state;

  private String ip;

  private String isSuccess;

  public String getPerPage() {
    return perPage;
  }

  public void setPerPage(String perPage) {
    this.perPage = perPage;
  }

  public String getPage() {
    return page;
  }

  public void setPage(String page) {
    this.page = page;
  }

  public String getSort() {
    return sort;
  }

  public void setSort(String sort) {
    this.sort = sort;
  }

  public String getOrder() {
    return order;
  }

  public void setOrder(String order) {
    this.order = order;
  }

  public String getStartTime() {
    return startTime;
  }

  public void setStartTime(String startTime) {
    this.startTime = startTime;
  }

  public String getEndTime() {
    return endTime;
  }

  public void setEndTime(String endTime) {
    this.endTime = endTime;
  }

  public String getJobName() {
    return jobName;
  }

  public void setJobName(String jobName) {
    this.jobName = jobName;
  }

  public String getSource() {
    return source;
  }

  public void setSource(String source) {
    this.source = source;
  }

  public String getExecutionType() {
    return executionType;
  }

  public void setExecutionType(String executionType) {
    this.executionType = executionType;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getIp() {
    return ip;
  }

  public void setIp(String ip) {
    this.ip = ip;
  }

  public String getIsSuccess() {
    return isSuccess;
  }

  public void setIsSuccess(String isSuccess) {
    this.isSuccess = isSuccess;
  }

  public JobExecutionQueryInfo() {
    super();
    // TODO Auto-generated constructor stub
  }

  @Override
  public String toString() {
    return "JobExecutionQueryInfo [perPage=" + perPage + ", page=" + page + ", sort=" + sort + ", order=" + order + ", startTime=" + startTime + ", endTime=" + endTime + ", jobName=" + jobName + ", source=" + source + ", executionType=" + executionType + ", state=" + state + ", ip=" + ip + ", isSuccess=" + isSuccess + "]";
  }

}
