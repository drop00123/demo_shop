<%--
  Created by IntelliJ IDEA.
  User: Mike-Qian
  Date: 2021/5/24
  Time: 8:56
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>后台首页</title>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="../css/bootstrap.min.css" rel="stylesheet">
        <script src="../js/jquery.min.js"></script>
        <script src="../js/bootstrap.min.js"></script>
        <title>后台主页面</title>
        <style>
            @media ( min-width :768px ) {
                #left_tab {
                    width: 250px;
                    position: absolute;
                    z-index: 1;
                    height: 640px;
                }
                .mysearch {
                    margin: 10px;
                }
                .page_main {
                    margin-left: 255px;
                }
                .dv_content{
                    width: 100%;
                    height: 500px;
                }
                body{
                    background-image: url("../image/updateP.jpg");
                    background-repeat: no-repeat;
                    background-size: cover;
                }
                #typeShow{
                    padding-left: 250px;

                }
            }
        </style>
        <script>
            function deleteType(tid) {
                if(confirm("是否要删除"))
                {
                    location.href="admin?method=deleteType&tid="+tid;
                }
            }
        </script>
    </head>
<body>
<%--<c:if test="${admin==null }">
    <c:redirect url="login.jsp"></c:redirect>
</c:if>--%>
<!--导航 -->
<div style="width: 80%;margin-left: 10%;">
    <nav class="navbar navbar-default navbar-static-top">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#left_tab,#top_right">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a href="#" class="navbar-brand">网站后台管理</a>
        </div>
        <ul id="top_right" class="collapse navbar-collapse nav navbar-nav navbar-right"	style="margin-right: 20px;">
            <li>
                <a href="#">
                    <span class="badge"	style="background-color: red;">23</span>
                </a>
            </li>
            <li>
                <a href="#">
                    <span class="glyphicon glyphicon-off"></span>注销
                </a>
            </li>
        </ul>
        <!--左侧边栏 -->
        <div id="left_tab" style="margin-top: 70px;" class="collapse navbar-default navbar-collapse">
            <ul class="nav panel-group" id="myPanel">
                <!--栏目-->
                <li class="panel">
                    <a href="#sub1" data-toggle="collapse" data-parent="#myPanel">  个人信息
                        <span class="glyphicon glyphicon-triangle-bottom pull-right"></span>
                    </a>
                </li>

                <li class="panel">
                    <a href="#sub2" data-toggle="collapse" data-parent="#myPanel">  用户管理
                        <span class="glyphicon glyphicon-triangle-bottom pull-right"></span>
                    </a>
                    <ul id="sub2" class="nav panel-collapse collapse">
                        <li>
                            <a href="#" id="showUser">
                                <span class="glyphicon glyphicon-record"></span>&nbsp;&nbsp;用户管理
                            </a>
                        </li>
                        <li>
                            <a href="#" id="magic">
                                <span class="glyphicon glyphicon-plus"></span>&nbsp;&nbsp;待定
                            </a>
                        </li>
                    </ul>
                </li>

                <li class="panel">
                    <a href="#sub3" data-toggle="collapse" data-parent="#myPanel"> 商品管理
                        <span class="glyphicon glyphicon-triangle-bottom pull-right"></span>
                    </a>
                    <ul id="sub3" class="nav panel-collapse collapse">
                        <li>
                            <a href="#" id="showGoodsType">
                                <span class="glyphicon glyphicon-record"></span>&nbsp;&nbsp;查看商品分类
                            </a>
                        </li>
                        <li>
                            <a href="#" id="addGoodsType">
                                <span class="glyphicon glyphicon-plus"></span>&nbsp;&nbsp;添加商品分类
                            </a>
                        </li>
                        <li>
                            <a href="#" id="showGoods" >
                                <span class="glyphicon glyphicon-record"></span>&nbsp;&nbsp;查看商品
                            </a>
                        </li>
                        <li>
                            <a href="#" id="addGoods">
                                <span class="glyphicon glyphicon-plus"></span>&nbsp;&nbsp;添加商品
                            </a>
                        </li>
                    </ul>
                </li>
                <li class="panel">
                    <a href="#sub4" data-toggle="collapse" data-parent="#myPanel"> 订单管理
                        <span class="glyphicon glyphicon-triangle-bottom pull-right"></span>
                    </a>
                    <ul id="sub4" class="nav panel-collapse collapse">
                        <li>
                            <a href="#" id="showOrder">
                                <span class="glyphicon glyphicon-record"></span>&nbsp;&nbsp;查看订单
                            </a>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </nav>
    <script type="text/javascript">
        $("#showUser").click(function(){
            $("#showUser").attr("href","${pageContext.request.contextPath}/admin?method=getUserList");
        })
        $("#showGoodsType").click(function(){
            $("#showGoodsType").attr("href","${pageContext.request.contextPath}/admin?method=typeShow");
        })
        $("#addGoodsType").click(function(){
            $("#addGoodsType").attr("href","${pageContext.request.contextPath}/admin/addGoodsType.jsp");
        })
        $("#showGoods").click(function(){
            $("#showGoods").attr("href","${pageContext.request.contextPath}/admin?method=goodsShow");
        })
        $("#addGoods").click(function(){
            $("#addGoods").attr("href","${pageContext.request.contextPath}/admin/addGoods.jsp");
        })
        $("#showOrder").click(function(){
            $("#showOrder").attr("href","${pageContext.request.contextPath}/admin?method=getAllOrder");
        })
    </script>