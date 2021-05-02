<%--
  Created by IntelliJ IDEA.
  User: Mike-Qian
  Date: 2021/4/30
  Time: 17:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <div>
      <c:forEach items="${list}" var="g">
          <p>${g.mDate} ${g.username}:${g.mContent}</p>
      </c:forEach>
  </div>
</body>
</html>
