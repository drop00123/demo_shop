<%--
  Created by IntelliJ IDEA.
  User: Mike-Qian
  Date: 2021/5/7
  Time: 21:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/login2.css">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <title>Title</title>
</head>
<body>
<script>
    function nameSub(username) {
        location.href="${pageContext.request.contextPath}/admin?method=updateName&username="+username;
    }
    function goMessage() {
        location.href="${pageContext.request.contextPath}/bbs.jsp";
    }
</script>
  <%@include file="header.jsp"%>
<div id="dingdanxiangqing_body">
    <div id="dingdanxiangqing_body_big">
        <div id="big_left">
            <p style="font-size:18px;margin-top: 15px">订单中心</p>
            <a id="big_left_a" href="order?method=myShow">我的订单</a><br/>
            <p style="font-size:18px">个人中心</p>
            <a id="big_left_a" href="user?method=myself">我的个人中心</a><br/>
            <a id="big_left_a" href="updatePwd.jsp" >修改密码</a><br/>
            <a id="big_left_a" href="address?method=show">收货地址</a><br/>
        </div>
        <div id="big_right" style="height: 500px;overflow: scroll;background-color:#f3f6fa">
              <div class="col-sm-12">
                             <span style="text-align: center;color:chartreuse">
                                 <c:if test="${u.ustatus eq 0}">
                                     <h1>${u.username},可通过激活邮箱成为会员哦</h1>
                                 </c:if>
                                 <c:if test="${u.ustatus eq 1}">
                                     <h1>尊敬的${u.username},恭喜您成为平台会员</h1>
                                 </c:if>
                             </span>
              </div>
                 <div style="margin-top: 100px;  font-size:20px;"  class="center-block">
                    <div class="row">
                        <div  class="col-sm-6 col-sm-push-1">
                            <span>用户编号&nbsp;:&nbsp;<span style="font-weight:800">${u.code}</span></span>
                        </div>
                        <div class="col-sm-6" style="padding-left: 50px">
                            <span>邮箱&nbsp;:<span  style="font-weight: 800">${u.email}</span></span>
                            <i class="glyphicon glyphicon-edit"></i>
                        </div>
                    </div>
                </div>
              <div class="row" style="margin-top: 100px;  font-size:20px;">
                  <div class="col-sm-6 col-sm-offset-1">
                      <span>用户名&nbsp;:  <span style="font-weight: 800">${u.username}</span> </span>
                      <i data-toggle="modal" data-target="#myModel"><span class="glyphicon glyphicon-edit"></span></i>
                      <div class="modal fade" id="myModel">
                          <div class="modal-dialog">
                              <div class="modal-content">
                                  <div class="modal-header">
                                      <button class="close" data-dismiss="modal" aria-hidden="true">×</button>
                                      用户名
                                  </div>
                                  <div class="modal-body"><input type="text" value="${u.username}" class="form-control"></div>
                                  <div class="modal-footer"><button class="btn btn-info" data-dismiss="modal" onclick="nameSub(${u.username})">确认</button></div>
                              </div>
                          </div>
                      </div>
                  </div>
                  <div class="col-sm-5">
                      <div class="dropdown">
                          <span style="font-size:20px">性别&nbsp;:</span>
                          <button class="btn btn-success dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true" style="font-weight: 800">
                              男
                              <span class="caret"></span>
                          </button>
                          <ul class="dropdown-menu " aria-labelledby="dropdownMenu1" style="font-width: 800;">
                              <li><a href="#">男</a></li>
                              <li role="separator" class="divider"></li>
                              <li><a href="#">女</a></li>
                          </ul>
                      </div>
                  </div>
              </div>
              <div class="row" style="margin-top:100px;text-align: center">
                  <div class="col-sm-12">
                      <span style="font-size:20px;color:mediumpurple" onclick="goMessage()">留个言</span>
                  </div>
              </div>
              </div>
        </div>
    </div>
</div>
</body>
</html>
