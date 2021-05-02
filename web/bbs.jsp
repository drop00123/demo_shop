<%--
  Created by IntelliJ IDEA.
  User: Mike-Qian
  Date: 2021/4/28
  Time: 22:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link href="css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery.min.js"></script>
<head>
    <title>留言板</title>
</head>
<script>

</script>
<body>
<div style="text-align: center;margin-bottom: 50px ">
    <h3><a href="user?method=bbsDetail" style="text-decoration-line:none">历史评论</a></h3>
</div>
<div class="container-fluid" style="height:600px;width: 500px;border: 1px black solid">

    <form action="user?method=addBbs" method="post">
        <div class="container-fluid thumbnail " style="margin-top: 40px"  >
            <textarea placeholder="请提出您的宝贵意见" autofocus style="width: 455px;height: 400px; resize:none" name="bbs"></textarea><br>
        </div>
              <div style="text-align: center">
                  <input class="btn-success text-center" style="width: 100px ;height: 70px" type="submit" value="提交">&nbsp;&nbsp;&nbsp;&nbsp;
                  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  <input class="btn-warning text-center"  style="width: 100px ;height: 70px"  type="reset" value="重置">
              </div>
    </form>

</div>

</body>
</html>
