package com.ecp.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.ecp.entity.admin.Admin;
import com.google.common.collect.Lists;

/**
 * 用户登录拦截器
 * 
 * @User zhao
 *
 */
public class AdminInterceptor implements HandlerInterceptor {

	// 默认拦截路径
	private List<String> urls = Lists.newArrayList();

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 处理不拦截的资源
		String uri = request.getRequestURI();
		if (uri.startsWith("/ECP/admin")) {
			for (String url : urls) {
				if (uri.equals(url)) {
					return true;
				}
			}
			HttpSession session = request.getSession();
			Admin admin = (Admin) session.getAttribute("admin");
			if (admin != null && admin.getId() > 0) {
				return true;
			}
			return false;
		} else {
			return true;
		}
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

	public void setUrls(List<String> urls) {
		this.urls = urls;
	}
}
