<%@ page import="java.util.Random" %><%--
  Created by IntelliJ IDEA.
  User: 52203
  Date: 2018/12/28
  Time: 8:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <base href="<%=request.getContextPath()%>/"/>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@include file="layUI.jsp"%>
</head>
<body>
<table>
    <p></p>
</table>
<script type="text/javascript" src="js/jquery-2.1.0.js"></script>
<script type="text/javascript">
    $(function () {
        show();
        setInterval("show()",5000);//1000为1秒钟
    });
    function show() {
        var id = 1;
        $("p").html("");
        $.getJSON("/NoticeServlet","action=selectid&id="+id,callback);
        function callback(data) {
            $("p").append("<tr>" +
                "<td>"+data.aTitle+"</td>" +"<br>"+
                "<td>"+data.aText+"</td>" +"u<br>"+
                "<td>"+data.aDate+"</td>"+
                "</tr>");
        }
    }
</script>
</body>
</html>
