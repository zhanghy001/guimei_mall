<%--
  Created by IntelliJ IDEA.
  User: 52203
  Date: 2018/12/27
  Time: 16:28
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
<form action="doUser?action=userUpdate" method="post">
    ID<input type="text" value="${User.id}" name="id" readonly>
    姓名<input type="text" value="${User.userName}" name="userName">
    身份证号<input type="text" value="${User.userID}" name="userID">
    登录名<input type="text" value="${User.userLoginName}" name="userLoginName">
    <input type="submit" value="修改完成" class="layui-btn"><br/>
    <label id="err1"></label>
</form>
</body>
<script type="text/javascript" src="../../js/jquery-2.1.0.js"></script>
<script type="text/javascript">
    $(function () {
        var msg="${param.msg}";
        if(msg.length>0){
            if(msg=="0"){
                $("#err1").html("修改成功").css("color","red");
            }else if(msg==1) {
                $("#err1").html("修改失败").css("color","red");
            }
        }
    })
</script>


</html>
