<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="css/login.css">
<script type="text/javascript" src="js/jquery.min.js"></script>

<title>登录</title>
	<link rel="icon" type="image/x-icon" href="icon/shop.jpg" />
	<script type="text/javascript">
	$(function(){
		//2.点击验证码 跟新验证码
		$("#pagecode").click(function(){
			$("#pagecode").attr("src","code?method=createCode&t="+Math.random());
		});

		//4.两周以内自动登录  友好提示 
		$("#autoLogin").click(function(){
			if(this.checked){
				$("#autoLoginMsg").html("非个人电脑请勿勾选此项").css("color","red");
			}else{
				$("#autoLoginMsg").html("");
			}
		})
	})
</script>
</head>
<body>
		<!-- login -->
		<div class="top center">
			<div class="logo center">
				<a href="${pageContext.request.contextPath }/index.jsp"><img src="./image/logo_top.png" width="200px" height="98px" alt=""></a>
			</div>
		</div>
		<form  method="post" action="user?method=login" class="form center" id="userLogin" >
		<div class="login" >
			<div class="login_center">
				<div class="login_top">
					<div class="left fl">会员登录</div>
					<div class="right fr">您还不是我们的会员？<a href="${pageContext.request.contextPath }/register.jsp" target="_self">立即注册</a></div>
					<div class="clear"></div>
					<div class="xian center"></div>
				</div>
				<div class="login_main center">
					<div class="username">
						<div class="left fl">用户名:&nbsp;</div>
						<div class="right fl">
						<input class="shurukuang" type="text" name="username" id="username"  placeholder="请输入你的用户名" required/>
						<label id="nameMsg"></label>
						</div>
					</div>
					<div class="username">
						<div class="left fl">密&nbsp;&nbsp;&nbsp;&nbsp;码:&nbsp;</div>
						<div class="right fl">
						<input class="shurukuang" type="password" name="password"  id="pwd"  placeholder="请输入你的密码" required/>
						</div>
					</div>
					<div class="username">
						<div class="left fl">验证码:&nbsp;</div>
						<div class="right fl"><input <%-- id="vcode"  --%>  style="width:150px;height:30px; padding-left: 8px" name="code" type="text" placeholder="验证码" required/>
						<img  id="pagecode" src="code?method=createCode"></div>
					</div>
					<div class="username">
						<div class="left fl">&nbsp;&nbsp;&nbsp;&nbsp;</div>
						<div class="right fl"><label id="checkMsg"></label></div>
					</div>
					<div class="username">
						<input id="autoLogin" name="auto" type="checkbox" />&nbsp;&nbsp;两周以内自动登录
						<span id="autoLoginMsg"></span>
					</div>
					<div class="login_submit">
						<input class="submit" type="submit" name="submit" value="立即登录" id="btn"  >
					</div>
					<span style="color:red">${msg}</span>
				</div>	
			</div>
		</div>
		</form>
		<footer>
			<div class="copyright">简体 | 繁体 | English | 常见问题</div>
			<div class="copyright">便民购物公司版权所有-京ICP备666666666-<img src="./image/ghs.png" alt="">京公网安备18888888888888号-京ICP证11000000号</div>

		</footer>

	</body>
</html>