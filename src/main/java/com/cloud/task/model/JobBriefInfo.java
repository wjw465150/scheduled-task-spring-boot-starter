package com.cloud.task.model;

import java.io.Serializable;

/**
 * 作业简明信息对象.
 *
 */
public final class JobBriefInfo implements Serializable, Comparable<JobBriefInfo> {
  private static final long serialVersionUID = 8405751873086755148L;

  private String jobName;

  private JobStatus status;

  private String description;

  private String cron;

  private int instanceCount;

  private int shardingTotalCount;

  @Override
  public int compareTo(final JobBriefInfo o) {
    return getJobName().compareTo(o.getJobName());
  }

  /**
   * 作业状态.
   *
   * @author caohao
   */
  public enum JobStatus {
    OK, CRASHED, DISABLED, SHARDING_FLAG
  }

  public String getJobName() {
    return jobName;
  }

  public void setJobName(String jobName) {
    this.jobName = jobName;
  }

  public JobStatus getStatus() {
    return status;
  }

  public void setStatus(JobStatus status) {
    this.status = status;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getCron() {
    return cron;
  }

  public void setCron(String cron) {
    this.cron = cron;
  }

  public int getInstanceCount() {
    return instanceCount;
  }

  public void setInstanceCount(int instanceCount) {
    this.instanceCount = instanceCount;
  }

  public int getShardingTotalCount() {
    return shardingTotalCount;
  }

  public void setShardingTotalCount(int shardingTotalCount) {
    this.shardingTotalCount = shardingTotalCount;
  }

  public static long getSerialversionuid() {
    return serialVersionUID;
  }

  @Override
  public String toString() {
    return "JobBriefInfo [jobName=" + jobName + ", status=" + status + ", description=" + description + ", cron=" + cron + ", instanceCount=" + instanceCount + ", shardingTotalCount=" + shardingTotalCount + "]";
  }

  public JobBriefInfo() {
    super();
    // TODO Auto-generated constructor stub
  }

}
