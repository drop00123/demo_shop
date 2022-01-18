<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" type="text/css" href="css/login2.css">
    <link rel="stylesheet" href="js/bootstrap.min.css" />
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <title>个人中心-收货地址页面</title>
    <link rel="icon" type="image/x-icon" href="icon/shop.jpg" />
    <script type="text/javascript">

        function deleteAddr(aid)
        {
            if (confirm("是否要删除地址？"))
            {
                location.href = "address?method=delete&aid="+aid;
            }
        }

        function defaultAddr(aid) {
            location.href = "address?method=setDefault&aid="+aid;
        }
        $(function () {
            $("#oldPassword").change(function () {
                $.get(
                    "user","oldPassword="+this.value+"&method=prove",function (data) {
                        if(data==1)
                        {
                            $("#passwordMsg").css("color","green");
                            $("#passwordMsg").html("√")
                        }
                        else
                        {
                            $("#passwordMsg").css("color","red");
                            $("#passwordMsg").html("密码错误");
                        }
                    }
                )
            })
        })
function checkPwd() {
    let pwd=$("#password").val();
    let pMsg=$("#pwd_prompt");
    let reg_pwd=/^\w{8,20}$/;
    if(reg_pwd.test(pwd)){
        pMsg.css("color","green");
        pMsg.html("√");
    }
    else
    {
        pMsg.css("color","red");
        pMsg.html("请输入8-20位字符");
    }
}
function rePwd() {
    let pwd=$("#password").val();
    let rPwd=$("#rePassword").val();
    let rMsg=$("#reMsg");
    let submit=$("input[type=submit]");
    if(pwd==rPwd)
    {
        submit.removeAttr("disabled");
        rMsg.css("color","green");
        rMsg.html("√");
    }
    else
    {
        rMsg.css("color","red");
        rMsg.html("两次密码输入不一致");
    }
}
    </script>
</head>
<body>
<%@ include file="header.jsp"%>
<!--网站中间内容开始-->
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
        <div id="big_right" style="height: 500px">
            <h2 style="color:cadetblue">当前为:修改密码页面</h2><br>
            <div class="center-block" style="margin-top: 80px;">
                <form class="form-horizontal" action="user?method=updatePwd" method="post">
                    <div class="form-group">
                        <label class="col-sm-4 control-label">原密码</label>
                        <div class="col-sm-5" style="width: 40%">
                            <input type="password" id="oldPassword" name="oldPassword"
                                   class="form-control col-sm-10" placeholder="Old Password" required/>
                        </div>
                        <div class="col-sm-3">
                            <span id="passwordMsg"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-4 control-label">新密码</label>
                        <div class="col-sm-5" style="width: 40%">
                            <input type="password" id="password" name="password" class="form-control col-sm-10"
                                   placeholder="New Password" onblur="checkPwd()" required/>
                        </div>
                        <div class="col-sm-3">
                            <div id="pwd_prompt"></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-4 control-label">确认密码</label>
                        <div class="col-sm-5" style="width: 40%">
                            <input type="password" id="rePassword" name="rePassword" class="form-control col-sm-10"
                                   placeholder="Password Again" onblur="rePwd()" required/>
                        </div>
                        <div class="col-sm-3">
                           <span id="reMsg"></span>
                        </div>
                    </div>
                    <div class="form-group" style="margin-top:50px">
                        <div class="col-sm-12">
                            <input type="reset" value="重置" class="btn btn-warning btn-lg" style="width: 100px;margin-right:250px" />
                            <input type="submit" value="确认修改" class="btn btn-primary  btn-lg" style="width: 100px;margin-right:250px" disabled/> &nbsp; &nbsp;
                        </div>
                    </div>
                    <div>${registerMsg}</div>
                </form>
            </div>
        </div>
    </div>
</div>
<!-- 底部 -->
<%@ include file="footer.jsp"%>

</body>
</html>