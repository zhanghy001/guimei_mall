<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <base href="<%=request.getContextPath()%>/"/>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <script src="static/js/jquery-2.1.1.min.js"></script>
    <%@include file="../layUI.jsp"%>
    <script type="text/javascript">
        $(function () {
            var msg="${param.msg}";
            if(msg.length>0){
                if(msg=="0"){
                    //  $("#err1").html("修改成功").css("color","red");
                    alert("添加成功！");
                    //   $(window).html("/page/index.jsp");
                }else if(msg==1) {
                    alert("添加失败！");
                    //     $("#err1").html("添加失败！！ 不能添加重复的分类名").css("color","red");
                }
            }

            var nameSta=false;
            var pwdSta=false;
            $("#add").click(function () {
                if($("#bigName").val().trim()==""){
                    // $(".lab1").html("账号不完整");
                    alert("账号不完整");
                }else {
                    nameSta=true;
                }
                if($("#bigText").val().trim()==""){
                    alert("密码不完整");
                }else {
                    pwdSta=true;
                }
                if(nameSta && pwdSta){
                    $("#forms").prop("action","doBig?action=bigAdd");
                }
            })
        })


    </script>
</head>
<body>
    <form id="forms" method="post">
        <div id="d1">&nbsp;</div>
        大分类名称<input type="text" name="bigName" id="bigName">
        大分类描述<input type="text" name="bigText" id="bigText">
        <input type="submit" value="添加" class="layui-btn" id="add">
    </form>
</body>
</html>
