package com.ecp.service.home;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.ecp.dao.home.IUserDao;

@Service
public class UserService implements IUserService {

	private Logger LOGGER = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private IUserDao userDao;

	public boolean login(String name, String password) {
		if (!StringUtils.isEmpty(name) && !StringUtils.isEmpty(password)) {
			try {
				Integer id = userDao.getBuyer(name, password);
				return id != null && id > 0 ? true : false;
			} catch (Exception e) {
				LOGGER.info("UserService," + e.getMessage());
				e.printStackTrace();
			}
		}
		return false;
	}

}
