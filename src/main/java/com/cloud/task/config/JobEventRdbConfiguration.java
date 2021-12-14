package com.cloud.task.config;

import java.io.Serializable;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.cloud.task.listener.JobEventRdbListener;
import com.dangdang.ddframe.job.event.JobEventConfiguration;
import com.dangdang.ddframe.job.event.JobEventListener;
import com.dangdang.ddframe.job.event.JobEventListenerConfigurationException;
import com.dangdang.ddframe.job.event.rdb.JobEventRdbIdentity;

/**
 *〈job event 数据库配置〉<br> 
 *
 * @author number68
 * @date 2019/4/26
 * @since 0.1
 */
public final class JobEventRdbConfiguration extends JobEventRdbIdentity implements JobEventConfiguration, Serializable {

    private static final long serialVersionUID = 3344410699286435226L;

    private final transient DataSource dataSource;

    @Override
    public JobEventListener createJobEventListener() throws JobEventListenerConfigurationException {
        try {
            return new JobEventRdbListener(dataSource);
        } catch (final SQLException ex) {
            throw new JobEventListenerConfigurationException(ex);
        }
    }

    public JobEventRdbConfiguration(DataSource dataSource) {
      super();
      this.dataSource = dataSource;
    }

    public static long getSerialversionuid() {
      return serialVersionUID;
    }
    
}
