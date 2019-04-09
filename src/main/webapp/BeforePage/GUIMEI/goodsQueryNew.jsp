<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <base href="<%=request.getContextPath()%>/"/>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <script src="static/js/jquery-2.1.1.min.js"></script>
    <%@include file="../GUIMEI/layUI.jsp"%>

</head>

            <c:forEach items="${All}" var="all">
            <div style="float: left; width: 80px;height: 80px;margin: 26px 0px 18px 25px;"> <a  href="doGoods?action=goodsLookByIg&id=${all.goods.id}" target="_parent">
                        <img src="GoodsImage/${all.goods.goodsImage}" style="width: 80px;height: 80px" ></a>

            </div>
            </c:forEach>

</html>
