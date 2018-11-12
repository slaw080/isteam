package com.bjgoodwill.isteam.common.aspect;


import com.bjgoodwill.isteam.Business.domain.BusinessLog;
import com.bjgoodwill.isteam.Business.service.BizLogService;
import com.bjgoodwill.isteam.common.config.IsteamProperties;
import com.bjgoodwill.isteam.common.util.HttpContextUtils;
import com.bjgoodwill.isteam.common.util.IPUtils;
import com.bjgoodwill.isteam.system.domain.SysLog;
import com.bjgoodwill.isteam.system.domain.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName BizLogAspect
 * @Description 记录业务类日志
 * @Author LI JUN
 * @Date 2018/11/7 10:47
 * @Version 0.0.1
 */
@Aspect
@Component
public class BizLogAspect {

    private static Logger logger = LoggerFactory.getLogger(BizLogAspect.class);

    @Autowired
    private IsteamProperties isteamProperties;

    @Autowired
    private BizLogService bizLogService;


    @Pointcut("@annotation(com.bjgoodwill.isteam.common.annotation.BizLog)")
    public void pointcut() {
        // do nothing
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint point) {
        Object result = null;
        BusinessLog log = new BusinessLog();
        long beginTime = System.currentTimeMillis();
        try {
            // 执行方法
            result = point.proceed();
        } catch (Throwable e) {
            result = exceptionHandler(e, log);
        }
        try {
            saveBizLog(beginTime, point, log);
        } catch (JsonProcessingException e) {
            logger.debug(e.getMessage());
        }
        return result;
    }

    /**
     * @return
     * @Description TODO 判断各类异常，根据不同异常类型返回不同提示信息
     * @Date 16:17 2018/11/12
     * @Param
     */
    private Object exceptionHandler(Throwable e, BusinessLog log) {
        // 状态：错误
        log.setStatus(BusinessLog.STATUS_ERROR);
        log.setExceptionType(e.getClass().toString());
        StackTraceElement[] stackTraceElements = e.getStackTrace();
        List<String> stackTeace = new ArrayList<>();
        for (StackTraceElement stackTraceElement : stackTraceElements) {
            String className = stackTraceElement.getClassName();
            if (className.startsWith("com.bjgoodwill.isteam") && !className.contains("BySpringCGLIB")) {
                StringBuilder sb = new StringBuilder();
                sb.append("MethodName:");
                sb.append(stackTraceElement.getClassName());
                sb.append(".");
                sb.append(stackTraceElement.getMethodName());
                sb.append(" ");
                sb.append("LineNumber:");
                sb.append(stackTraceElement.getLineNumber());
                sb.append("\n");
                stackTeace.add(sb.toString());
            }
        }
        // 工程相关堆栈
        log.setStacktrace(stackTeace.toString());
        // 错误描述
        log.setDescription(e.getMessage());
        return "";
    }

    private void saveBizLog(long beginTime, ProceedingJoinPoint point, BusinessLog log) throws JsonProcessingException {
        // 获取request
        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
        // 设置IP地址
        String ip = IPUtils.getIpAddr(request);
        // 执行时长(毫秒)
        long time = System.currentTimeMillis() - beginTime;
        if (isteamProperties.isOpenAopLog()) {
            // 保存日志
            User user = (User) SecurityUtils.getSubject().getPrincipal();
            log.setUsername(user == null ? "zhongan" : user.getUsername());
            log.setIp(ip);
            log.setTime(time);
            bizLogService.saveLog(point, log);
        }
    }
}
