<%--
  Created by IntelliJ IDEA.
  User: Mike-Qian
  Date: 2021/4/30
  Time: 17:21
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<html>
<head>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <title>Title</title>
    <link rel="icon" type="image/x-icon" href="icon/shop.jpg" />
</head>
<body>
<%@ include file="header.jsp"%>
  <div class="container thumbnail">
      <div class="row text-center" style="margin-bottom: 20px">
          <div class="col-sm-12">
              <h1 class="glyphicon glyphicon-list-alt">&nbsp;留言薄</h1>
          </div>
      </div>
      <div class="row">
          <div class="col-sm-12">
              <table class="table table-hover table-bordered table-striped">
                  <tr>
                      <th>时间</th>
                      <th>留言者姓名</th>
                      <th>内容</th>
                  </tr>
                  <c:forEach items="${pageBean.list}" var="g">
                      <tr>
                          <td>${g.mDate}</td>
                          <td>${g.username}</td>
                          <td>${g.mContent}</td>
                      </tr>
                  </c:forEach>
              </table>
          </div>
      </div>
      <div class="row text-center">
          <div class="col-sm-12">
              <nav aria-label="Page navigation">
                  <ul class="pagination">
                      <li class="${pageBean.currentPage==1?'disabled':''}">
                          <a  href="user?method=show&currentPage=${pageBean.currentPage-1}" aria-label="Previous">
                              <span aria-hidden="true">&laquo;</span>
                          </a>
                      </li>

                      <c:forEach begin="1" end="${pageBean.totalPage}" step="1" var="index">
                          <c:if test="${pageBean.currentPage==index}">
                              <li class="active"><a href="user?method=show&currentPage=${index}">${index}</a></li>
                          </c:if>

                          <c:if test="${pageBean.currentPage!=index}">
                              <li ><a href="user?method=show&currentPage=${index}">${index}</a></li>
                          </c:if>
                      </c:forEach>

                      <li class="${pageBean.currentPage==pageBean.totalPage?'disabled':''}">
                          <a href="user?method=show&currentPage=${pageBean.currentPage+1}" aria-label="Next">
                              <span aria-hidden="true">&raquo;</span>
                          </a>
                      </li>
                  </ul>
              </nav>
          </div>
      </div>
  </div>
</body>
</html>
