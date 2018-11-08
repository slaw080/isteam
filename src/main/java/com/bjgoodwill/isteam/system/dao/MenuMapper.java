package com.bjgoodwill.isteam.system.dao;


import com.bjgoodwill.isteam.common.config.MyMapper;
import com.bjgoodwill.isteam.system.domain.Menu;

import java.util.List;

/**
 * @ClassName MenuMapper
 * @Description 菜单Mapper
 * @Author LI JUN
 * @Date 2018/11/7 11:15
 * @Version 0.0.1
 */
public interface MenuMapper extends MyMapper<Menu> {

    List<Menu> findUserPermissions(String userName);

    List<Menu> findUserMenus(String userName);

    // 删除父节点，子节点变成顶级节点（根据实际业务调整）
    void changeToTop(List<String> menuIds);
}