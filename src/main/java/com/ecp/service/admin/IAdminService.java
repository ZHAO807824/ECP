package com.ecp.service.admin;

import com.ecp.entity.admin.Admin;

public interface IAdminService {

	public Admin login(String name,String password);
	
	public boolean password(Integer id,String password);
}
