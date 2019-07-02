<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
     <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<html>
  <head>
    
    
    <title>学生信息表</title>
    <meta charset="utf-8" />
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
		<script type="text/javascript" src="bootstrap/js/jquery.min.js" ></script>
		<link rel="stylesheet" href="bootstrap/css/bootstrap.css" />
		<!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
		<link rel="stylesheet" href="bootstrap/css/bootstrap-theme.css" />
		<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
		<script type="text/javascript" src="bootstrap/js/bootstrap.js"></script>
  </head>
 
  <body>
 		<div class="container">
			<!--导航栏部分-->
			<div class="row bg-danger" style="height: 80px;"> 
				<div class="col-md-6 col-xs-12">
					<h1>学生管理系统</h1>
				</div>
				<div class="col-md-6 col-xs-12" style="line-height: 80px;">
					<ul class="list-inline pull-right">
					   <li><h4>${student.name}</h4></li>
					    <li><a href="${pageContent.request.ContentPath}/outLogin">退出登陆</a></li>
					</ul>
				</div>
			</div>
			<!--二、左边导航栏和主界面区-->
			<div class="row">
				<div class="col-md-1 col-xs-12 bg-success" >
					
					<ul class="list-inline">
						<br />
					  <li><a class="btn btn-info btn-sm" href="listStudent">全部学生</a></li>
					   <li><a class="btn btn-info btn-sm" href="addpage">添加学生 </a></li>
					    <li><a class="btn btn-info btn-sm" href="#">其他信息</a></li>
					</ul>
				</div>
				
				<div class="col-md-11 col-xs-12">
					 <c:if test="${empty requestScope.list}">
				   		没有数据。
				   </c:if>
				  <c:if test="${!empty requestScope.list }">
				   	<table class="table table-bordered" style="width: 100%;">
				    	<tr  class="success">
				    		<th>姓名</th>
				    		<th>入学时间</th>
				    		<th>院系</th>
				    		<th>性别</th>
				    		<th>专业</th>
				    		<th class="warning">操作</th>
				    	</tr>
				   
				    <c:forEach items="${requestScope.list}" var="student">
				    	<tr >
				    		<td>${student.name}</td>
				    		<td><fmt:formatDate value="${student.admission}" type="date"/></td>
				    		<td>${student.gender}</td>
				    		<td>${student.department}</td>
				    		<td>${student.professional}</td>
				    		<td class="warning">
				    			<a href="deleteStudentById?id=${student.id}">删除</a>
				    			<a href="updatePage?id=${student.id}">修改</a>
				    		</td>
				    	</tr>
				    </c:forEach>
				   		<tr>
				   			<td colspan="6">页数</td>
				   		</tr>
				   
				   </table>
				   	</c:if>
					
				</div>
			</div>
			<!---->
			<div class="row"></div>
			<!---->
			<div class="row"></div>
			<!---->
			<div class="row"></div>
			<!---->
			<div class="row"></div>
		</div>
  </body>
</html>
