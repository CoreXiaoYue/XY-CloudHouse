<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>学生列表</title>
</head>
<body>
<s:debug></s:debug>
		<table width="60%" border="1" cellspacing="1"> 
			<tr bordercolor="#0000FF"> 
				<td>书名</td> 
				<td>作者</td> 
				<td>价格</td>
				<td>操作</td>
			</tr> 
			
		<s:iterator var="b" value="list">
			<tr > 
				<td>${b.name}</td> 
				<td>${b.auther}</td> 
				<td>${b.price}</td> 
				<td><a href="${pageContext.request.contextPath}/deleteAction?id=${b.bookId}">删除</a></td> 
			</tr> 
		</s:iterator>
		</table> 
	 	
</body>
</html>