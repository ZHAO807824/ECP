package com.ecp.controller.home;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ecp.dto.Result;
import com.ecp.entity.home.Buyer;
import com.ecp.entity.home.Seller;
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
	public Result<Object> login(@RequestParam("name") String name, @RequestParam("password") String password,
			@RequestParam("role") String role, HttpSession session) {
		// 普通用户
		if ("0".equals(role.trim())) {
			Buyer buyer = userService.login(name, password, role);
			if (buyer != null) {
				session.setAttribute("buyer", buyer);
				return new Result<Object>(true);
			}
		}
		// 商家
		else if ("1".equals(role.trim())) {
			Seller seller = userService.login(name, password, role);
			if (seller != null) {
				session.setAttribute("seller", seller);
				return new Result<Object>(true);
			}
		}
		return new Result<Object>(false, "账号和密码不匹配,请重新输入");

	}

	/**
	 * 退出登录
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("buyer");
		session.removeAttribute("seller");
		return "redirect:/";
	}

	/**
	 * 注册页
	 */
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register() {
		return "/home/register";
	}

	/**
	 * 注册
	 */
	@ResponseBody
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public Result<Object> register(@RequestParam("name") String name, @RequestParam("password") String password,
			@RequestParam("email") String email, @RequestParam("phone") String phone,
			@RequestParam("company") String company, @RequestParam("address") String address,
			@RequestParam("role") String role, HttpSession session) {
		// 普通用户
		if ("0".equals(role.trim())) {
			Buyer buyer = new Buyer(name, password, email, phone, company, address);
			if (userService.register(buyer, role)) {
				return new Result<Object>(true);
			}
		}
		// 商家
		else if ("1".equals(role.trim())) {
			Seller seller = new Seller(name, password, email, phone, company, address);
			if (userService.register(seller, role)) {
				return new Result<Object>(true);
			}
		}
		return new Result<Object>(false, "注册失败,请稍后重试。");
	}
}
