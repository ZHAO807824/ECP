package com.ecp.dao.home;

import org.apache.ibatis.annotations.Param;

public interface IUserDao {

	/*
	 * 根据用户名和密码获取用户ID
	 */
	public Integer getBuyer(@Param("name") String name,@Param("password") String password);
}
