<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <base href="<%=request.getContextPath()%>/"/>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@include file="../layUI.jsp"%>
</head>
<body>

    <form action="doCus?action=cusQueryLike&pageNumber=1" method="post" >
        <label>ID</label>
        <input type="text" name="id">
        <label>姓名</label>
        <input type="text" name="cusName">
        <label>姓别</label>
        <input type="text" name="cusSex">
        <input class="layui-btn" type="submit" value="查询">
    </form>

    <c:choose>
        <c:when test="${not empty Page.pageData}">
            <table width="100%" style="text-align: center" class="layui-table">
                <tr>
                    <th>ID</th>
                    <th>姓名</th>
                    <th>登录账号</th>
                    <th>Email</th>
                    <th>性别</th>
                    <th>头像</th>
                    <th>爱好</th>
                    <th>证件号</th>
                    <th>生日</th>
                    <th colspan="2">操作</th>
                </tr>

                <tr>
                    <td colspan="10">
                        <%@include file="../Page.jsp"%>
                    </td>
                </tr>
            </table>
        </c:when>
        <c:otherwise>
            <h3>没有顾客</h3>
        </c:otherwise>
    </c:choose>


</body>
</html>
