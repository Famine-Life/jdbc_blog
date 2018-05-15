<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ page import="dao.userDao" %>
<%@ page import="entity.User" %>
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
    <h1>修改数据</h1>
    <hr>
  
    <center>
     <% 
     		//从另一个页面获取要更新的id,执行list(String id)查询单个记录的值,并且返回一个对象
           	  String id = request.getParameter("id");
           	  userDao userDao=new userDao();
           	  User user=userDao.list(id);
      %>  
   <table width="750" height="60" cellpadding="0" cellspacing="0" border="1px solid">
          <tr>
          	<th>ID</th>
          	<th>用户名</th>
          	<th>密码</th>
          	<th>联系电话</th>
          	<th>联系邮箱</th>
          	<th>性别</th>
          </tr>
       	<tr>
            <td><%=user.getId() %></td> 
            <td><%=user.getUsername() %></td> 
            <td><%=user.getPassword() %></td>
            <td><%=user.getPhone() %></td> 
            <td><%=user.getEmail() %></td> 
            <td><%=user.getSex() %></td>
       	</tr>
    <form action="updata_servlet?id=<%=id %>" method="post">
	    <table width="auto" height="60" cellpadding="0" cellspacing="0" border="0">
           <tr><td><p style="text-align:left">修改<%=id %>的数据:</p></td></tr>
           <tr><td><p class="label">用户名:<input type="text" name="username" placeholder="<%=user.getUsername()%>" ></p></td></tr>
		   <tr><td><p class="label">密码:<input type="password" name="password" placeholder="<%=user.getPassword()%>"></p></td></tr>
           <tr><td><p class="label">联系电话:<input type="text" name="phone" placeholder="<%=user.getPhone()%>"></p></td></tr>
           <tr><td><p class="label">联系邮箱:<input type="text" name="email" placeholder="<%=user.getEmail()%>"></p></td></tr>
           <tr><td><p style="text-align:center">性别:<input type="radio" name="sex" value="男" checked="checked">男
		         <input type="radio" name="sex" value="女">女
		  </td></tr>
			<tr><td><input type="submit" value="更新"></td></tr>
	    </table>
    </form>
    </center>
  </body>
</html>
