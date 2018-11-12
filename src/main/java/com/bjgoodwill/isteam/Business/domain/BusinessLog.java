package com.bjgoodwill.isteam.Business.domain;

import com.bjgoodwill.isteam.common.annotation.ExportConfig;
import com.bjgoodwill.isteam.system.domain.SysLog;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * @ClassName BizLog
 * @Description 业务日志实体
 * @Author LI JUN
 * @Date 2018/11/7 11:15
 * @Version 0.0.1
 */
@Table(name = "biz_log")
public class BusinessLog extends SysLog {
    /**
     * 账户状态（有效）
     */
    public static final String STATUS_SUCCESS = "0";
    /**
     * 账户状态（锁定）
     */
    public static final String STATUS_ERROR = "1";

    @Column(name = "STATUS")
    @ExportConfig(value = "状态", convert = "s:0=成功,1=异常")
    private String status = STATUS_SUCCESS;

    @Column(name = "EXCEPTION_TYPE")
    @ExportConfig(value = "异常类型")
    private String exceptionType;

    @Column(name = "STACKTRACE")
    @ExportConfig(value = "堆栈信息")
    private String stacktrace;

    @Column(name = "DESCRIPTION")
    @ExportConfig(value = "描述")
    private String description;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStacktrace() {
        return stacktrace;
    }

    public void setStacktrace(String stacktrace) {
        this.stacktrace = stacktrace;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExceptionType() {
        return exceptionType;
    }

    public void setExceptionType(String exceptionType) {
        this.exceptionType = exceptionType;
    }
}