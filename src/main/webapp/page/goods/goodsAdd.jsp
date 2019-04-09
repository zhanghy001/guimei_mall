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
<form action="doGoods?action=goodsAdd" method="post" enctype="multipart/form-data">
    <di id="d1"></di>
    商品名称<input type="text"  name="goodsName" id="goodsName">
    小分类名称<select name="goodsSmalId" id="goodsSmalId">
    </select>
    商品的价格<input type="text"  name="goodsMoney" >
    商品的数量<input type="text" name="goodsNumber" >
    商品的图像<input type="file"  name="goodsImage" onchange="checkImage(this.value)">
    商品的运费<input type="text"  name="goodsCarriage" >
    商品的类型<select name="goodsType" id="goodsType">
    <option value="${0}">新品</option>
    <option value="${1}">二手</option>
</select>
    商家名称<select name="goodsSeId" id="goodsSeId">
</select>
    商品的折扣<select name="goodsDiscId" id="goodsDiscId">
</select>
    <input type="submit" value="添加" class="layui-btn" id="sub"  disabled="true">
</form>
</body>
</html>
