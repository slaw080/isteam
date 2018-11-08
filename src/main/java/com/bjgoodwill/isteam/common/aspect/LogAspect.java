package com.bjgoodwill.isteam.common.aspect;


import com.bjgoodwill.isteam.common.config.IsteamProperties;
import com.bjgoodwill.isteam.common.util.HttpContextUtils;
import com.bjgoodwill.isteam.common.util.IPUtils;
import com.bjgoodwill.isteam.system.domain.SysLog;
import com.bjgoodwill.isteam.system.domain.User;
import com.bjgoodwill.isteam.system.service.LogService;
import com.fasterxml.jackson.core.JsonProcessingException;
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

/**
 * @ClassName LogAspect
 * @Description 记录用户操作日志
 * @Author LI JUN
 * @Date 2018/11/7 10:47
 * @Version 0.0.1
 */
@Aspect
@Component
public class LogAspect {

    private static Logger log = LoggerFactory.getLogger(LogAspect.class);

    @Autowired
    private IsteamProperties isteamProperties;

    @Autowired
    private LogService logService;


    @Pointcut("@annotation(com.bjgoodwill.isteam.common.annotation.Log)")
    public void pointcut() {
        // do nothing
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint point) throws JsonProcessingException {
        Object result = null;
        long beginTime = System.currentTimeMillis();
        try {
            // 执行方法
            result = point.proceed();
        } catch (Throwable e) {
            log.error(e.getMessage());
        }
        // 获取request
        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
        // 设置IP地址
        String ip = IPUtils.getIpAddr(request);
        // 执行时长(毫秒)
        long time = System.currentTimeMillis() - beginTime;
        if (isteamProperties.isOpenAopLog()) {
            // 保存日志
            User user = (User) SecurityUtils.getSubject().getPrincipal();
            SysLog log = new SysLog();
            log.setUsername(user.getUsername());
            log.setIp(ip);
            log.setTime(time);
            logService.saveLog(point, log);
        }
        return result;
    }
}
