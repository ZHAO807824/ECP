package com.ecp.dao.home;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ecp.entity.home.Buyer;
import com.ecp.entity.home.Seller;

public interface IUserDao {

	/*
	 * 根据用户名和密码获取用户
	 */
	public Buyer getBuyer(@Param("name") String name, @Param("password") String password);

	public Seller getSeller(@Param("name") String name, @Param("password") String password);

	/*
	 * 插入用户
	 */
	public void insertBuyer(Buyer buyer);

	public void insertSeller(Seller seller);
	
	/*
	 * 遍历
	 */
	public List<Buyer> getBuyers();
	
	public List<Seller> getSellers();
}
