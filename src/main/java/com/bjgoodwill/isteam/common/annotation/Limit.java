package com.bjgoodwill.isteam.common.annotation;


import com.bjgoodwill.isteam.common.domain.LimitType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName Limit
 * @Description 访问限制注解
 * @Author LI JUN
 * @Date 2018/11/7 10:47
 * @Version 0.0.1
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Limit {

    // 资源名称，用于描述接口功能
    String name() default "";

    // 资源 key
    String key() default "";

    // key prefix
    String prefix() default "";

    // 时间的，单位秒
    int period();

    // 限制访问次数
    int count();

    // 限制类型
    LimitType limitType() default LimitType.CUSTOMER;
}
