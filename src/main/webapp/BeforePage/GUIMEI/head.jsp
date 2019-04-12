<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>贵美商城</title>
    <base href="<%=request.getContextPath() %>/" />
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@include file="layUI.jsp"%>
	<link href="../../css/guimei.css" rel="stylesheet" type="text/css">
	<script type="text/javascript" src="../../js/jquery-2.1.0.js"></script>
 
    <script>
		//当前时间显示
      function nowdate() {
        	document.getElementById("shijian").innerHTML = new Date().toLocaleString();
        	setTimeout(nowdate, 1000);
        }

    </script>

</head>
<body onload="nowdate()">
<div id="head">
    <div id="login">
        <div class="login_a" style="margin-left: 12px;width: 80px">
            <div class="login_b" style="background-position:-3PX 0 "></div>
            <a href="doShop?action=shopQuery&pageNumber=1&cusId=${customer.id}" class="a_login">购物车</a>
        </div>
        <div class="login_a">
            <div class="login_b" style="background-position:-44PX 0 "></div>
            <a href="doOrder?action=init" class="a_login">订单</a>
        </div>
        <div class="login_a">
            <div class="login_b" style="background-position:-89PX 0 "></div>
            <a class="a_login" href="doCus?action=QueryById&id=${customer.id}">个人信息</a>
        </div>
        <div class="login_a">
            <div class="login_b" style="background-position:-130PX 0 "></div>
            <a href="doShop?action=shopQueryOld&pageNumber=1&cusId=${customer.id}" class="a_login">购物记录</a>
        </div>
        <div class="login_a" style="width: 100px;margin-left: 5px">
            <a href="Cuslogin.jsp" target="body_i">
                <div id="login_d">登录</div>
            </a>
            <a href="Cuslogin.jsp" target="body_i">
                <div id="login_z">注册</div>
            </a>
        </div>

    </div>
    <div id="welcome">
        <b id="loginName"></b>您好，欢迎&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="CusImage/${customer.cusPhoto}" class="layui-nav-img">
            ${customer.cusName}登录贵美商城！<b id="shijian"></b><b id="out"><a id="outPage" href="doCus?action=out"  ><b id="exit">退出</b></a>
    </div>
   <form action="doGoods?action=goodsCusQueryLike&pageNumber=1" method="post">
       <div id="search" style="width:230px;height:30px;float:right;margin:11px 8px 0 0;">
           <input type="text" name="goodsName" id="ser" style="width:160px;height:22px;margin:0">
           <input type="image" src="../images/img/head/search.jpg" id="sea" style="float:right;">

       </div>
   </form>
    <div id="head_dh">
        <a href="../../BeforePage/GUIMEI/homepage.jsp">
            <div class="head_dh_tap">首页</div>
        </a>
        <div class="head_dh_tap" ><a href="doGoods?action=goodsByBig&pageNumber=1&id=1">家用电器</a></div>
        	<div class="head_dh_tap" ><a href="doGoods?action=goodsByBig&pageNumber=1&id=2">手机数码</a></div>
            <div class="head_dh_tap"><a href="doGoods?action=goodsByBig&pageNumber=1&id=3">日用百货</a></div>
            <div class="head_dh_tap" ><a href="doGoods?action=goodsByBig&pageNumber=1&id=4">书籍</a></div>
            <div class="head_dh_tap">帮助中心</div>
            <div class="head_dh_tap">免费开店</div>
            <div class="head_dh_tap">全球咨询</div>
    </div>
</div>
</body>
</html>