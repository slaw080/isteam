package com.bjgoodwill.isteam.system.service.impl;


import com.bjgoodwill.isteam.common.service.impl.BaseService;
import com.bjgoodwill.isteam.system.domain.UserRole;
import com.bjgoodwill.isteam.system.service.UserRoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName UserRoleServiceImpl
 * @Description 用户→角色服务实现类
 * @Author LI JUN
 * @Date 2018/11/7 11:24
 * @Version 0.0.1
 */
@Service("userRoleService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class UserRoleServiceImpl extends BaseService<UserRole> implements UserRoleService {

    @Override
    @Transactional
    public void deleteUserRolesByRoleId(String roleIds) {
        List<String> list = Arrays.asList(roleIds.split(","));
        this.batchDelete(list, "roleId", UserRole.class);
    }

    @Override
    @Transactional
    public void deleteUserRolesByUserId(String userIds) {
        List<String> list = Arrays.asList(userIds.split(","));
        this.batchDelete(list, "userId", UserRole.class);
    }

}
