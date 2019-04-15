<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <base href="<%=request.getContextPath()%>/"/>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <script src="/static/js/jquery-1.8.2.min.js"></script>
    <%@include file="layUI.jsp"%>

    <script>
        $(function () {
            var sellerNameOne=$("#sellerName").val().trim();
            $("#sellerName").blur(function () {
                var sellerName=$(this).val().trim();
                var status=true;
                if(sellerNameOne==sellerName){
                    status=false;
                }
                if(status){
                    var url="doSel";
                    var data="action=queryName&sellerName="+sellerName;
                    $.post(url,data,function (i) {
                        if(i==1){
                            $("#sub").prop("disabled",true);
                            $("#d1").html("要输入名字并不能重名").css("color","red");
                        }else {
                            $("#sub").prop("disabled",false);
                            $("#d1").html("输入名字可以使用").css("color","red");
                        }
                    },"json");
                }
            })
        })
    </script>
</head>

<body>
    <form action="doSel?action=sellerUpdatePwd" method="post">
        <div id="d1"></div>
        ID<input type="text"  value="${seller.sellerId}" name="id" id="id"readonly>
        姓名<input type="text" value="${seller.sellerName}" name="sellerName" id="sellerName" readonly>
        登录账号<input type="text" value="${seller.sellerUser}" name="sellerUser" id ="sellerUser" readonly>
        密码<input type="text" value="${seller.sellerPassword}" name="sellerPassword" id="sellerPassword">
        <input type="submit" value="修改完成" class="layui-btn" id="sub">
    </form>
</body>
<script src="../js/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
    $("#sub").click(function () {
        var id=$("#id").val();
        var sellerPassword=$("#sellerPassword").val();
        $.getJSON("/doSel",{"action":"sellerUpdatePwd","id":id,
            "sellerPassword":sellerPassword},callback)
        function callback(data) {
            if(data.flag=="true"){
                alert("修改成功");
            }else {
                alert("修改失败")
            }
        }
    })
</script>
</html>
