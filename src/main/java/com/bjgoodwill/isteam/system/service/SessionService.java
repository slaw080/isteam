package com.bjgoodwill.isteam.system.service;


import com.bjgoodwill.isteam.system.domain.UserOnline;

import java.util.List;

/**
 * @ClassName SessionService
 * @Description Session服务
 * @Author LI JUN
 * @Date 2018/11/7 11:24
 * @Version 0.0.1
 */
public interface SessionService {

    List<UserOnline> list();

    boolean forceLogout(String sessionId);
}
