package com.bjgoodwill.isteam.common.annotation;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @ClassName CronTag
 * @Description Cron表达式注解
 * @Author LI JUN
 * @Date 2018/11/7 10:47
 * @Version 0.0.1
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface CronTag {
    @AliasFor(value = "value", annotation = Component.class)
    String value() default "";
}
