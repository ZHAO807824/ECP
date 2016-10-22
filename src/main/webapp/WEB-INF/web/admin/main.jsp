<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>E-Commerce Plaform</title>
<link href="${ctx}/admin/css/default.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css"
	href="${ctx}/admin/js/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/admin/js/themes/icon.css" />
<script type="text/javascript" src="${ctx}/admin/js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="${ctx}/admin/js/jQuery.easyui.js"></script>

<script type="text/javascript" src='${ctx}/admin/js/outlook2.js'>
</script>

<script type="text/javascript">
	var _menus = {
		"menus" : [ {
			"menuid" : "8",
			"icon" : "icon-sys",
			"menuname" : "用户管理",
			"menus" : [
				{
					"menuname" : "用户列表",
					"icon" : "icon-nav",
					"url" : "buyers"
				},
				{
					"menuname" : "商家列表",
					"icon" : "icon-nav",
					"url" : "sellers"
				}
			]
		}, {
			"menuid" : "56",
			"icon" : "icon-sys",
			"menuname" : "订单管理",
			"menus" : [
			 	{
					"menuname" : "订单列表",
					"icon" : "icon-nav",
					"url" : "orders"
				}
			]
		},  {
			"menuid" : "39",
			"icon" : "icon-sys",
			"menuname" : "商城管理",
			"menus" : [
			 	{
					"menuname" : "商品列表",
					"icon" : "icon-nav",
					"url" : "projects"
				}
			]
		} ]
	};
	//设置登录窗口
	function openPwd() {
		$('#w').window({
			title : '修改密码',
			width : 300,
			modal : true,
			shadow : true,
			closed : true,
			height : 160,
			resizable : false
		});
	}
	//关闭登录窗口
	function close() {
		$('#w').window('close');
	}

	//修改密码
	function serverLogin() {
		var $newpass = $('#txtNewPass');
		var $rePass = $('#txtRePass');

		if ($newpass.val() == '') {
			msgShow('系统提示', '请输入密码！', 'warning');
			return false;
		}
		if ($rePass.val() == '') {
			msgShow('系统提示', '请在一次输入密码！', 'warning');
			return false;
		}

		if ($newpass.val() != $rePass.val()) {
			msgShow('系统提示', '两次密码不一至！请重新输入', 'warning');
			return false;
		}

		var admin={"password":$newpass.val()};
		var url="${ctx}/admin/password";
		$.post(url,admin, function(data) {
			var result=eval("("+data+")");
			if(result.success==true){
				msgShow('系统提示', '恭喜，密码修改成功！', 'info');
			}else{
				msgShow('系统提示', result.error, 'info');
			}
			$newpass.val('');
			$rePass.val('');
			close();
		})

	}

	$(function() {

		openPwd();
		//
		$('#editpass').click(function() {
			$('#w').window('open');
		});

		$('#btnEp').click(function() {
			serverLogin();
		})
		
		$('#btnCl').click(function(){
			close();
		})

		$('#loginOut').click(function() {
			$.messager.confirm('系统提示', '您确定要退出本次登录吗?', function(r) {

				if (r) {
					location.href = '${ctx}/admin/logout';
				}
			});

		})

	});
</script>

</head>
<body class="easyui-layout" style="overflow-y: hidden" scroll="no">
	<noscript>
		<div
			style="position: absolute; z-index: 100000; height: 2046px; top: 0px; left: 0px; width: 100%; background: white; text-align: center;">
			<img src="images/noscript.gif" alt='抱歉，请开启脚本支持！' />
		</div>
	</noscript>
	<div region="north" split="true" border="false"
		style="overflow: hidden; height: 30px; background: url(images/layout-browser-hd-bg.gif) #7f99be repeat-x center 50%; line-height: 20px; color: #fff; font-family: Verdana, 微软雅黑, 黑体">
		<span style="float: right; padding-right: 20px;" class="head">欢迎
			E-Commerce Platform <a href="#" id="editpass">修改密码</a> <a href="#" id="loginOut">安全退出</a>
		</span> <span style="padding-left: 10px; font-size: 16px;"><img
			src="images/blocks.gif" width="20" height="20" align="absmiddle" />
			E-Commerce Platform</span>
	</div>
	<div region="south" split="true"
		style="height: 30px; background: #D2E0F2;">
		<div class="footer"><a h>https://github.com/ZHAO807824/ECP</a></div>
	</div>
	<div region="west" split="true" title="导航菜单" style="width: 180px;"
		id="west">
		<div class="easyui-accordion" fit="true" border="false">
			<!--  导航内容 -->

		</div>

	</div>
	<div id="mainPanle" region="center"
		style="background: #eee; overflow-y: hidden">
		<div id="tabs" class="easyui-tabs" fit="true" border="false">
			<div title="欢迎使用" style="padding: 20px; overflow: hidden;" id="home">

				<h1>Welcome to E-Commerce Platform!</h1>

			</div>
		</div>
	</div>


	<!--修改密码窗口-->
	<div id="w" class="easyui-window" title="修改密码" collapsible="false"
		minimizable="false" maximizable="false" icon="icon-save"
		style="width: 300px; height: 150px; padding: 5px; background: #fafafa;">
		<div class="easyui-layout" fit="true">
			<div region="center" border="false"
				style="padding: 10px; background: #fff; border: 1px solid #ccc;">
				<table cellpadding=3>
					<tr>
						<td>新密码：</td>
						<td><input id="txtNewPass" type="Password" class="txt01" /></td>
					</tr>
					<tr>
						<td>确认密码：</td>
						<td><input id="txtRePass" type="Password" class="txt01" /></td>
					</tr>
				</table>
			</div>
			<div region="south" border="false"
				style="text-align: right; height: 30px; line-height: 30px;">
				<a id="btnEp" class="easyui-linkbutton" icon="icon-ok"
					href="javascript:void(0)"> 确定</a> 
				<a id="btnCl" class="easyui-linkbutton"
					icon="icon-cancel" href="javascript:void(0)">取消</a>
			</div>
		</div>
	</div>

	<div id="mm" class="easyui-menu" style="width: 150px;">
		<div id="mm-tabclose">关闭</div>
		<div id="mm-tabcloseall">全部关闭</div>
		<div id="mm-tabcloseother">除此之外全部关闭</div>
		<div class="menu-sep"></div>
		<div id="mm-tabcloseright">当前页右侧全部关闭</div>
		<div id="mm-tabcloseleft">当前页左侧全部关闭</div>
		<div class="menu-sep"></div>
		<div id="mm-exit">退出</div>
	</div>


</body>
</html>