package com.cloud.task.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperConfiguration;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;

/**
 * 生成ZookeeperConfiguration和ZookeeperRegistryCenter的Bean的SB配置类<br>
 * 参见: {@link com.dangdang.ddframe.job.reg.zookeeper.ZookeeperConfiguration}, <br>
 * {@link com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter}
 *
 * @author number68
 * @date 2019/4/23
 * @since 0.1
 */
@Configuration
public class ZookeeperConfig {
  /**
   * 连接Zookeeper服务器的列表.
   * 包括IP地址和端口号.
   * 多个地址用逗号分隔.
   * 如: host1:2181,host2:2181
   */
    @Value("${zookeeper.serviceLists}")
    private String serviceLists;

    /**
     * 命名空间.
     */
    @Value("${zookeeper.namespace}")
    private String nameSpace;

    /**
     * 等待重试的间隔时间的初始值.
     * 单位毫秒.
     */
    @Value("${zookeeper.baseSleepTimeMilliseconds:1000}")
    private int baseSleepTimeMilliseconds;

    /**
     * 等待重试的间隔时间的最大值.
     * 单位毫秒.
     */
    @Value("${zookeeper.maxSleepTimeMilliseconds:3000}")
    private int maxSleepTimeMilliseconds;

    /**
     * 最大重试次数.
     */
    @Value("${zookeeper.maxRetries:3}")
    private int maxRetries;

    
    public String getServiceLists() {
      return serviceLists;
    }

    public void setServiceLists(String serviceLists) {
      this.serviceLists = serviceLists;
    }

    public String getNameSpace() {
      return nameSpace;
    }

    public void setNameSpace(String nameSpace) {
      this.nameSpace = nameSpace;
    }

    public int getBaseSleepTimeMilliseconds() {
      return baseSleepTimeMilliseconds;
    }

    public void setBaseSleepTimeMilliseconds(int baseSleepTimeMilliseconds) {
      this.baseSleepTimeMilliseconds = baseSleepTimeMilliseconds;
    }

    public int getMaxSleepTimeMilliseconds() {
      return maxSleepTimeMilliseconds;
    }

    public void setMaxSleepTimeMilliseconds(int maxSleepTimeMilliseconds) {
      this.maxSleepTimeMilliseconds = maxSleepTimeMilliseconds;
    }

    public int getMaxRetries() {
      return maxRetries;
    }

    public void setMaxRetries(int maxRetries) {
      this.maxRetries = maxRetries;
    }

    @Bean
    public ZookeeperConfiguration zkConfig() {
        ZookeeperConfiguration configuration = new ZookeeperConfiguration(serviceLists, nameSpace);
        configuration.setBaseSleepTimeMilliseconds(baseSleepTimeMilliseconds);
        configuration.setMaxSleepTimeMilliseconds(maxSleepTimeMilliseconds);
        configuration.setMaxRetries(maxRetries);
        return configuration;
    }

    /**
     * zookeeper registry center bean
     * @return
     */
    @Bean(initMethod = "init")
    public ZookeeperRegistryCenter zookeeperRegistryCenter(ZookeeperConfiguration configuration) {
        return new ZookeeperRegistryCenter(configuration);
    }

}
