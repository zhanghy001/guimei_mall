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
    <form action="doSel?action=selUpdate" method="post">
        <div id="d1"></div>
        ID<input type="text" value="${Sel.id}" name="id" readonly>
        姓名<input type="text" value="${Sel.sellerName}" name="sellerName" id="sellerName">
        登录账号<input type="text" value="${Sel.sellerUser}" name="sellerUser">
        性别<input type="radio" value="男" name="sellerSex" ${Sel.sellerSex=='男'?'checked':''}>男
        <input type="radio" value="女" name="sellerSex" ${Sel.sellerSex=='女'?'checked':''}>女 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        生日<input type="date" value="${Sel.sellerBirthday}" name="sellerBirthday"><br>
        证件号<input type="text" value="${Sel.sellerIdCard}" name="sellerIdCard">
        Email<input type="text" value="${Sel.sellerEmail}" name="sellerEmail"><br>
        电话<input type="text" value="${Sel.sellerTel}" name="sellerTel">
        地址<input type="text" value="${Sel.sellerAddress}" name="sellerAddress">
        <input type="submit" value="修改完成" class="layui-btn" id="sub">
    </form>
</body>
</html>
