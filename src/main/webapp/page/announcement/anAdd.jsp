<%--
  Created by IntelliJ IDEA.
  User: 52203
  Date: 2018/12/27
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <base href="<%=request.getContextPath()%>/"/>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <script src="/static/js/jquery-1.8.2.min.js"></script>
    <%@include file="../layUI.jsp"%>

</head>

<body>
    <form action="doAn?action=anAdd" method="post">
        <div id="d1"></div>
        标题<input type="text" name="aTitle" id="aTitle">
        内容<input type="text" name="aText">
        日期<input type="date" name="aDate"><br>
        <input type="submit" value="添加" class="layui-btn" id="sub">
    </form>
</body>
</html>
