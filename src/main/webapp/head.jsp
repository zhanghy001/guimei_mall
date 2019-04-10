
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>贵美商城</title>
    <base href="<%=request.getContextPath() %>/" />
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@include file="layUI.jsp"%>
	<link href="../css/guimei.css" rel="stylesheet" type="text/css">
	<script type="text/javascript" src="../js/jquery-2.1.0.js"></script>



<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" src="js/jquery-2.1.0.js"></script>
<script type="text/javascript" src="static/js/jquery-1.8.2.min.js"></script>
<html>
<head>
    <title>贵美商城</title>
	<link href="css/guimei.css" rel="stylesheet" type="text/css">

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

            <a href="Login.jsp" target="body_i" class="a_login">商家</a>
        </div>
        <div class="login_a">
            <div class="login_b" style="background-position:-44PX 0 "></div>
            <a href="Login.jsp" class="a_login">管理员</a>
        </div>
        <div class="login_a">
            <div class="login_b" style="background-position:-89PX 0 "></div>
            <a class="a_login"  >加入收藏</a>
        </div>
        <div class="login_a">
            <div class="login_b" style="background-position:-130PX 0 "></div>
            <a class="a_login" >设为首页</a>
        </div>
        <div class="login_a" style="width: 100px;margin-left: 5px">
            <a href="../../Cuslogin.jsp">
                <div id="login_d">登录</div>
            </a>
                <a href="register.jsp">
                    <div id="login_z">注册</div>
                </a>
        </div>
    </div>
    <div id="welcome">

        <label><b id="loginName"></b>您好，欢迎您光临贵美商城！</label>
        <label id="shijian"></label><b id="out"><b id="outPage" href="doCus?action=out"  ><b>退出</b></b></b></a>
    </div>
    <div style="position: relative;top: 10px;">
            <div class="head_dh_tap">首页</div>
            <div class="head_dh_tap" >家用电器</div>
        	<div class="head_dh_tap" >手机数码</div>
            <div class="head_dh_tap" >日用百货</div>
            <div class="head_dh_tap" >书籍</div>
            <div class="head_dh_tap">帮助中心</div>
            <div class="head_dh_tap">免费开店</div>
            <div class="head_dh_tap">全球咨询</div>
  </div>
</div>
</body>
</html>