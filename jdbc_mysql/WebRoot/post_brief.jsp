<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ page import="dao.postDao" %>
<%@ page import="entity.Post" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en" >
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>看着黎明丶庆幸</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <script src="js/jquery-3.3.1.js" ></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" ></script>

    <script src="js/post_brief.js"></script>
    <link rel="stylesheet" href="style/post_brief.css" class="style">
<style>
</style>
</head>
<body>
    <nav class="navbar fixed-top navbar-expand-lg navbar-light bg-light">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarText">
            <ul class="navbar-nav mr-auto">
                    <span class="navbar-text">
                            	好怕、终究要变成和他们一样
                    </span>
            </ul>
            <button type="button" class="btn btn-light" onclick="location.href='post_write.jsp'">写博客</button>
            <button type="button" class="btn btn-outline-secondary"  onclick="location.href='index.jsp'">Blog</button>
            <button type="button" class="btn btn-light"  onclick="location.href='https://github.com/Famine-Life'">GitHub</button>
        </div>
    </nav>
    <div class="container">
        <div id="list-group" class="list-group">
            <a class="list-group-item list-group-item-secondary" style="font-size:18pt;">
                	文章
            </a>
            <%
            	Post post = new Post();
            	List<Post> list = new ArrayList();
            	postDao pd = new postDao();
            	list = pd.list(); //调用查询方法
            	if(list!=null&&list.size()>0){
            		for(int i=0;i<list.size();i++){
            			post = list.get(i);
            	
             %>
            <a href="post_details.jsp?id=<%=post.getId() %>" class="list-group-item list-group-item-action"><%=post.getTitle()%></a>
            <%
            		}
            	}
             %>
        </div>
    </div>

</body>
</html>
