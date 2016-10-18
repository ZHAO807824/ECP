package com.ecp.controller.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ecp.dto.Result;
import com.ecp.service.home.IUserService;

@Controller
public class UserController {

	@Autowired
	private IUserService userService;

	/**
	 * 用户登录页
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "home/login";
	}

	/**
	 * 异步提交登录表单
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public Result<Object> login(@RequestParam("name") String name, @RequestParam("password") String password) {
		if (userService.login(name, password)) {
			return new Result<Object>(true);
		}
		return new Result<Object>(false, "账号和密码不匹配,请重新输入");

	}
}
