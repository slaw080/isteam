package com.bjgoodwill.isteam;

import com.bjgoodwill.isteam.common.config.IsteamProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.time.LocalDate;
import java.time.LocalTime;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.bjgoodwill.isteam.*.dao")
@EnableConfigurationProperties({IsteamProperties.class})
@EnableCaching
@EnableAsync
public class IsteamApplication {

	private static Logger logger = LoggerFactory.getLogger(IsteamApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(IsteamApplication.class, args);
		logger.info("iSteam started up successfully at {} {}", LocalDate.now(), LocalTime.now());
		logger.info("登录URL:" +"http://127.0.0.1:8080/index");
	}
}
