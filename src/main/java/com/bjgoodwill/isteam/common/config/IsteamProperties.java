package com.bjgoodwill.isteam.common.config;

import com.bjgoodwill.isteam.common.domain.ValidateCodeProperties;
import com.bjgoodwill.isteam.common.shiro.ShiroProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName IsteamProperties
 * @Description iSteam属性配置
 * @Author LI JUN
 * @Date 2018/11/7 11:00
 * @Version 0.0.1
 */
@Configuration
@ConfigurationProperties(prefix = "isteam")
public class IsteamProperties {
	private ShiroProperties shiro = new ShiroProperties();

	private ValidateCodeProperties validateCode = new ValidateCodeProperties();

	private String timeFormat = "yyyy-MM-dd HH:mm:ss";

	private boolean openAopLog = true;

	public ShiroProperties getShiro() {
		return shiro;
	}

	public void setShiro(ShiroProperties shiro) {
		this.shiro = shiro;
	}

	public ValidateCodeProperties getValidateCode() {
		return validateCode;
	}

	public void setValidateCode(ValidateCodeProperties validateCode) {
		this.validateCode = validateCode;
	}

	public String getTimeFormat() {
		return timeFormat;
	}

	public void setTimeFormat(String timeFormat) {
		this.timeFormat = timeFormat;
	}

	public boolean isOpenAopLog() {
		return openAopLog;
	}

	public void setOpenAopLog(boolean openAopLog) {
		this.openAopLog = openAopLog;
	}
}
