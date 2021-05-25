<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="../css/bootstrap.min.css" />
<script src="../js/jquery.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/DatePicker.js"></script>
<title>商品列表</title>

</head>
<body>
<%@include file="frame.jsp"%>
<div class="row" style="margin-left: 300px;">
	<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">
				会员列表
			</div>
			<div class="panel-body">
				<div class="row">
					<div class="col-xs-5 col-sm-5 col-md-5 col-lg-5">
						<div class="form-group form-inline">
							<span>商品名称</span>
							<input type="text" name="name" class="form-control">
						</div>
					</div>
					<div class="col-xs-5 col-sm-5 col-md-5 col-lg-5">
						<div class="form-group form-inline">
							<span>上架时间</span>
							<input type="text" readonly="readonly"  name="pubdate" class="form-control" onclick="setday(this)">
						</div>
					</div>
					<div class="col-xs-2 col-sm-2 col-md-2 col-lg-2">
						<button type="button" class="btn btn-primary" id="search"><span class="glyphicon glyphicon-search"></span></button>
					</div>
				</div>
				<div style="height: 400px;overflow: scroll;">
					<table id="tb_list" class="table table-striped table-hover table-bordered">
						<tr>
							<td>序号</td><td>商品名称</td><td>价格</td><td>上架时间</td><td>类型</td><td>操作</td>
						</tr>

						<c:forEach items="${goodsList.list}" var="goods" varStatus="i">
							<tr>
								<td>${i.count}</td>
								<td>${goods.pname}</td>
								<td>${goods.pprice}</td>
								<td>${goods.ptime}</td>
								<td>${goods.tname}</td>
								<td>删除 &nbsp;修改 &nbsp;
									<a tabindex="0" id="example${goods.pid}" class="btn btn-primary btn-xs"
									role="button" data-toggle="popover"
									data-trigger="focus"
									data-placement="left"
									data-content="${goods.pinfo}">描述</a>
									<script type="text/javascript">
										$(function(){
											$("#example${goods.pid}").popover();
										})
									</script>
								</td>
							</tr>
						</c:forEach>
					</table>
				</div>
	<%--			<div class="row text-center">
					<div class="col-sm-12">
						<nav aria-label="Page navigation">
							<ul class="pagination">
								<li class="${goodsList.page==1?'disabled':''}">
									<a  href="${pageContext.request.contextPath}/admin?method=goodsShow&page=${goodsList.page-1}" aria-label="Previous">
										<span aria-hidden="true">&laquo;</span>
									</a>
								</li>

								<c:forEach begin="1" end="${goodsList.totalPage}" step="1" var="index">
									<c:if test="${goodsList.page==index}">
										<li class="active"><a href="${pageContext.request.contextPath}/admin?method=goodsShow&currentPage=${index}">${index}</a></li>
									</c:if>

									<c:if test="${goodsList.page!=index}">
										<li ><a href="${pageContext.request.contextPath}/admin?method=goodsShow&currentPage=${index}">${index}</a></li>
									</c:if>
								</c:forEach>

								<li class="${goodsList.page==goodsList.totalPage?'disabled':''}">
									<a href="${pageContext.request.contextPath}/admin?method=goodsShow&currentPage=${goodsList.Page+1}" aria-label="Next">
										<span aria-hidden="true">&raquo;</span>
									</a>
								</li>
							</ul>
						</nav>
					</div>
				</div>--%>
			</div>

			
		</div>
	</div>
</div>
</body>
</html>