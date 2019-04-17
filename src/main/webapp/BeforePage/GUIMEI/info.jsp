<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <base href="<%=request.getContextPath()%>/"/>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <link href="../../css/guimei.css" rel="stylesheet" type="text/css">
    <style>
    label{
    	color:red;
    }
    
        *{
            margin:0;
            padding: 0;

        }
        #info_biaoti{
            width: 980px;
            height: 60px;

        }
        #info_biaoti h4{
            line-height: 55px;
            text-align: center;
        }
        #info_changshu{
            width: 400px;
            height: 370px;
            margin-left: 20px;
            float: left;
        }
        #info_shangtu{
            width: 350px;
            height: 370px;

            float: left;
        }
        .infoimg{
            border: solid 1px ;
        }
        #infoimgsc{
            float: right;
            margin-right: 60px;
        }
        #info_changshu dl{
            width: 400px;
            height: 40px;
            border: solid 1px;
            background-color:aliceblue;
        }
        #info_changshu dt{
            width: 80px;
            height: 20px;
            float: left;
            margin-left: 10px;
            margin-top: 10px;

        }
        #info_changshu dd{
            font-size: 14px;
            width: 270px;
            height: 30px;
            float: right;
            margin-right: 20px;
            margin-top: 3px;

        }
        #info_changshu p{
            line-height: 30px;
        }
        #info_changshu hr{
            border-style:dashed;
            color: darkgray;
        }
        #infoimg1{
            margin: 20px 0 20px 0;
        }
        #info_changshu_left1{
            float: left;

        }
        #info_changshu_right1{
            float: left;
            margin-left: 100px;
        }
        #info_changshu_left2{
            float: left;
        }
        #info_changshu_right2{
            float: left;
            margin-left: 110px;
        }

    </style>
    <script type="text/javascript" src="../../js/jquery-2.1.0.js"></script>
<script>


</script>
</head>
<body>
<%@include file="head.jsp"%>
<div style="width:980px;height:450px;margin: auto">
    <div id="info_biaoti" style="text-align: center">
        ${All.goodsName}
        <h2 id="g_name" style="color:red;"></h2>
        <hr>
    </div>
    <div id="info_shangtu">
        <iframe id="ifa"  src="GoodsImage/${All.goodsImage}"  width="345px" height="250" frameborder="no" scrolling="no"  name="shangtu1" class="infoimg"></iframe>
        <dl>
        <a href="#"><img src="../../images/img/images/share.gif"></a>
        <a href="#"><img id="infoimgsc" src="../../images/img/images/favthis.gif"></a>
        </dl>
    </div>
    <div id="info_changshu" style="margin-left:150px;"  >
        <p>价格：<label id="g_money"></label>${All.goodsMoney}元</p>
        <hr>
        <p>运费：<label id="g_carriage"></label>${All.goodsCarriage}元</p>
        <hr>
        <a href="doShop?action=shopAdd&&goodsId=${All.id}"><img id="infoimg1" src="images/img/images/buynow.gif"></a>
        <dl>
            <dt><img src="../../images/img/images/onlinepay.gif"></dt>
            <dd>此商品支持网银支付，网上汇款免手续费。收货满意后出售者才能拿钱，货款都安全！</dd>
        </dl>
        <p>剩余时间：<label id="">24</label>小时</p>
        <hr>
        <p>本期出售：<label id="">100</label>件</p>
        <hr>
        <p>累计出售：<label id="">4532</label>件</p>
        <hr>
        <p id="info_changshu_left1">商品类型：${All.goodsSmallName}<label id="g_type"></label>&nbsp;</p>
        <p id="info_changshu_right1">所在地：<label id="">浙江</label></p><br style="clear: left">
        <hr>
        <p id="info_changshu_left2">商品数量：${All.goodsNumber}<label id="g_number"></label>件</p>
        <p id="info_changshu_right2">访问数：<label id="">10231</label>次</p>
    </div>
 </div>
<div style="margin: 100px"><jsp:include page="foot.jsp"/></div>

</body>
</html>