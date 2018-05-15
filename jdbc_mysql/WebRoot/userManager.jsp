<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" %>
<%@ page import="entity.User" %>
<%@ page import="dao.userDao" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>mysql_jdbc</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  <style type="text/css">
  		body{
  		font-size:20px;
  		}
	   div{
	   }
	   td{
	      font-size:12pt;
	      color:blue;
	      text-align:center;
	   }
	   
	   .signin{
	   		position:fixed;
	   		top:40px;
	   		right:200px;
	   		
	   }
	   .signin a{
	   		color:blue;
	   		text-decoration:none;
	   }
	   .signin a:hover{
	   		text-decoration:underline;
	   }
	   
	   .footer{
	   position:fixed;
	   bottom:0px;
	   text-align:center;
	   width:100%;
	   }
	</style>
  </head>
  <body>
    <h1>用户展示</h1>
    <p class="signin"><a href="signin.jsp">注册</a></p>
    <hr>
  
    <center>
    <table width="750" height="60" cellpadding="0" cellspacing="0" border="1px solid">
          <tr>
          	<th>ID</th>
          	<th>用户名</th>
          	<th>密码</th>
          	<th>联系电话</th>
          	<th>联系邮箱</th>
          	<th>性别</th>
          	<th></th>
          	<th></th>
          </tr>
          <!-- 循环开始 -->
           <% 
           	   User user = new User();
               userDao userDao = new userDao(); 
               List<User> list = userDao.list();
               
               if(list!=null&&list.size()>0)
               {
	               for(int i=0;i<list.size();i++)
	               {
	                   user = list.get(i);
           %>   
           <tr>
               <td><%=user.getId() %></td> 
               <td><%=user.getUsername() %></td> 
               <td><%=user.getPassword() %></td>
               <td><%=user.getPhone() %></td> 
               <td><%=user.getEmail() %></td> 
               <td><%=user.getSex() %></td>
               <td><a href="delete_servlet?flag=delete&id=<%=user.getId() %>" onclick="confirm();">删除</a></td> 
               <td><a href="updata.jsp?id=<%=user.getId() %>">更新</a></td> 
          </tr>
          <!-- 循环结束 -->
        
          <%
                   }
              } 
          %>
    </table>
    </center>
    <div class="footer">
    	2018-5-20
    </div>
  </body>
</html>