package com.cloud.task.controller;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.task.model.JobExecutionQueryInfo;
import com.dangdang.ddframe.job.event.JobEventConfiguration;
import com.dangdang.ddframe.job.event.rdb.JobEventRdbSearch;
import com.dangdang.ddframe.job.event.type.JobExecutionEvent;
import com.dangdang.ddframe.job.event.type.JobStatusTraceEvent;

/**
 *〈EventTraceHistoryController〉<br>
 *
 * @author number68
 * @date 2019/4/28
 * @since 0.1
 */
@RestController
@RequestMapping("/api/event-trace")
public class EventTraceHistoryController {
  private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    @Qualifier("defaultJobEventConfiguration")
    private JobEventConfiguration jobEventConfiguration;

    /**
     * 查询作业执行事件.
     * 
     * @param queryParams 查询条件
     * @return 运行痕迹事件结果集
     * @throws ParseException 解析异常
     */
    @PostMapping(value = "/execution")
    public JobEventRdbSearch.Result<JobExecutionEvent> findJobExecutionEvents(
        @RequestBody(required = false) final JobExecutionQueryInfo queryParams) throws ParseException {
        if (null == queryParams) {
            return null;
        }

        DataSource dataSource = null;
        if( jobEventConfiguration instanceof com.cloud.task.config.JobEventRdbConfiguration) {
          dataSource = ((com.cloud.task.config.JobEventRdbConfiguration) jobEventConfiguration).getDataSource();
        }
        
        JobEventRdbSearch jobEventRdbSearch = new JobEventRdbSearch(dataSource);
        return jobEventRdbSearch
            .findJobExecutionEvents(buildCondition(queryParams, new String[] {"jobName", "ip", "isSuccess"}));
    }

    /**
     * 查询作业状态事件.
     *
     * @param queryParams 查询条件
     * @return 运行痕迹事件结果集
     * @throws ParseException 解析异常
     */
    @PostMapping("/status")
    public JobEventRdbSearch.Result<JobStatusTraceEvent> findJobStatusTraceEvents(
        @RequestBody(required = false) final JobExecutionQueryInfo queryParams) throws ParseException {
        if (null == queryParams) {
            return null;
        }

        DataSource dataSource = null;
        if( jobEventConfiguration instanceof com.cloud.task.config.JobEventRdbConfiguration) {
          dataSource = ((com.cloud.task.config.JobEventRdbConfiguration) jobEventConfiguration).getDataSource();
        }
        
        JobEventRdbSearch jobEventRdbSearch = new JobEventRdbSearch(dataSource);
        return jobEventRdbSearch.findJobStatusTraceEvents(
            buildCondition(queryParams, new String[] {"jobName", "source", "executionType", "state"}));
    }

    private JobEventRdbSearch.Condition buildCondition(final JobExecutionQueryInfo info, final String[] params)
        throws ParseException {
        int perPage = 10;
        int page = 1;
        if (StringUtils.hasLength(info.getPerPage())) {
            perPage = Integer.parseInt(info.getPerPage());
        }
        if (StringUtils.hasLength(info.getPage())) {
            page = Integer.parseInt(info.getPage());
        }

        String sort = info.getSort();
        String order = info.getOrder();
        Date startTime = null;
        Date endTime = null;
        Map<String, Object> fields = getQueryParameters(info, params);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (StringUtils.hasLength(info.getStartTime())) {
            startTime = simpleDateFormat.parse(info.getStartTime());
        }
        if (StringUtils.hasLength(info.getEndTime())) {
            endTime = simpleDateFormat.parse(info.getEndTime());
        }
        return new JobEventRdbSearch.Condition(perPage, page, sort, order, startTime, endTime, fields);
    }

    private Map<String, Object> getQueryParameters(final JobExecutionQueryInfo info, final String[] params) {
        final Map<String, Object> result = new HashMap<>();
        for (String each : params) {
            try {
                Field field = JobExecutionQueryInfo.class.getDeclaredField(each);
                field.setAccessible(true);
                String value = (String)field.get(info);
                if (StringUtils.hasLength(value)) {
                    result.put(each, value);
                }
            } catch (NoSuchFieldException | IllegalAccessException e) {
                log.warn("JobExecutionQueryInfo has no field:{}", each);
                continue;
            }
        }
        return result;
    }
}
