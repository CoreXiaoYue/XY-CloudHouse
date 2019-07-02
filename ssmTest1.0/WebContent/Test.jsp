<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="bootstrap/js/json2.js"></script>
<script type="text/javascript" src="bootstrap/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="bootstrap/js/jquery.validate.min.js"></script>
<script type="text/javascript" src="bootstrap/js/messages.js"></script>
<script type="text/javascript" src="bootstrap/js/jquery-migrate-1.2.1.min.js"></script>
<link rel="stylesheet" type="text/css" href="bootstrap/js/common.css"></link>
</head>
<script type="text/javascript">
/* 	$.ajaxSetup({
		contentType : "application/json; charset=utf-8"
	});
	function send() {
		var url = "[[@{/save}]]";
		var data = {
			id : "3",
			name : "Thymeleaf实战",
			author : "杨恩雄"
		}; */
		/**
		$.ajax({
		    type: "POST",
		    dataType: "json",
		    contentType: "application/json; charset=utf-8",
		    url: url,
		    data: JSON.stringify(data),
		    success: function(data) {
		        alert(data.name);
		    }
		});
		 */
	/* 	$.post(url, JSON.stringify(data), function(data) {
			alert(data.name);
		});
	} */

/*----------------------------------------  */
 		$.ajaxSetup({
			contentType : "application/json; charset=utf-8"
		}); 
	
	function checknameTest() {
		
		var url = "checknameTest";
		var source = {
			id : "20",
			name : "阿发",
			password : "124512"
		};
		$.post(url, JSON.stringify(source),function(datas) {
			alert(datas.id+" "+datas.name+" "+datas.password);
		},"json");
	}
/* ---------------------------------------------------- */
	$(function() {
		$("#checkpost2").click(function() {
			alert("ok");
			$.post("checkpost2", {
				name : "小岳",
				id : "1"
			}, function(data) {
				alert(data);
			});
		});
	});
	/* ---------------------------------------------------- */
	$(function() {
		$("#checkpost3").click(function() {
			var list = new Array("大强", "珊珊");
			$.post("checkpost3", {
				name : "小岳"
			}, function(data) {
				alert(data);
			});
		});
	});
	/*--------------------------------  */

	$(function() {
		$("#checkpost4").click(function() {
			var username = $("#name").val();
			var list = new Array("大强", "珊珊");
			var map = {
				name : "小龙",
				password : "123456"
			};
			var strings = "变量";
			$.ajax("${pageContext.request.contextPath}/checkpost4", {
				type : "post",
				dataType : "json",
				contentType : "application/json",
				data : JSON.stringify({
					list : list,
					map : map,
					strings : strings,
					username : username
				}),
				success : function(data) {
					if (data == 1) {
						alert("可用")
					} else {
						alert("不可用");
					}
				},
				error : function() {
					alert("数据发送失败");
				}

			});
		});
	});

	/*--------------------------------  */
	/* 接受json数据 */
	$(function() {
		$("#ajaxResopnseTest1").click(function() {
			$.post("ajaxResopnseTest1", null, function(data) {
				$.each(data, function() {
					var tr = $("<tr align='center'/>");
					/* $("<td/>").html(this.name).appendTo(tr);
					$("<td/>").html(this.password).appendTo(tr);
					$("#tablejson").append(tr); */

					tr.append($("<td/>").html(this.name));
					tr.append($("<td/>").html(this.password));
					$("#tablejson").append(tr);
				})
			}, "json");
		});
	});

	/*--------------------------------  */
	$(function() {
		$("#checkpost1").click(function() {
			var name = $("#names").val();
			$.ajax("${pageContext.request.contextPath}/checkpost1",// 发送请求的URL字符串。
			{
				dataType : "json", // 预期服务器返回的数据类型。
				type : "post", //  请求方式 POST或GET
				contentType : "application/json", //  发送信息至服务器时的内容编码类型
				// 发送到服务器的数据。
				data : JSON.stringify({
					name : name,
					password : "12544"
				}),
				async : true, // 默认设置下，所有请求均为异步请求。如果设置为false，则发送同步请求
				// 请求成功后的回调函数。
				success : function(data) {
					$("#id").html(data.id);
					$("#name").html(data.name);
					$("#author").html(data.password);
				},
				// 请求出错时调用的函数
				error : function() {
					alert("数据发送失败");
				}
			}, "json");
		});
	});
	/* 
		$("#formsxx").validata({
			rules: {
				name: {
					required: true
				},
				password: {
					minlength: 6
				},
				email: {
					email: true
				},
			},
			message:{
				name: {
					required: "要写名字"
				}
			}
		}); */
		
		 $("#formsxx").validate({
             rules: {
                 name: {
                     required: true
                 },
                 passwd: {
                     minlength: 6
                 },
                 email: {
                     email: true
                 }
             },
             messages: {
                 name: {
                     required: "要写名字"
                 }
             }
         });

</script>
<body>
	<input type="button" value="Send Post" onClick="send()" />
	<input type="button" value="Send Post2" onClick="checknameTest()" />
	<a href="listStudent">学生列表</a>
	<br>
	<br>
	<a href="loginPage">loginPage登陆页面</a>
	<br>
	<br>
	<a href="login">login登陆</a>
	<br>
	<br>
	<a href="#" id="checkanmeTest">checkanmeTest登陆页面</a>
	<br>
	<br>
	<a href="#" id="checkpost1">testPost测试1</a>
	<br>
	<br>
	<a href="#" id="checkpost2">testPost测试2</a>
	<br>
	<br>
	<a href="#" id="checkpost3">testPost测试3</a>
	<br>
	<br>
	<a href="#" id="checkpost4">testPost测试4</a>
	<br>
	<br>
	<a href="#" id="ajaxResopnseTest1">ajaxResopnseTest1测试5</a>
	<br>
	<br>

	<input name="name" id="names"></input>
	<br> 编号：
	<span id="id"></span>
	<br> 书名：
	<span id="name"></span>
	<br>密码：
	<span id="password"></span>
	<br>
	<div id="divtable" style="weith: 100px">
		<table id="tablejson" border="1" style="border-collapse: collapse;">
			<tr>
				<td>姓名</td>
				<td>密码</td>
			</tr>
		</table>
	</div>
	<div>
		<form id="formsxx" >
			姓名：<input type="text" name="name"/><br>
			密码 ：<input type="text" name="password"></input><br>
			邮箱：<input type="text" name="email"></input><br>
				<input type="submit" value="提交"></input>
		</form>
	</div>
</body>
</html>