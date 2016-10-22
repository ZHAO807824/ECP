package com.ecp.service.home;

import java.util.List;

import com.github.pagehelper.PageInfo;

public interface IUserService {

	/**
	 * 用户登录:
	 * 
	 * @param name
	 * @param password
	 * @param role
	 *            0:普通用户,1:商家
	 * @return
	 */
	public <T> T login(String name, String password, String role);

	/**
	 * 用户注册
	 * 
	 * @param t
	 * @param role
	 *            0:普通用户,1:商家
	 */
	public <T> boolean register(T t, String role);
	
	/**
	 * 列表
	 * @param role
	 * @return
	 */
	public <T> List<T> getAll(String role);
	
	public <T> PageInfo<T> queryByPage(String role,Integer pageNo,Integer pageSize);
}
