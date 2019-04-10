<%--
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
        $.getJSON("/NoticeServlet","action=select",callback);
        function callback(data) {
            for (var i = 0; i<data.length ; i++) {
                $("p").append("<tr>" +
                    "<td>"+data[i].aTitle+"</td>" +
                    "<td>"+data[i].aText+"</td>" +
                    "<td>"+data[i].aDate+"</td>"+
                    "</tr>");
            }
        }
    })

</script>
</body>
</html>
