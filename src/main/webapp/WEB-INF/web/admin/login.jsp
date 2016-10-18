<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>E-Commerce Platform Admin</title>
<link rel="stylesheet" type="text/css" href="${ctx}/admin/css/style.css"
	tppabs="${ctx}/admin/css/style.css" />
<style>
body {
	height: 100%;
	background: #16a085;
	overflow: hidden;
}

canvas {
	z-index: -1;
	position: absolute;
}
</style>
<script src="${ctx}/admin/js/jquery.js"></script>
<script src="${ctx}/admin/js/verificationNumbers.js"
	tppabs="${ctx}/admin/js/verificationNumbers.js"></script>
<script src="${ctx}/admin/js/Particleground.js"
	tppabs="${ctx}/admin/js/Particleground.js"></script>
<script>
	$(document).ready(function() {
		//粒子背景特效
		$('body').particleground({
			dotColor : '#5cbdaa',
			lineColor : '#5cbdaa'
		});

		$(".submit_btn").click(function() {
			var name = $("#name").val();
			var password = $("#password").val();
			var url = "${ctx}/admin/login";
			var user={"name":name,"password":password};
			$.post(url, user, function(data) {
				var result= eval("("+data+")");
				if(result.success==true){
					window.location.href="${ctx}/admin/main";
				}else{
					alert(result.error);
				}
			});
		});
	});
</script>
</head>
<body>
	<dl class="admin_login">
		<dt>
			<strong>电子商务平台管理系统</strong> <em>E-Commerce Platform</em>
		</dt>
		<dd class="user_icon" style="margin-bottom: 20px">
			<input id="name" type="text" placeholder="账号" class="login_txtbx" />
		</dd>
		<dd class="pwd_icon" style="margin-bottom: 20px">
			<input id="password" type="password" placeholder="密码"
				class="login_txtbx" />
		</dd>
		<dd style="margin-bottom: 20px">
			<input type="button" value="立即登陆" class="submit_btn" />
		</dd>
		<dd>
			<p>© 2016 zhao 版权所有</p>
			<p>
				<a href="https://github.com/ZHAO807824/ECP" target="_blank">https://github.com/ZHAO807824/ECP</a>
			</p>
		</dd>
	</dl>
</body>