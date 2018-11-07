package com.bjgoodwill.isteam.system.domain;

import java.util.List;

/**
 * @ClassName UserWithRole
 * @Description 用户子实体
 * @Author LI JUN
 * @Date 2018/11/7 11:15
 * @Version 0.0.1
 */
public class UserWithRole extends User {

	private static final long serialVersionUID = -5680235862276163462L;

	private Long roleId;

	private List<Long> roleIds;

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public List<Long> getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(List<Long> roleIds) {
		this.roleIds = roleIds;
	}

}