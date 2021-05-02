<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="css/login2.css">
<link href="css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery.min.js"></script>
<title>头部</title>
    <script type="text/javascript">
        $(document).ready(function(){
            $.ajax({
                url:"${pageContext.request.contextPath}/type?method=findAll",
                type:"GET",
                dataType:"json",
                success:function(data){
                    for(var i in data){
                        var a = $("<a href='${pageContext.request.contextPath}/product?method=show&tid="+data[i].tid+"'>"+data[i].tname+"</a>");
                        $("#goodsType").append(a);
                    }
                },
                error:function(){
                    alert("失败");
                }
            })
        })
    </script>
</head>
<body>
				
 <div id="top">
    	<div id="topdiv">
            <span>
                <a href="index.jsp" id="a_top" target="_blank">便民购物</a>
                <li>|</li>
                <a href="bbs.jsp" id="a_top">留言框</a>
            </span>

            <span style="float:right">
           		<c:if test="${empty loginUser}">
                    <a href="login.jsp" id="a_top">登录</a>
                    <li>|</li>
                    <a href="register.jsp" id="a_top">注册</a>
                </c:if>
       			<c:if test="${not empty loginUser}">
                    <a href="address?method=show" id="a_top" style="color: pink;font-size: 20px;line-height: 40px;" class="glyphicon-user">${loginUser.username}</a>
                    <li>|</li>
                    <a href="user?method=logOut" id="a_top">注销</a>
                    <li>|</li>
                    <a href="order?method=show" id="a_top">我的订单</a>
                    <li>|</li>
                    <a href="address?method=show" id="a_top">地址管理</a>
                </c:if>
                <a href="${pageContext.request.contextPath}/cart?method=show&uid=${loginUser.uid}" id="shorpcar">购物车</a>
            </span>
        </div>
 </div>
<div id="second">
	    <a href="index.jsp" id="seimg" style=" margin-top:23px;"><img id="logo" src="image/logo_top.png"  /></a>
        <p id="goodsType">

        </p>
       <form action="product?method=findNeed" method="post" class="form-inline pull-right" style="margin-top: 40px;margin-right: 10px;">
		
		  <div class="form-group">
		    <input type="text" class="form-control" name="needs" style="width: 400px"  placeholder="搜索一下好东西...">
		  </div>
           <button type="submit" class="btn btn-warning"><span class="glyphicon glyphicon-search"></span>&nbsp;&nbsp;搜索</button>
	  </form>
</div>
</body>
</html>