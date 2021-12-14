package com.cloud.task;

import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan
@ServletComponentScan
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class ScheduledTaskAutoConfiguration {

}
