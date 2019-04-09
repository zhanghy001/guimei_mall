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
<form action="doSmall?action=smallUpdate" method="post">
    <di id="d1"></di>
    小分类ID<input type="text" value="${Small.id}" name="id" readonly>
    小分类名称<input type="text" value="${Small.smallName}" name="smallName" id="smallName">
    大分类名称<select name="smallBigId" id="smallBigId">
        <option value="${Small.bigclass.id}">${Small.bigclass.bigName}</option>
    </select>
    小分类描述<input type="text" value="${Small.smallText}" name="smallText" >
    <input type="submit" value="修改完成" class="layui-btn" id="sub"  >
</form>
</body>
</html>
