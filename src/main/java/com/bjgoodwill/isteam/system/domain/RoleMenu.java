package com.bjgoodwill.isteam.system.domain;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @ClassName RoleMenu
 * @Description 角色→菜单关系实体
 * @Author LI JUN
 * @Date 2018/11/7 11:15
 * @Version 0.0.1
 */
@Table(name = "sys_role_menu")
public class RoleMenu implements Serializable {
	
	private static final long serialVersionUID = -7573904024872252113L;

	@Column(name = "ROLE_ID")
    private Long roleId;

    @Column(name = "MENU_ID")
    private Long menuId;

    /**
     * @return ROLE_ID
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * @param roleId
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /**
     * @return MENU_ID
     */
    public Long getMenuId() {
        return menuId;
    }

    /**
     * @param menuId
     */
    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }
}