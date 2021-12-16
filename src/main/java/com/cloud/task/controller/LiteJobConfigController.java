package com.cloud.task.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.task.api.IJobAPIService;
import com.cloud.task.model.Job;

/**
 * 作业配置的RESTful API.
 *
 */
@RestController
@RequestMapping("/api/jobs/config")
public class LiteJobConfigController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
  
    @Autowired
    private IJobAPIService jobAPIService;

    /**
     * 获取作业配置.
     * 
     * @param jobName 作业名称
     * @return 作业配置
     */
    @GetMapping("/{jobName}")
    public Job getJobSettings(@PathVariable final String jobName) {
        return jobAPIService.getJobSettingsAPI().getJobSettings(jobName);
    }

    /**
     * 修改作业配置.
     * 
     * @param jobSettings 作业配置
     */
    @PostMapping("/update")
    public void updateJobSettings(@RequestBody final Job jobSettings) {
        jobAPIService.getJobSettingsAPI().updateJobSettings(jobSettings);
    }

    /**
     * 删除作业配置.
     * 
     * @param jobName 作业名称
     */
    @DeleteMapping("/{jobName}")
    public void removeJob(@PathVariable final String jobName) {
        jobAPIService.getJobSettingsAPI().removeJobSettings(jobName);
    }
}
