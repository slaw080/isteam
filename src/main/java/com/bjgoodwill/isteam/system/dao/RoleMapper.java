package com.bjgoodwill.isteam.system.dao;


import com.bjgoodwill.isteam.common.config.MyMapper;
import com.bjgoodwill.isteam.system.domain.Role;
import com.bjgoodwill.isteam.system.domain.RoleWithMenu;

import java.util.List;

/**
 * @ClassName RoleMapper
 * @Description 角色Mapper
 * @Author LI JUN
 * @Date 2018/11/7 11:15
 * @Version 0.0.1
 */
public interface RoleMapper extends MyMapper<Role> {

    List<Role> findUserRole(String userName);

    List<RoleWithMenu> findById(Long roleId);
}