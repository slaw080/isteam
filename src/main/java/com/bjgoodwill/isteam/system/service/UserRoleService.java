package com.bjgoodwill.isteam.system.service;


import com.bjgoodwill.isteam.common.service.IService;
import com.bjgoodwill.isteam.system.domain.UserRole;

/**
 * @ClassName UserRoleService
 * @Description 用户→角色服务
 * @Author LI JUN
 * @Date 2018/11/7 11:24
 * @Version 0.0.1
 */
public interface UserRoleService extends IService<UserRole> {

    void deleteUserRolesByRoleId(String roleIds);

    void deleteUserRolesByUserId(String userIds);
}
