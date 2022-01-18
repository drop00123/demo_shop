<%--
  Created by IntelliJ IDEA.
  User: Mike-Qian
  Date: 2021/4/28
  Time: 22:09
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<html>
<html>
<link href="css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery.min.js"></script>
<head>
    <title>留言板</title>
    <link rel="icon" type="image/x-icon" href="icon/shop.jpg" />
</head>
<style>
    #bbs{
        background-image: url("image/updateP.jpg");
        background-repeat: no-repeat;
    }
</style>
<body>
<%@ include file="header.jsp"%>
<div  class="container thumbnail" id="bbs" style="text-align: center">
    <div class="row">
        <h3><a href="user?method=show" style="text-decoration-line:none">历史评论</a></h3>
    </div>
    <div class="row">
        <form action="user?method=addBbs" method="post">
            <div style="margin-top: 40px;margin-bottom:10px" >
                <textarea placeholder="请提出您的宝贵意见,“便民”只做最懂你的平台" autofocus style="width: 455px;height: 400px; resize:none" name="bbs"></textarea><br>
            </div>
            <div class="row">
                <div class="col-sm-4  col-sm-offset-1">
                    <input class="btn btn-success text-center" style="width: 70px ;height: 40px" type="submit" value="提交">
                </div>
                <div class="col-sm-1  col-sm-offset-2">
                    <input class="btn btn-warning text-center"  style="width: 70px ;height: 40px"  type="reset" value="重置">
                </div>
            </div>
        </form>
    </div>

</div>
</body>
</html>
