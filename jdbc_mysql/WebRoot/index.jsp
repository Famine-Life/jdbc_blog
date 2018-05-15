<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" %>
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
    <title>练涛</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <script src="js/jquery-3.3.1.js" ></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" ></script>

    <script src="js/index.js"></script>
    <link rel="stylesheet" href="style/index.css" class="style">
<style>
</style>
<script type="text/javascript">
</script>
</head>
<body> 
    <div class="container">
            <div class="card text-center">
                <div class="card-header">
                    看着黎明丶庆幸
                </div>
                <span class="border border-light"></span>
                <div class="card-body">
                    <div id="show-page" class="show-page">
                        <p><a href="post_brief.jsp" >>>我的文章</a></p>
                        <p><a href="#" onclick="tip()">>>不断进步的我</a></p>
                        <p><a href="#" onclick="tip()">>>联系我</a></p>
                    </div>
                    <h5 class="card-title">以下是我的微博、GitHub、csdn、知乎</h5>
                    <div class="ul-position">
                        <ul class="logo-link">
                            <li id="li1"></li>
                            <a href="https://github.com/Famine-Life" target="_blank"><li id="li2"></li></a>
                            <a href="https://blog.csdn.net/qq_32953185" target="_blank"><li id="li3"></li></a>
                            <li id="li4"></li>
                        </ul>
                    </div>    
                </div>
                <span class="border border-light"></span>
                <div class="card-footer text-muted">2018-4-23</div>
            </div>
    </div>
</body>
</html>