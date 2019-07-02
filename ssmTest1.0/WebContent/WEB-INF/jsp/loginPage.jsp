
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="utf-8" />
<title>登陆</title>
	<script type="text/javascript" src="bootstrap/js/jquery.min.js"></script>
	<link rel="stylesheet" href="bootstrap/css/ssmlogin.css" />
<!--  	<link rel="stylesheet" href="bootstrap/css/bootstrap.css" />
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" href="bootstrap/css/bootstrap-theme.css" />  -->
<script type="text/javascript">
	function checkName() {
		var name = $("#name").val();
		if (name == "") {
			$("#hint").html("账号不能为空");
			return;
		}
		/* $.post("checkName/"+name,null,function(data){
			if(data==1){
				$("#hint").html("账号可用");
			}else{
				$("#hint").html("账号不存在");
			}
		});
		return; */
		$.ajax("${pageContext.request.contextPath}/checkName",// 发送请求的URL字符串。
		{
			dataType : "json", // 预期服务器返回的数据类型。
			type : "post", //  请求方式 POST或GET
			contentType : "application/json", //  发送信息至服务器时的内容编码类型
			// 发送到服务器的数据。
			data : JSON.stringify({
				name : name
			}),
			async : true, // 默认设置下，所有请求均为异步请求。如果设置为false，则发送同步请求
			// 请求成功后的回调函数。
			success : function(data) {
				if (data == 1) {
					$("#hint").html("账号可用");
					return;
				} else {
					$("#hint").html("账号不存在");
					return;
				}
			},
			// 请求出错时调用的函数
			error : function() {
				alert("数据发送失败");
			}
		});

	}
</script>
</head>


<body>
	<footer>
	<h1>学生管理系统登陆</h1>
	</footer>
	<div class="top">
		<h2>账号登陆</h2>
		<form:form action="login" method="post" modelAttribute="user">
			<table id="tableForm">
				<tr>
					<td>登录名:</td>
					<td><form:input path="name" /></td>
				</tr>

				<tr>
					<td></td>
					<td><form:errors path="name" cssStyle="color:red" /></td>
				</tr>
				<tr>
					<td>密码:</td>
					<td><form:input path="password" /></td>
				</tr>

				<tr>
					<td></td>
					<td><form:errors path="password"  cssStyle="color:red" /></td>
				</tr>
				<tr>
					<td></td>
					<td><span id="hint">${requestScope.msg}</span></td>
				</tr>

				<tr>
					<td><input type="submit" value="登陆" /></td>
				</tr>
			</table>
		</form:form>


	</div>
</body>
</html>
