<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<s:form action="bookAction" method="post">
		<s:textfield name="book.name" label="书名"></s:textfield>
		<s:textfield name="book.auther" label="作者"></s:textfield>
		<s:textfield name="book.price" label="价格"></s:textfield>
		<s:submit value="提交"></s:submit>
	</s:form>
</body>
</html>