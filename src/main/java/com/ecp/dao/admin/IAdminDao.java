package com.ecp.dao.admin;

import org.apache.ibatis.annotations.Param;

import com.ecp.entity.admin.Admin;

public interface IAdminDao {
	
	/*
	 * 根据用户名和密码获取管理员ID
	 */
	public Admin getAdmin(@Param("name") String name,@Param("password") String password);
	
	public void updatePassword(@Param("id") Integer id,@Param("password") String password);
}
