<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
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
    <title>创作中心</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <script src="js/jquery-3.3.1.js" ></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" ></script>

    <script src="js/post_write.js"></script>
    <script src="js/markdown.js"></script>
    <link rel="stylesheet" href="style/post_write.css" class="style">
<style>
</style>
</head>
<body>
     <nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarText">
            <ul class="navbar-nav mr-auto">
                    <span class="navbar-text">
                                                      好害怕、终究要变成和他们一样
                    </span>
            </ul>
            <button type="button" class="btn btn-dark onclick="location.href='index.jsp'">Blog</button>
            <button type="button" class="btn btn-dark onclick="location.href='https://github.com/Famine-Life'">GitHub</button>
        </div>
    </nav>
    <div class="container">
            <div class="top">
                <div class="txttitle">
                    <input class="title-input" id="title-input"  name="title" type="text" placeholder="输入文章标题">
                    <button type="button" id="submit-btn" class="btn btn-danger">发布博客</button>
                </div>
                <div class="txtselect">
                        <span class="select-items">
                            文章类型：<select name="article_type" id="article_type">
                                <option value="0">请选择</option>
                                <option value="1">原创</option>
                                <option value="2">转载</option>
                                <option value="3">翻译</option>
                            </select>
                        </span>
                        <span class="select-items">
                            个人分类：<select name="person_class" id="person_class">
                                <option value="0">请选择</option>
                                <option value="1">java</option>
                                <option value="2">js</option>
                                <option value="3">sql</option>
                                </select>
                        </span>
                        <span class="select-items">
                            博客分类：<select name="blog_class" id="blog_class">
                                <option value="0">请选择</option>
                                <option value="1">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                </select>
                        </span>
                </div>
            </div>
        <div class="main">
            <div class="main-left">
                    <textarea style="resize:none;" id="text-input" name="text-input" oninput="this.editor.update()"rows="6" cols="60">Use **MarkDown** syntax here to write.</textarea>
            </div>
            <div class="main-right">
            	<form id="myForm" class="content-form" name="content-form" action="insertPost_servlet" method="POST">
                	<input type="hidden" name="content" id="content"/>
                	<div id="preview"> </div>
                 </form>
            </div>
        </div>
    </div>
    
</body>
</html>
