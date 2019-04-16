<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <base href="<%=request.getContextPath()%>/"/>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@include file="layUI.jsp"%>
</head>

<body>
<form action="doSel?action=selUpdateLogin" method="post">
    <div id="d1"></div>

    ID<input type="text"       value="${seller.sellerId}" name="id" id="id" readonly>
    姓名<input type="text"     value="${seller.sellerName}" name="sellerName" id="sellerName">
    登录账号<input type="text" value="${seller.sellerUser}" name="sellerUser"id="sellerUser">
    性别<input type="radio"   value="男" <c:if test="${seller.sellerSex=='男'}"> checked="checked" </c:if>  name="sellerSex" id="sellerSex">男
        <input type="radio"   value="女" name="sellerSex" <c:if test="${seller.sellerSex=='女'}"> checked="checked" </c:if> id="sellerSex2">女 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br>
    生日<input type="date"     value="${seller.sellerBirthday}" name="sellerBirthday"id="sellerBirthday"><br>
    证件号<input type="text"   value="${seller.sellerIdCard}" name="sellerIdCard"id="sellerIdCard">
    Email<input type="text"    value="${seller.sellerEmail}" name="sellerEmail"id="sellerEmail"><br>
    电话<input type="text"     value="${seller.sellerTel}" name="sellerTel"id="sellerTel">
    地址<input type="text"     value="${seller.sellerAddress}" name="sellerAddress"id="sellerAddress">

    <input type="button" value="修改完成" class="layui-btn" id="sub">
</form>
</body>
<script src="../js/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
    $("#sub").click(function () {
        var id=$("#id").val();
        var sellerName= $("#sellerName").val();
        var sellerUser=$("#sellerUser").val();
        var sex=$('input:radio[name="sellerSex"]:checked').val();
        var sellerBirthday=$("#sellerBirthday").val();
        var sellerIdCard=$("#sellerIdCard").val();
        var sellerEmail=$("#sellerEmail").val();
        var sellerTel=$("#sellerTel").val();
        var sellerAddress=$("#sellerAddress").val();
        $.getJSON("/doSel",{"action":"selUpdateLogin","id":id,"sellerName":sellerName,"sellerUser":sellerUser,
            "sellerSex":sex,"sellerBirthday":sellerBirthday,"sellerIdCard":sellerIdCard,
            "sellerEmail":sellerEmail,"sellerTel":sellerTel,"sellerAddress":sellerAddress},callback)

        function callback(data) {
            if(data.flag=="true"){
                alert("修改成功");
                window.location.href=document.referrer;
            }else {
                alert("修改失败")
            }
        }
    })
</script>
</html>
