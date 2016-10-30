package com.ecp.dao.home;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ecp.entity.home.Buyer;
import com.ecp.entity.home.Cart;
import com.ecp.entity.home.Goods;
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

	public List<Goods> getGoods();
	
	public Goods getGoodsById(@Param("id") Integer id);

	/*
	 * 插入购物车
	 */
	public void insertCart(@Param("buyerId") Integer buyerId, @Param("goodId") Integer goodId);

	public void addCart(@Param("id") Integer id, @Param("number") Integer number);

	public Cart getCart(@Param("buyerId") Integer buyerId, @Param("goodId") Integer goodId);

	public List<Cart> getCarts();
}
