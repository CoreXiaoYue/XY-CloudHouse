<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="utf-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
  <head>
    <meta charset="utf-8" />
    <title>添加学生</title>
    
	<style type="text/css">
	    	body{
   			margin: 0;
   			padding: 0;
   			background-color: #F4F3FB;
   		}
   		header{
   			width: 100%;
   			height: 100px;
   			background-color:#9190CD;
   			line-height: 100px;
   		}
   		aside{
   			width: 15%;
   			height: 500px;
   			background-color: #C8C7E7;
   			float: left; 
   			text-align: center;
   		}
   		section{
   			width: 85%;
   			height: 600px;
   			background-color: #ECF9FA;
   			float: left;
   			text-align: center;
   		}
   		footer{
   			background-color: #BBF5AA;
   			width: 100%;
   			height: 50px;
   			clear: both;
   		}
   	
   		h1{
   			color: #FFFFFF;
   			margin-left: 100px;
   			text-shadow:1px 1px 1px rgba(0,0,0,.3);
   			font-size: 40px;
   		}
   		#asideList  a{
   			display: block;
   			background-color: #9DA4F3;
   			margin-top: 20px;
   		}
   		a{
   			text-decoration: none;
 			
   		}
   		#asideList {
   			text-align: center;
   			width: 60%;
   			height: 400px;
   			margin: 0 auto;
   			margin-top: 60px;
   			
   		}
   		#asideList a:hover{
   			background-color: #EDEDF2;
   			color: #2A2354;
   		}
   		
   		
   		form{
   			
   			border: 2px solid #DFE5DE;
   			width: 300px;
   			padding: 10px;
   			margin: 0 auto;
   		}
	    </style>
  </head>

  <body>
 		<header>
				<h1>学生管理系统</h1>
			</header>
			<aside>
					<div id="asideList">
						<a href="listStudent">查看全部</a>
						<a href="">修改学生</a>
					<a href="addpage">添加学生</a>
					</div>
			</aside>
			<section>
				<h4 id="titleh4">新增学生</h4>
				   <form action="insertStudent" method="POST" >
				   	<table>
				   		<tr>
					   		<td>姓名：</td>
					   		<td><input type="text" name="name"/></td>
				   		</tr>
				   		<tr>
					   		<td>性别：</td>
					   		<td><input type="text" name="gender"/></td>
				   		</tr>
				   		<tr>
					   		<td>院系：</td>
					   		<td><input type="text" name="department"/></td>
				   		</tr>
				   		<tr>
					   		<td>专业：</td>
					   		<td><input type="text" name="professional"/></td>
				   		</tr>
				   		<tr>
					   		<td>入学时间：</td>
					   		<td><input type="text" name="admission"/></td>
				   		</tr>
				   		<tr>
				   			<td><input type="submit" value="添加"/></td>
				   		</tr>
				   	</table>
				 </form>
 	
   			 </section>
    <footer>
    	
    	
    </footer>
  </body>
</html>
