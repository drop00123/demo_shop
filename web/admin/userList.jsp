<%--
  Created by IntelliJ IDEA.
  User: Mike-Qian
  Date: 2021/5/25
  Time: 20:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <script src="../js/jquery.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
    <title>用户管理</title>
</head>
<body>
<%@include file="frame.jsp"%>
    <div class="row" style="margin-left: 300px">
        <h1 class="glyphicon glyphicon-list-alt">&nbsp;用户管理</h1>
        <div class="col-sm-12">
            <table class="table table-hover table-bordered table-striped">
                <tr>
                    <th>编号</th><th>邮箱</th><th>姓名</th><th>性别</th><th>类别</th><th>操作</th>
                    <c:forEach  items="${pageBean.list}" var="u" varStatus="i">
                <tr>
                    <td>${i.count}</td>
                    <td>${u.email}</td>
                    <td>${u.username}</td>
                    <td>${u.usex}</td>
                <c:if test="${u.urole eq 1}">
                    <td>会员</td>
                </c:if>
                <c:if test="${u.urole eq 0}">
                    <td>普通用户</td>
                    <td>
                        <button class="btn btn-info form-control">设为会员</button>
                    </td>
                </tr>
                </c:if>
                </c:forEach>
                </tr>
            </table>
        </div>
    </div>
    <div class="row text-center" style="margin-left: 300px">
    <div class="col-sm-12">
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <li class="${pageBean.currentPage==1?'disabled':''}">
                    <a  href="${pageContext.request.contextPath}/admin?method=getUserList&currentPage=${pageBean.currentPage-1}" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>

                <c:forEach begin="1" end="${pageBean.totalPage}" step="1" var="index">
                    <c:if test="${pageBean.currentPage==index}">
                        <li class="active"><a href="${pageContext.request.contextPath}/admin?method=getUserList&currentPage=${index}">${index}</a></li>
                    </c:if>

                    <c:if test="${pageBean.currentPage!=index}">
                        <li ><a href="${pageContext.request.contextPath}/admin?method=getUserList&currentPage=${index}">${index}</a></li>
                    </c:if>
                </c:forEach>

                <li class="${pageBean.currentPage==pageBean.totalPage?'disabled':''}">
                    <a href="${pageContext.request.contextPath}/admin?method=getUserList&currentPage=${pageBean.currentPage+1}" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
            </ul>
        </nav>
    </div>
</div>
</body>
</html>
