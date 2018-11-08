package com.bjgoodwill.isteam.system.service;


import com.bjgoodwill.isteam.common.service.IService;
import com.bjgoodwill.isteam.system.domain.Role;
import com.bjgoodwill.isteam.system.domain.RoleWithMenu;

import java.util.List;

/**
 * @ClassName RoleService
 * @Description 角色菜单服务
 * @Author LI JUN
 * @Date 2018/11/7 11:24
 * @Version 0.0.1
 */
public interface RoleService extends IService<Role> {

    List<Role> findUserRole(String userName);

    List<Role> findAllRole(Role role);

    RoleWithMenu findRoleWithMenus(Long roleId);

    Role findByName(String roleName);

    void addRole(Role role, Long[] menuIds);

    void updateRole(Role role, Long[] menuIds);

    void deleteRoles(String roleIds);
}
