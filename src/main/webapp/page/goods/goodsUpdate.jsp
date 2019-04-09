<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <base href="<%=request.getContextPath()%>/"/>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <script src="static/js/jquery-2.1.1.min.js"></script>
    <%@include file="../layUI.jsp"%>

</head>
<body>
商品图像<table ><tr><td><img src="GoodsImage/${All.goods.goodsImage} " style="width: 200px;height: 200px"></td></tr></table>
<form action="doGoods?action=goodsUpdate" method="post" enctype="multipart/form-data">
    <di id="d1"></di>
    商品id<input type="text" value="${All.goods.id}" name="id" readonly>
    商品名称<input type="text" value="${All.goods.goodsName}" name="goodsName" id="goodsName">
    小分类名称<select name="goodsSmalId" id="goodsSmalId">
        <option value="${All.id}">${All.smallName}</option>
    </select>
    商品的价格<input type="text" value="${All.goods.goodsMoney}" name="goodsMoney" >
    商品的数量<input type="text" value="${All.goods.goodsNumber}" name="goodsNumber" ><br>
    <%--需要修改的商品图像<input type="file"  name="goodsImage" onchange="checkImage(this.value)">--%>
    商品的运费<input type="text" value="${All.goods.goodsCarriage}" name="goodsCarriage" >
    商品的类型<select name="goodsType" id="goodsType">
    <option value="${All.goods.goodsType}">${All.goods.goodsType==0?'新品':'二手'}</option>
    <option value="${0}">新品</option>
    <option value="${1}">二手</option>
</select>
    商家名称<select name="goodsSeId" id="goodsSeId">
    <option value="${All.seller.id}">${All.seller.sellerName}</option>
</select>
    商品的折扣<select name="goodsDiscId" id="goodsDiscId">
    <option value="${All.discount.id}">${All.discount.discRate}</option>
</select>
    <input type="submit" value="修改完成" class="layui-btn" id="sub"  >
</form>
</body>
</html>
