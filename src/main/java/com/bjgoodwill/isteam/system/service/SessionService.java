package com.bjgoodwill.isteam.system.service;


import com.bjgoodwill.isteam.system.domain.UserOnline;

import java.util.List;

public interface SessionService {

	List<UserOnline> list();

	boolean forceLogout(String sessionId);
}
