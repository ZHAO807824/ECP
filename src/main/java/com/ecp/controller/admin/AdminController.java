package com.ecp.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ecp.service.admin.IAdminService;

@Controller
public class AdminController {

	@Autowired
	private IAdminService adminService;

	/**
	 * 管理员登录页
	 */
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String index() {
		return "admin/login";
	}

	/**
	 * 异步提交登录表单
	 */
	@RequestMapping(value = "/admin/login", method = RequestMethod.POST)
	@ResponseBody
	public boolean login(@RequestParam("name") String name, @RequestParam("password") String password) {
		return adminService.login(name, password);
	}
	
	/**
	 * 管理员主页页面 
	 */
	@RequestMapping(value="/admin/main",method=RequestMethod.GET)
	public String main(){
		return "admin/main";
	}
}
