package com.bjgoodwill.isteam.common.config;

import com.bjgoodwill.isteam.common.xss.XssFilter;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName WebConfig
 * @Description Web配置
 * @Author LI JUN
 * @Date 2018/11/7 10:47
 * @Version 0.0.1
 */
@Configuration
@SuppressWarnings("unchecked")
public class WebConfig {

    /**
     * XssFilter Bean
     */
    @Bean
    public FilterRegistrationBean xssFilterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new XssFilter());
        filterRegistrationBean.setOrder(1);
        filterRegistrationBean.setEnabled(true);
        filterRegistrationBean.addUrlPatterns("/*");
        Map<String, String> initParameters = new HashMap<>();
        initParameters.put("excludes", "/favicon.ico,/img/*,/js/*,/css/*");
        initParameters.put("isIncludeRichText", "true");
        filterRegistrationBean.setInitParameters(initParameters);
        return filterRegistrationBean;
    }

    @Bean
    public ObjectMapper getObjectMapper(IsteamProperties isteamProperties) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setDateFormat(new SimpleDateFormat(isteamProperties.getTimeFormat()));
        return mapper;
    }

}