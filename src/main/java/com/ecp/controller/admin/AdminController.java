package com.ecp.controller.admin;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ecp.dto.Result;
import com.ecp.entity.admin.Admin;
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
	public Result<Object> login(@RequestParam("name") String name, @RequestParam("password") String password,
			HttpSession session) {
		Admin admin = adminService.login(name, password);
		if (admin != null) {
			session.setAttribute("admin", admin);
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

	/**
	 * 异步修改密码
	 */
	@RequestMapping(value = "/admin/password", method = RequestMethod.POST)
	@ResponseBody
	public Result<Object> password(@RequestParam("password") String password, HttpSession session) {
		Admin admin = (Admin) session.getAttribute("admin");
		if (admin != null && admin.getId() > 0) {
			if (adminService.password(admin.getId(), password)) {
				return new Result<Object>(true);
			}
		}
		return new Result<Object>(false, "输入有误,或者是用户已退出登录。请重试!");

	}

	/**
	 * 退出登录
	 */
	@RequestMapping(value = "/admin/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("admin");
		return "redirect:/admin";
	}

	/**
	 * 用户列表
	 */
	@RequestMapping(value = "/admin/users", method = RequestMethod.GET)
	public ModelAndView users() {
		return null;
	}

	/**
	 * 订单列表
	 */
	@RequestMapping(value = "/admin/orders", method = RequestMethod.GET)
	public ModelAndView orders() {
		return null;
	}

	/**
	 * 产品列表
	 */
	@RequestMapping(value = "/admin/projects", method = RequestMethod.GET)
	public ModelAndView projects() {
		return null;
	}
}
