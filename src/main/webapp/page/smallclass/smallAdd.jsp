<%--
  Created by IntelliJ IDEA.
  User: 52203
  Date: 2018/12/29
  Time: 9:21
  To change this template use File | Settings | File Templates.
--%>
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
<form action="doSmall?action=smallAdd" method="post">
    <di id="d1"></di>
    小分类名称<input type="text"  name="smallName" id="smallName">
    大分类名称<select name="smallBigId" id="smallBigId">
    </select>
    小分类描述<input type="text" name="smallText" >
    <input type="submit" value="添加" class="layui-btn" id="sub"  >
</form>
</body>
<script type="text/javascript">

    $("#smallBigId").load("doSmall?action=getBigName&id=-1");

</script>
</html>
