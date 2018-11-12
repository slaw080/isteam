package com.bjgoodwill.isteam.Business.service.impl;

import com.bjgoodwill.isteam.Business.service.BizService;
import com.bjgoodwill.isteam.common.annotation.BizLog;
import com.bjgoodwill.isteam.common.util.WebServiceUtils;
import org.springframework.stereotype.Service;

/**
 * @ClassName BizServiceImpl
 * @Description 业务类服务接口实现类
 * @Author LI JUN
 * @Date 2018/11/12 14:04
 * @Version 0.0.1
 */
@Service
public class BizServiceImpl implements BizService {
    @Override
    @BizLog("获取患者基本信息")
    public String getPatientInfo(String string) throws Exception {
        WebServiceUtils.WebServiceUtils("hello");
        if(true){
            throw  new NullPointerException();
        }
        return "patientInfo"+ string;
    }
}
