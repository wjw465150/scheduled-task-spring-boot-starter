package com.cloud.task.model;

import java.io.Serializable;

/**
 * 作业分片信息对象.
 *
 */
public final class ShardingInfo implements Serializable, Comparable<ShardingInfo> {

  private static final long serialVersionUID = 8587397581949456718L;

  private int item;

  private String serverIp;

  private String instanceId;

  private ShardingStatus status;

  private boolean failover;

  @Override
  public int compareTo(final ShardingInfo o) {
    return getItem() - o.getItem();
  }

  /**
   * 作业分片状态.
   *
   * @author caohao
   */
  public enum ShardingStatus {

    DISABLED, RUNNING, SHARDING_FLAG, PENDING;

    /**
     * 获取分片状态.
     * 
     * @param isDisabled 是否被禁用
     * @param isRunning 是否在运行
     * @param isShardingFlag 是否需要分片
     * @return 作业运行时状态
     */
    public static ShardingStatus getShardingStatus(final boolean isDisabled, final boolean isRunning,
        final boolean isShardingFlag) {
      if (isDisabled) {
        return DISABLED;
      }
      if (isRunning) {
        return RUNNING;
      }
      if (isShardingFlag) {
        return SHARDING_FLAG;
      }
      return PENDING;
    }
  }

  public int getItem() {
    return item;
  }

  public void setItem(int item) {
    this.item = item;
  }

  public String getServerIp() {
    return serverIp;
  }

  public void setServerIp(String serverIp) {
    this.serverIp = serverIp;
  }

  public String getInstanceId() {
    return instanceId;
  }

  public void setInstanceId(String instanceId) {
    this.instanceId = instanceId;
  }

  public ShardingStatus getStatus() {
    return status;
  }

  public void setStatus(ShardingStatus status) {
    this.status = status;
  }

  public boolean isFailover() {
    return failover;
  }

  public void setFailover(boolean failover) {
    this.failover = failover;
  }

  public static long getSerialversionuid() {
    return serialVersionUID;
  }

  public ShardingInfo() {
    super();
    // TODO Auto-generated constructor stub
  }

  @Override
  public String toString() {
    return "ShardingInfo [item=" + item + ", serverIp=" + serverIp + ", instanceId=" + instanceId + ", status=" + status + ", failover=" + failover + "]";
  }

}
