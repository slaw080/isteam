package com.bjgoodwill.isteam.system.service;


import com.bjgoodwill.isteam.common.service.IService;
import com.bjgoodwill.isteam.system.domain.SysLog;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.scheduling.annotation.Async;

import java.util.List;

/**
 * @ClassName LogService
 * @Description 日志服务
 * @Author LI JUN
 * @Date 2018/11/7 11:24
 * @Version 0.0.1
 */
public interface LogService extends IService<SysLog> {

    List<SysLog> findAllLogs(SysLog log);

    void deleteLogs(String logIds);

    @Async
    void saveLog(ProceedingJoinPoint point, SysLog log) throws JsonProcessingException;
}
