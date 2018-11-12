package com.bjgoodwill.isteam.Business.controller;

import com.bjgoodwill.isteam.Business.service.BizService;
import com.bjgoodwill.isteam.common.controller.BaseController;
import com.bjgoodwill.isteam.system.domain.User;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName BizController
 * @Description TODO
 * @Author LI JUN
 * @Date 2018/11/12 13:57
 * @Version 0.0.1
 */
@RestController
@RequestMapping(value = "/test")
public class BizController {
    private Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    BizService bizService;

    @RequestMapping(value ="/getPatientInfo")
    public String getPatientInfo(String requestString) throws Exception {
        return bizService.getPatientInfo("hello ");
    }
}
