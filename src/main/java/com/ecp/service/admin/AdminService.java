package com.ecp.service.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.ecp.dao.admin.IAdminDao;

@Service
public class AdminService implements IAdminService {

	private Logger LOGGER = LoggerFactory.getLogger(AdminService.class);

	@Autowired
	private IAdminDao adminDao;

	public boolean login(String name, String password) {
		if (!StringUtils.isEmpty(name) && !StringUtils.isEmpty(password)) {
			try {
				Integer id = adminDao.getAdmin(name,password);
				return id != null && id > 0 ? true : false;
			} catch (Exception e) {
				LOGGER.info("AdminService," + e.getMessage());
				e.printStackTrace();
			}
		}
		return false;
	}

}
