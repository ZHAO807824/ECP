package com.ecp.service.home;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.ecp.dao.home.IUserDao;
import com.ecp.entity.home.Buyer;
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

}
