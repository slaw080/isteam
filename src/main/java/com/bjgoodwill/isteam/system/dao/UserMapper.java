package com.bjgoodwill.isteam.system.dao;


import com.bjgoodwill.isteam.common.config.MyMapper;
import com.bjgoodwill.isteam.system.domain.User;
import com.bjgoodwill.isteam.system.domain.UserWithRole;

import java.util.List;

public interface UserMapper extends MyMapper<User> {

	List<User> findUserWithDept(User user);
	
	List<UserWithRole> findUserWithRole(Long userId);
	
	User findUserProfile(User user);
}