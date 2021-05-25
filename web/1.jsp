<%--
  Created by IntelliJ IDEA.
  User: Mike-Qian
  Date: 2021/5/23
  Time: 12:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/bootstrap.min.css" />
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</head>
<body>
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

</body>
</html>
