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
    <%@include file="../layUI.jsp"%>
</head>
<body>
    <c:choose>
        <c:when test="${not empty Page.pageData}">
            <table width="100%" style="text-align: center" class="layui-table">
                <tr>
                    <th>ID</th>
                    <th>标题</th>
                    <th>内容</th>
                    <th>日期</th>
                    <th colspan="2">操作</th>
                </tr>

                <tr>
                    <td colspan="5">
                        <%@include file="../Page.jsp"%>
                    </td>
                </tr>
            </table>
        </c:when>
        <c:otherwise>
            <h3>没有公告了</h3>
        </c:otherwise>
    </c:choose>
</body>
</html>
