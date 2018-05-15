<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>注册</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <style>
  	body{
  	}
  	form{
  		font-size:20px;
  		color:blue;
  	}
  	tr{
  		text-align:center;
  	}
  	.label{
  		width:100%;
  		text-align:right;
  	}
  	
  </style>
  <body>
    <h1>用户注册</h1>
    <hr>
  
    <center>
    <form action="signin_servlet" method="post">
	    <table width="auto" height="60" cellpadding="0" cellspacing="0" border="0">
           <% 
           	  
           %>  
           <tr><td><p class="label">用户名:<input type="text" name="username" ></p></td></tr>
		   <tr><td><p class="label">密码:<input type="password" name="password" ></p></td></tr>
           <tr><td><p class="label">联系电话:<input type="text" name="phone" ></p></td></tr>
           <tr><td><p class="label">联系邮箱:<input type="text" name="email" ></p></td></tr>
           <tr><td><p style="text-align:center">性别:<input type="radio" name="sex" value="男">男
		         <input type="radio" name="sex" value="女">女
		  </td></tr>
			<tr><td><input type="submit" value="注册"></td></tr>
	    </table>
    </form>
    </center>
  </body>
</html>
