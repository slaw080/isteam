package com.bjgoodwill.isteam.system.service;


import com.bjgoodwill.isteam.common.service.IService;
import com.bjgoodwill.isteam.system.domain.RoleMenu;

/**
 * @ClassName RoleMenuServie
 * @Description 角色→菜单服务
 * @Author LI JUN
 * @Date 2018/11/7 11:24
 * @Version 0.0.1
 */
public interface RoleMenuServie extends IService<RoleMenu> {

    void deleteRoleMenusByRoleId(String roleIds);

    void deleteRoleMenusByMenuId(String menuIds);
}
