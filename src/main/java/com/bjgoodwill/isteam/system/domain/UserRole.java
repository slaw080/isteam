package com.bjgoodwill.isteam.system.domain;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @ClassName UserOnline
 * @Description 用户→角色关系实体
 * @Author LI JUN
 * @Date 2018/11/7 11:15
 * @Version 0.0.1
 */
@Table(name = "sys_user_role")
public class UserRole implements Serializable {

	private static final long serialVersionUID = -3166012934498268403L;

	@Column(name = "USER_ID")
	private Long userId;

	@Column(name = "ROLE_ID")
	private Long roleId;

	/**
	 * @return USER_ID
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

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
}