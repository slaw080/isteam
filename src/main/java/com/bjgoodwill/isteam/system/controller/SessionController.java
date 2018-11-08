package com.bjgoodwill.isteam.system.controller;


import com.bjgoodwill.isteam.common.annotation.Log;
import com.bjgoodwill.isteam.common.domain.ResponseBo;
import com.bjgoodwill.isteam.system.domain.UserOnline;
import com.bjgoodwill.isteam.system.service.SessionService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName SessionController
 * @Description 会话控制器
 * @Author LI JUN
 * @Date 2018/11/7 11:15
 * @Version 0.0.1
 */
@Controller
public class SessionController {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
	SessionService sessionService;

    @Log("获取在线用户信息")
    @RequestMapping("session")
    @RequiresPermissions("session:list")
    public String online() {
        return "system/monitor/online";
    }

    @ResponseBody
    @RequestMapping("session/list")
    @RequiresPermissions("session:list")
    public Map<String, Object> list() {
        List<UserOnline> list = sessionService.list();
        Map<String, Object> rspData = new HashMap<>();
        rspData.put("rows", list);
        rspData.put("total", list.size());
        return rspData;
    }

    @ResponseBody
    @RequiresPermissions("user:kickout")
    @RequestMapping("session/forceLogout")
    public ResponseBo forceLogout(String id) {
        try {
            sessionService.forceLogout(id);
            return ResponseBo.ok();
        } catch (Exception e) {
            log.error("踢出用户失败", e);
            return ResponseBo.error("踢出用户失败");
        }

    }
}
