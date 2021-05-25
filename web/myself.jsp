<%--
  Created by IntelliJ IDEA.
  User: Mike-Qian
  Date: 2021/5/7
  Time: 21:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<button class="btn btn-default btn-sm" data-toggle="modal" data-target="#myModal${address.aid}">修改</button>&nbsp;&nbsp;
<!-- 弹出模态框 -->
<div class="modal fade" tabindex="-1" role="dialog" id="myModal${address.aid}">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">
                    <span>&times;</span>
                </button>
                <h4 class="modal-title">修改地址</h4>
            </div>
            <form action="address?method=update" method="post" class="form-horizontal">
                <div class="motal-body">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">收件人</label>
                        <div class="col-sm-10">
                            <input type="hidden" name="aid" value="${address.aid}">
                            <input type="hidden" name="astate" value="${address.astate}">
                            <input type="text" name="aname" class="form-control" value="${address.aname}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">电话</label>
                        <div class="col-sm-10">
                            <input type="text" name="aphone" class="form-control" value="${address.aphone}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">详细地址</label>
                        <div class="col-sm-10">
                            <input type="text" name="adetail" class="form-control" value="${address.adetail}">
                        </div>
                    </div>

                </div>
                <div class="motal-footer">
                    <button type="submit" class="btn btn-primary">修改</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
