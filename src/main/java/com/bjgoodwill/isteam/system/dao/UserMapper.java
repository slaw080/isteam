package com.bjgoodwill.isteam.system.dao;


import com.bjgoodwill.isteam.common.config.MyMapper;
import com.bjgoodwill.isteam.system.domain.User;
import com.bjgoodwill.isteam.system.domain.UserWithRole;

import java.util.List;

/**
 * @ClassName UserMapper
 * @Description 用户Mapper
 * @Author LI JUN
 * @Date 2018/11/7 11:15
 * @Version 0.0.1
 */
public interface UserMapper extends MyMapper<User> {

    List<User> findUserWithDept(User user);

    List<UserWithRole> findUserWithRole(Long userId);

    User findUserProfile(User user);
}