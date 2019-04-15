<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <base href="<%=request.getContextPath()%>/"/>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@include file="../layUI.jsp"%>
</head>
<body>
<form action="doUser?action=userUpdatePwd" method="post">
    ID<input type="text" value="${User.id}" name="id" readonly>
    姓名<input type="text" value="${User.userName}" name="userName" readonly>
    密码<input type="text" value="${User.userPassWord}" name="userPassWord">
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
            }else {
                $("#err1").html("修改失败").css("color","red");
            }
        }
    })
</script>
</html>
