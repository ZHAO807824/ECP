package com.ecp.service.home;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.ecp.dao.home.IUserDao;
import com.ecp.dto.Project;
import com.ecp.entity.home.Buyer;
import com.ecp.entity.home.Cart;
import com.ecp.entity.home.Goods;
import com.ecp.entity.home.Seller;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class UserService implements IUserService {

	private Logger LOGGER = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private IUserDao userDao;

	@SuppressWarnings("unchecked")
	public <T> T login(String name, String password, String role) {
		if (!StringUtils.isEmpty(name) && !StringUtils.isEmpty(password) && !StringUtils.isEmpty(role)) {
			try {
				T t = null;
				// 0:普通用户
				if ("0".equals(role.trim())) {
					t = (T) userDao.getBuyer(name, password);
				}
				// 1:商家
				else if ("1".equals(role.trim())) {
					t = (T) userDao.getSeller(name, password);
				}
				return t;
			} catch (Exception e) {
				LOGGER.info("UserService login," + e.getMessage());
				e.printStackTrace();
			}
		}
		return null;
	}

	public <T> boolean register(T t, String role) {
		if (t != null && !StringUtils.isEmpty(role)) {
			try {
				// 0:普通用户
				if ("0".equals(role.trim())) {
					userDao.insertBuyer((Buyer) t);
				}
				// 1:商家
				else if ("1".equals(role.trim())) {
					userDao.insertSeller((Seller) t);
				}
				return true;
			} catch (Exception e) {
				LOGGER.info("UserService login," + e.getMessage());
				e.printStackTrace();
			}
		}
		return false;
	}

	public <T> List<T> getAll(String role) {

		return null;
	}

	@SuppressWarnings("unchecked")
	public <T> PageInfo<T> queryByPage(String role, Integer pageNo, Integer pageSize) {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		// 普通用户
		if ("0".equals(role.trim())) {
			List<Buyer> list = userDao.getBuyers();
			// 用PageInfo对结果进行包装
			PageInfo<Buyer> pageInfo = new PageInfo<Buyer>(list);
			return (PageInfo<T>) pageInfo;
		}
		// 商家
		else if ("1".equals(role.trim())) {
			List<Seller> list = userDao.getSellers();
			// 用PageInfo对结果进行包装
			PageInfo<Seller> pageInfo = new PageInfo<Seller>(list);
			return (PageInfo<T>) pageInfo;
		}

		return null;
	}

	@SuppressWarnings("unchecked")
	public <T> PageInfo<T> queryGoodsByPage(Integer pageNo, Integer pageSize) {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		List<Goods> list = userDao.getGoods();
		// 用PageInfo对结果进行包装
		PageInfo<Goods> pageInfo = new PageInfo<Goods>(list);
		return (PageInfo<T>) pageInfo;
	}

	public List<Goods> getGoods() {
		return userDao.getGoods();
	}

	public boolean addCart(Integer buyerId, Integer goodId) {
		if (buyerId != null && goodId != null) {
			try {
				// 先判断在购物车中是否有其存在,如果有,数量加1
				Cart cart = null;
				try {
					cart = userDao.getCart(buyerId, goodId);
				} catch (Exception e) {
				}
				if (cart != null && cart.getNumber() != 0) {
					Integer number = cart.getNumber() + 1;
					userDao.addCart(cart.getId(), number);
				} else {
					userDao.insertCart(buyerId, goodId);
				}
				return true;
			} catch (Exception e) {
				LOGGER.info("UserService addCart," + e.getMessage());
				e.printStackTrace();
			}
		}
		return false;
	}

	public List<Project> getCart(Integer buyerId) {
		List<Cart> carts = userDao.getCarts();
		List<Project> list = new ArrayList<Project>();
		if (carts != null && carts.size() > 0) {
			for (Cart cart : carts) {
				Project project = new Project(cart);
				// 根据goodId获取商品名称
				Goods good = userDao.getGoodsById(cart.getGoodId());
				project.setName(good.getName());
				project.setPrice(good.getPrice());
				list.add(project);
			}
		}
		return list;
	}

	public Goods getGoods(Integer id) {
		return userDao.getGoodsById(id);
	}
}
