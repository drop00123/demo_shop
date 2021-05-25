<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
		 pageEncoding="utf-8"%>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="../css/bootstrap.min.css" />
<script src="../js/jquery.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<title>添加商品种类</title>
</head>
<body>
<%@include file="frame.jsp"%>
<div style="padding-left: 300px">
	<div class="panel panel-default">
		<div class="panel-heading">
			添加商品种类
		</div>
		<div class="panel-body" style="padding-left: 30px">
			<form action="${pageContext.request.contextPath}/admin?method=addType" method="post">
				<div class="row" >
					<div class="form-group form-inline">
						<span>种类名称</span>
						<input type="text" style="width:500px" name="typeName"  class="form-control">
					</div>
				</div>
				<div class="row">
					<div class="form-group form-inline">
						<span>种类描述</span>
						<input type="text" style="width: 500px" name="typeInfo" class="form-control">
					</div>
				</div>
				<div class="row">
					<div class="col-sm-6">
						<button type="reset" class="btn btn-warning" style="margin-left: 50px">清空</button>
					</div>
					<div  class="col-sm-6">
						<button type="submit" class="btn btn-success">添加</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>
</body>
</div>
</body>
</html>
