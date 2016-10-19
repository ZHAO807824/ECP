package com.ecp.service.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.ecp.dao.admin.IAdminDao;
import com.ecp.entity.admin.Admin;

@Service
public class AdminService implements IAdminService {

	private Logger LOGGER = LoggerFactory.getLogger(AdminService.class);

	@Autowired
	private IAdminDao adminDao;

	public Admin login(String name, String password) {
		if (!StringUtils.isEmpty(name) && !StringUtils.isEmpty(password)) {
			try {
				Admin admin = adminDao.getAdmin(name, password);
				return admin != null && admin.getId() > 0 ? admin : null;
			} catch (Exception e) {
				LOGGER.info("AdminService login(String,String)," + e.getMessage());
				e.printStackTrace();
			}
		}
		return null;
	}

	public boolean password(Integer id, String password) {
		if (id > 0 && !StringUtils.isEmpty(password)) {
			try {
				adminDao.updatePassword(id, password);
				return true;
			} catch (Exception e) {
				LOGGER.info("AdminService password(Integer,String)," + e.getMessage());
				e.printStackTrace();
			}
		}
		return false;
	}

}
