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
<form action="doSmall?action=SmallUpdate" method="post">
    <di id="d1"></di>
    小分类ID<input type="text" value="${Small.id}" name="id" readonly>
    小分类名称<input type="text" value="${Small.smallName}" name="smallName" id="smallName">
    大分类名称<select name="smallBigId" id="smallBigId">
    </select>
    小分类描述<input type="text" value="${Small.smallText}" name="smallText" id="smallText">
    <input type="submit" value="修改完成" class="layui-btn" id="sub"  ><br/>
    <label id="err1"></label>
</form>
</body>
<script type="text/javascript">
    $(function () {
        $("#smallBigId").load("doSmall?action=getBigName&id="+${Small.smallBigId});
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
