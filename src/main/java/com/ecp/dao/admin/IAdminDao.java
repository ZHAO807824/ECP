package com.ecp.dao.admin;

import org.apache.ibatis.annotations.Param;

public interface IAdminDao {
	
	/*
	 * 根据用户名和密码获取管理员ID
	 */
	public Integer getAdmin(@Param("name") String name,@Param("password") String password);
	
}
