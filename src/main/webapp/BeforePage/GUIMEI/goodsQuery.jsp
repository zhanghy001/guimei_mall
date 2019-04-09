<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <base href="<%=request.getContextPath()%>/"/>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <script src="static/js/jquery-2.1.1.min.js"></script>
    <%@include file="layUI.jsp"%>
</head>
<body>
<c:choose>
    <c:when test="${not empty Page.pageData}">
            <c:forEach items="${Page.pageData}" var="all">
            <div style="float: left;font-size: 10px;width: 80px;height: 80px;margin: 8px 0px 18px 40px;"> <a  href="doGoods?action=goodsLookByIg&id=${all.goods.id}" target="_parent">
                        <img src="GoodsImage/${all.goods.goodsImage}" style="width: 80px;height: 80px" ><br>${all.goods.goodsName}</a>

            </div>
            </c:forEach>
<div style="clear: both"><br><br><br><%@include file="Page.jsp"%></div>
    </c:when>
    <c:otherwise>
        <h3>没有商品了</h3>
    </c:otherwise>
</c:choose>
</body>
</html>
