package com.bjgoodwill.isteam.common.exception;

/**
 * @ClassName LimitAccessException
 * @Description 访问限制相关异常
 * @Author LI JUN
 * @Date 2018/11/7 10:47
 * @Version 0.0.1
 */
public class LimitAccessException extends Exception {

    private static final long serialVersionUID = -3608667856397125671L;

    public LimitAccessException(String message) {
        super(message);
    }
}