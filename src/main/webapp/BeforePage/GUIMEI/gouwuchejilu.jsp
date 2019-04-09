<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>购物车</title>
	<base href="<%=request.getContextPath()%>/"/>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <link href="css/guimei.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="../js/jquery-2.1.0.js"></script>
	<%@include file="layUI.jsp"%>
</head>
<body>
<%@include file="head.jsp"%>
    <div id="wodeguc" >
        <img src="images/img/images/mycart.gif">
        <label class="wudeguclabel">购买历史</label>
    </div>

    <div id="quanren"  style="margin: auto;">
        <p id="wodeguc_2jibiaoti">购物车内已付款商品历史记录</p>
        <table border="0px" width="95%"style="margin:30px;">
	        <thead style="font-size: 16px;color:red;line-height:65px; text-align: center; ">
	        	<tr id="quanrentable_hang1">
	                <td style="width:36%;text-align:left;">商品名</td>
	                <td style="width:20%;">图片</td>
	                <td style="width:8%;">原价</td>
	                <td style="width:8%;">优惠价</td>
	                <td style="width:8%;">打折</td>
	                <td style="width:8%;">数量</td>
	            </tr>
        	</thead>
				<c:forEach items="${Page.pageData}" var="all" varStatus="i">
			<tr >

				<td style="width:36%;text-align:left;">${all.goods.goodsName}</td>
				<td style="width:20%;"><a  href="doGoods?action=goodsLookByIg&id=${all.goods.id}" >
					<img src="GoodsImage/${all.goods.goodsImage}" style="width: 80px;height: 80px" ></a></td>
				<td style="width:8%;">${all.goods.goodsMoney}</td>
				<td style="width:8%;">${all.cheapPrice}</td>
				<td style="width:8%;">${all.discount.discRate}</td>
				<td style="width:8%;" >${all.shoppingcar.scNumber}</td>
			</tr>
				</c:forEach>
			<tr>
				<td colspan="5">
					<jsp:include page="Page.jsp"/>
				</td>
				<td colspan="2" style="text-align: right;">
					<p><a href="BeforePage/GUIMEI/homepage.jsp">返回继续购买商品</a></p>
				</td>
			</tr>

        </table>
    </div>
<div style="margin: 100px 0px 0px 0px"><jsp:include page="foot.jsp"/></div>
</body>
</html>