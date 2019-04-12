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
    <form action="" method="post">
        <div id="d1"></div>
        标题<input type="text" name="aTitle" id="aTitle">
        内容<input type="text" name="aText" id="aText">
        日期<input type="date" name="aDate" id="aDate"> <br>
        <input type="button" value="添加" class="layui-btn" id="sub" onclick="addNotice()">
    </form>

    <script type="text/javascript" src="js/jquery-2.1.0.js"></script>
<script type="text/javascript">

    function addNotice(){
        var atitle = $("#aTitle").val();
        if (atitle == "" || atitle == undefined){
            alert("标题不能为空");
            return;
        }
        var aText = $("#aText").val();
        if (aText == "" || aText == undefined){
            alert("内容不能为空");
            return;
        }
        var aDate = $("#aDate").val();
        if (aDate == "" || aDate == undefined){
            alert("标题不能为空");
            return;
        }
        var paramArray = $("form").serializeArray(); //序列化为json数组
        var queryString = $.param(paramArray);//将数组序列化为字符串
        $.getJSON("/NoticeServlet?action=add",queryString,callback);
        function callback(data) {
            if (data.flag == "true"){
                alert("添加成功")
                $("#aTitle").val("");
                $("#aText").val("");
                $("#aDate").val("");
            }else {
                alert("添加失败")
            }
        }
    }


</script>
</body>
</html>
