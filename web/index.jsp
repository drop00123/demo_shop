<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="css/login2.css">
<link href="css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<title>便民商城首页</title>
    <link rel="icon" type="image/x-icon" href="icon/shop.jpg" />
</head>
<body>
<%@ include file="header.jsp"%>
<!--网站中间内容开始-->
<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
        <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
        <li data-target="#carousel-example-generic" data-slide-to="1"></li>
        <li data-target="#carousel-example-generic" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox" style="width: 1578px;height: 309px">
        <div class="item active">
            <img src="image/lun1.jpg" class="img-circle" alt="...">
        </div>
        <div class="item">
            <img src="image/lun4.jpg" class="img-circle" alt="...">
        </div>
        <div class="item">
            <img src="image/lun5.jpg" class="img-circle" alt="...">
        </div>

    </div>

    <!-- Controls -->
    <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>
</div>

   <div id="forth">
        <a href="" id="a_left"><img src="image/f0.png" width="200" height="160" /></a>
        <a href="" id="a_left"><img src="image/f1.jpg" width="316" height="170" /></a>
        <a href="" id="a_left"><img src="image/f2.jpg" width="316" height="170" /></a>
    	<a href="" id="a_left"><img src="image/f3.jpg" width="316" height="170" /></a>
   </div>
   <div id="fifth">
   		<span id="fif_text">上周明星单品</span>
   </div>
    <div id="sixth">
            <span style="margin-left:0px; border-top:#ffa500 1px solid">
            	<a href="${pageContext.request.contextPath}/product?method=detail&pid=1" id="siximg"><img src="goods/206.jpg" width="234" height="234" />
            	<a href="${pageContext.request.contextPath}/product?method=detail&pid=1" id="na">华为mate40pro</a>
                <p id="chip">以旧换新,最高免1000元</p>
                <p id="pri">6499元起</p></a>
            </span>
            <span style=" border-top:#008000 1px solid">
                <a href="${pageContext.request.contextPath}/product?method=detail&pid=45" id="siximg"><img src="goods/254.jpg" width="234" height="234" />
                <a href="${pageContext.request.contextPath}/product?method=detail&pid=45" id="na">外科口罩</a>
                <p id="chip">39.95每盒,第二盒半价</p>
                <p id="pri">39.95元起</p></a>
            </span>
            <span style="border-top:#0000ff 1px solid">
                <a href="${pageContext.request.contextPath}/product?method=detail&pid=49" id="siximg"><img src="goods/258.jpg" width="234" height="234" />
                <a href="${pageContext.request.contextPath}/product?method=detail&pid=49" id="na">滴露消毒液</a>
                <p id="chip">两套平均到手只要124.9</p>
                <p id="pri">124.9元起</p></a>
            </span>
            <span style="border-top:#ff0000 1px solid">
                <a href="${pageContext.request.contextPath}/product?method=detail&pid=22" id="siximg"><img src="goods/51.jpg" width="234" height="234" />
                <a href="${pageContext.request.contextPath}/product?method=detail&pid=22" id="na">新鲜黑木耳</a>
                <p id="chip">3月21日--5月21日,7.5折!!!</p>
                <p id="pri">48元起</p></a>
            </span>
            <span style="border-top:#008080 1px solid">
                <a href="${pageContext.request.contextPath}/product?method=detail&pid=35" id="siximg"><img src="goods/156.jpg" width="234" height="234" />
                <a href="${pageContext.request.contextPath}/product?method=detail&pid=35" id="na">奶油小蛋糕</a>
                <p id="chip">月销1000+,吃过的都说好</p>
                <p id="pri">15元起</p></a>
            </span>
    </div>
<%--<div id="fifth">
    <span id="fif_text">上周明星单品</span>
</div>--%>
<div id="sixth">
            <span style="margin-left:0px; border-top:#ffa500 1px solid">
            		<a href="${pageContext.request.contextPath}/product?method=detail&pid=20" id="siximg"><img src="goods/12.jpg" width="234" height="234" />
            	<a href="${pageContext.request.contextPath}/product?method=detail&pid=20" id="na">adidas板鞋</a>
                <p id="chip">只要198!,就能带回家</p>
                <p id="pri">198元起</p></a>
            </span>
    <span style=" border-top:#008000 1px solid">
            		<a href="${pageContext.request.contextPath}/product?method=detail&pid=45" id="siximg"><img src="goods/254.jpg" width="234" height="234" />
                <a href="${pageContext.request.contextPath}/product?method=detail&pid=45" id="na">正味烤鸭</a>
                <p id="chip">好吃不腻,外焦里嫩!</p>
                <p id="pri">25元起</p></a>
            </span>
    <span style="border-top:#0000ff 1px solid">
            		<a href="${pageContext.request.contextPath}/product?method=detail&pid=13" id="siximg"><img src="goods/5.jpg" width="234" height="234" />
                <a href="${pageContext.request.contextPath}/product?method=detail&pid=13" id="na">女士羊绒外套</a>
                <p id="chip">最好的温暖,送给最爱的她!</p>
                <p id="pri">249元起</p></a>
            </span>
    <span style="border-top:#ff0000 1px solid">
                <a href="${pageContext.request.contextPath}/product?method=detail&pid=19" id="siximg"><img src="goods/11.jpg" width="234" height="234" />
                <a href="${pageContext.request.contextPath}/product?method=detail&pid=19" id="na">女士衬衣</a>
                <p id="chip">用的是新疆的优质绵!</p>
                <p id="pri">48元起</p></a>
            </span>
    <span style="border-top:#008080 1px solid">
               <a href="${pageContext.request.contextPath}/product?method=detail&pid=2" id="siximg"><img src="goods/200.jpg" width="234" height="234" />
                <a href="${pageContext.request.contextPath}/product?method=detail&pid=2" id="na">扫地机器人</a>
                <p id="chip">你负责赚钱,我负责美家!</p>
                <p id="pri">2699元起</p>
               </a>
            </span>
</div>
   <!-- 底部 -->
   <%@ include file="footer.jsp"%>
</body>
</html>