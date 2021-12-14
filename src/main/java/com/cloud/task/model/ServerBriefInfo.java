package com.cloud.task.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 服务器维度简明信息对象.
 *
 */
public final class ServerBriefInfo implements Serializable, Comparable<ServerBriefInfo> {

    private static final long serialVersionUID = 1133149706443681483L;

    private final String serverIp;

    private final Set<String> instances = new HashSet<>();

    private final Set<String> jobNames = new HashSet<>();

    private int instancesNum;

    private int jobsNum;

    private AtomicInteger disabledJobsNum = new AtomicInteger();

    @Override
    public int compareTo(final ServerBriefInfo o) {
        return (getServerIp()).compareTo(o.getServerIp());
    }

    public int getInstancesNum() {
      return instancesNum;
    }

    public void setInstancesNum(int instancesNum) {
      this.instancesNum = instancesNum;
    }

    public int getJobsNum() {
      return jobsNum;
    }

    public void setJobsNum(int jobsNum) {
      this.jobsNum = jobsNum;
    }

    public AtomicInteger getDisabledJobsNum() {
      return disabledJobsNum;
    }

    public void setDisabledJobsNum(AtomicInteger disabledJobsNum) {
      this.disabledJobsNum = disabledJobsNum;
    }

    public static long getSerialversionuid() {
      return serialVersionUID;
    }

    public String getServerIp() {
      return serverIp;
    }

    public Set<String> getInstances() {
      return instances;
    }

    public Set<String> getJobNames() {
      return jobNames;
    }

    public ServerBriefInfo(String serverIp) {
      super();
      this.serverIp = serverIp;
    }

    @Override
    public String toString() {
      return "ServerBriefInfo [serverIp=" + serverIp + ", instances=" + instances + ", jobNames=" + jobNames + ", instancesNum=" + instancesNum + ", jobsNum=" + jobsNum + ", disabledJobsNum=" + disabledJobsNum + "]";
    }
    
}
