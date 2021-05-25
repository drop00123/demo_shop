<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		<title>商品分类</title>
	</head>
	<body>
	<%@include file="frame.jsp"%>
	<div id="typeShow" class="row" style="width:98%;margin-left: 1%;">
		<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">
					商品类型
				</div>
				<div class="panel-body">
					<div style="height: 400px;overflow: scroll;">
						<table id="tb_list" class="table table-striped table-hover table-bordered">
							<tr>
								<td>序号</td><td>类型</td><td>详情</td><td>操作</td>
							</tr>
							<c:forEach items="${goodsTypeList}" var="gtype" varStatus="i">
								<tr>
									<td>${i.count}</td>
									<td>${gtype.tname}</td>
									<td>${gtype.tinfo}</td>
									<td>
										<button class="btn btn-info" data-toggle="modal" data-target="#myModal${gtype.tid}">修改</button>&nbsp;&nbsp;
										<!-- 弹出模态框 -->
										<div class="modal fade" tabindex="-1" role="dialog" id="myModal${gtype.tid}">
											<div class="modal-dialog" role="document">
												<div class="modal-content">
													<div class="modal-header">
														<button type="button" class="close" data-dismiss="modal">
															<span>&times;</span>
														</button>
														<h4 class="modal-title">修改商品类型</h4>
													</div>
													<form action="admin?method=updateType" method="post" class="form-horizontal">
														<div class="modal-body">
															<div class="form-group">
																<label class="col-sm-2 control-label">类型编号</label>
																<div class="col-sm-10">
																	<input type="text" name="tid" class="form-control" value="${gtype.tid}" readonly="readonly">
																</div>
															</div>
															<div class="form-group">
																<label class="col-sm-2 control-label">类型名称</label>
																<div class="col-sm-10">
																	<input type="text" name="tname" class="form-control" value="${gtype.tname}">
																</div>
															</div>
															<div class="form-group">
																<label class="col-sm-2 control-label">类型介绍</label>
																<div class="col-sm-10">
																	<input type="text" name="tinfo" class="form-control" value="${gtype.tinfo}">
																</div>
															</div>

														</div>
														<div class="modal-footer">
															<button type="submit" class="btn btn-primary">修改</button>
														</div>
													</form>
												</div>
											</div>
										</div>
										&nbsp;&nbsp;
										<button class="btn btn-warning" onclick="deleteType(${gtype.tid})">删除</button>
									</td>
								</tr>
							</c:forEach>

						</table>
					</div>
				</div>

			</div>
		</div>
	</div>
	</body>
	</html>
</div>
</body>
</html>
