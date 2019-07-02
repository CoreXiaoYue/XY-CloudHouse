
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<meta charset="utf-8" />
    <title>登陆</title>
  </head>
   	<style>
   		body{
   			margin: 0;
   			padding: 0;
   			background-color: #7DCFEF;
   		}
   		footer{
   			width: 100%;
   			height: 150px;
   			background-color: #BBF4EE;
   			line-height: 150px;
   		}
   		h1{
   			color: #FCFFF8;
   			margin-left: 50px;
   			text-shadow:1px 1px 1px rgba(0,0,0,.3);
   		}
		.top{
			background-color:#F5FCFC;
			position: relative;
			left: 700px;
			width: 480px;
			height: 300px;
			top: 20px;
			border-radius: 3px;
			text-align: center;
			
		}
		.form1{
			text-align: center;
			padding-top: 50px;
		}
		
		#tableForm{
			padding:30px;
			margin: 0 auto;
			border-spacing: 40px 10px;
			text-align: center;
		}
		
		#tableForm tr{
			
		}
			.name{
				margin: 10px;
				padding: 2px;
				border-radius: 3px;
				background-color: #F1F6FC;
			}
			label{
				color: #000;
			
			}
			.sub{
				background-color: #8FC3F8;
				letter-spacing: 2px;
				width: 60px;
				height: 30px;
				margin: 10px;
				color: #fff;
				border-radius: 5px;
				line-height: 30px;
			}
			.sub:hover{
				background-color:#fff;
				color:#398DE0;
			}
			.name:hover{
				background-color: #fff;
			}
			h2{
				position: relative;
				top: 30px;
				color: #666868;
				font-size: 30px;
				text-shadow:1px 1px 1px rgba(0,0,0,.3);
			}
	</style>
	<body>
	<% %>
			<footer>
				<h1>学生管理系统登陆</h1>
			</footer>
		<div class="top" >
				<h2>账号登陆</h2>
			<form:form modelAttribute="user" action="login" method="post">
				<table id="tableForm">
					<tr>
						<td>账号：</td>
						<td><form:input path="name"/></td>
						<td><form:errors path="name" cssStyle="color:red"></form:errors></td>
					</tr>
					<tr>
						<td>密码：</td>
						<td><form:input path="password"/></td>
						<td><form:errors path="password" cssStyle="color:red"></form:errors></td>
					</tr>
					<tr><td><input type="submit" value="登陆"/></td></tr>
				</table>
			</form:form>
		</div>
  </body>
</html>
