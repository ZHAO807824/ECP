package com.ecp.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ecp.dto.Result;
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
	public Result<Object> login(@RequestParam("name") String name, @RequestParam("password") String password) {
		if (adminService.login(name, password)) {
			return new Result<Object>(true);
		}
		return new Result<Object>(false, "账号和密码不匹配,请重新输入");

	}

	/**
	 * 管理员主页页面
	 */
	@RequestMapping(value = "/admin/main", method = RequestMethod.GET)
	public String main() {
		return "admin/main";
	}
}
