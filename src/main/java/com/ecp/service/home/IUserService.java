package com.ecp.service.home;

import java.util.List;

import com.ecp.dto.Project;
import com.ecp.entity.home.Goods;
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
	 * 
	 * @param role
	 * @return
	 */
	public <T> List<T> getAll(String role);

	public <T> PageInfo<T> queryByPage(String role, Integer pageNo, Integer pageSize);

	/**
	 * 商品列表
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public List<Goods> getGoods();
	
	public Goods getGoods(Integer id);

	public <T> PageInfo<T> queryGoodsByPage(Integer pageNo, Integer pageSize);

	/**
	 * 加入购物车
	 * 
	 * @param buyerId
	 * @param goodId
	 * @return
	 */
	public boolean addCart(Integer buyerId, Integer goodId);

	/**
	 * 获取指定用户的购物车信息
	 * @param buyerId
	 * @return
	 */
	public List<Project> getCart(Integer buyerId);
}
