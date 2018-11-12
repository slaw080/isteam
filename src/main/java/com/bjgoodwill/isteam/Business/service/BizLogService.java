package com.bjgoodwill.isteam.Business.service;


import com.bjgoodwill.isteam.Business.domain.BusinessLog;
import com.bjgoodwill.isteam.common.service.IService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.scheduling.annotation.Async;

import java.util.List;

/**
 * @ClassName BizLogService
 * @Description 业务日志服务
 * @Author LI JUN
 * @Date 2018/11/7 11:24
 * @Version 0.0.1
 */
public interface BizLogService extends IService<BusinessLog> {

    List<BusinessLog> findAllLogs(BusinessLog log);

    void deleteLogs(String logIds);

    @Async
    void saveLog(ProceedingJoinPoint point, BusinessLog log) throws JsonProcessingException;
}
