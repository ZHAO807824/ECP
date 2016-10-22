<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>E-Commerce Platform</title>
<link rel="stylesheet" type="text/css" href="${ctx}/home/css/style.css" />
<link rel="stylesheet" type="text/css"
	href="http://www.w3cschool.cc/try/jeasyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="http://www.w3cschool.cc/try/jeasyui/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="http://www.w3cschool.cc/try/jeasyui/demo/demo.css">

<script type="text/javascript" src="${ctx}/home/js/jquery.js"></script>
<script type="text/javascript"
	src="http://www.w3cschool.cc/try/jeasyui/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="http://www.w3cschool.cc/try/jeasyui/datagrid-detailview.js"></script>
<script type="text/javascript">
	//datagrid初始化 
	$('#list_data').datagrid({
		title : '应用系统列表',
		iconCls : 'icon-edit',//图标 
		width : 700,
		height : 'auto',
		nowrap : false,
		striped : true,
		border : true,
		collapsible : false,//是否可折叠的 
		fit : true,//自动大小 
		url : '${ctx}/admin/buyers/page',
		//sortName: 'code', 
		//sortOrder: 'desc', 
		remoteSort : false,
		idField : 'fldId',
		singleSelect : false,//是否单选 
		pagination : true,//分页控件 
		rownumbers : true,//行号 
		frozenColumns : [ [ {
			field : 'ck',
			checkbox : true
		} ] ],
		toolbar : [ {
			text : '添加',
			iconCls : 'icon-add',
			handler : function() {
				openDialog("add_dialog", "add");
			}
		}, '-', {
			text : '修改',
			iconCls : 'icon-edit',
			handler : function() {
				openDialog("add_dialog", "edit");
			}
		}, '-', {
			text : '删除',
			iconCls : 'icon-remove',
			handler : function() {
				delAppInfo();
			}
		} ],
	});
	//设置分页控件 
	var p = $('#list_data').datagrid('getPager');
	$(p).pagination({
		pageSize : 10,//每页显示的记录条数，默认为10 
		pageList : [ 5, 10, 15 ],//可以设置每页记录条数的列表 
		beforePageText : '第',//页数文本框前显示的汉字 
		afterPageText : '页    共 {pages} 页',
		displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录',
	/*onBeforeRefresh:function(){
	    $(this).pagination('loading');
	    alert('before refresh');
	    $(this).pagination('loaded');
	}*/
	});
</script>

</head>
<body>
	<table id="list_data" cellspacing="0" cellpadding="0">
		<thead>
			<tr>
				<th field="id" width="50">id</th>
				<th field="name" width="50">name</th>
				<th field="email" width="50">email</th>
				<th field="phone" width="50">phone</th>
			</tr>
		</thead>
	</table>

	<div id="toolbar">
		<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true"
			onclick="newUser()">New User</a> <a href="#"
			class="easyui-linkbutton" iconCls="icon-edit" plain="true"
			onclick="editUser()">Edit User</a> <a href="#"
			class="easyui-linkbutton" iconCls="icon-remove" plain="true"
			onclick="destroyUser()">Remove User</a>
	</div>
</body>
</html>