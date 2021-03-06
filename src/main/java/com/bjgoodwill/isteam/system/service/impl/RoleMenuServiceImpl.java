package com.bjgoodwill.isteam.system.service.impl;


import com.bjgoodwill.isteam.common.service.impl.BaseService;
import com.bjgoodwill.isteam.system.domain.RoleMenu;
import com.bjgoodwill.isteam.system.service.RoleMenuServie;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName RoleMenuServiceImpl
 * @Description 角色→菜单服务实现类
 * @Author LI JUN
 * @Date 2018/11/7 11:24
 * @Version 0.0.1
 */
@Service("roleMenuService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class RoleMenuServiceImpl extends BaseService<RoleMenu> implements RoleMenuServie {

    @Override
    @Transactional
    public void deleteRoleMenusByRoleId(String roleIds) {
        List<String> list = Arrays.asList(roleIds.split(","));
        this.batchDelete(list, "roleId", RoleMenu.class);
    }

    @Override
    @Transactional
    public void deleteRoleMenusByMenuId(String menuIds) {
        List<String> list = Arrays.asList(menuIds.split(","));
        this.batchDelete(list, "menuId", RoleMenu.class);
    }

}
