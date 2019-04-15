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
    <%@include file="../layUI.jsp"%>
</head>

<body>
    <form action="doCus?action=cusUpdate" method="post">
        ID<input type="text" value="${Cus.id}" name="id" id="id" readonly>
        姓名<input type="text" value="${Cus.cusName}" name="cusName" id="cusName" readonly>
        登录账号<input type="text" value="${Cus.cusLoginName}" name="cusLoginName" id="cusLoginName">
        Email<input type="text" value="${Cus.cusEmail}" name="cusEmail" id="cusEmail"><br>
        性别<input type="radio" value="男" name="cusSex"   }>男
        <input type="radio" value="女" name="cusSex" }>女 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        爱好<input type="text" value="${Cus.cusHobby}" name="cusHobby" id="cusHobby">
        证件号<input type="text" value="${Cus.cusCode}" name="cusCode" id="cusCode">
        生日<input type="date" value="${Cus.cusBirthday}" name="cusBirthday" id="cusBirthday"><br>
        <input type="button" value="修改完成" class="layui-btn" onclick="update()">
    </form>

    <script type="text/javascript" src="js/jquery-2.1.0.js"></script>
    <script type="text/javascript">
        $(function () {
            $(function () {
                var id = '${param.id}';
                $.getJSON("/CustomerNewServlet","action=selectid&id="+id,callback);
                function callback(data) {
                    //`id``cusName``cusLoginName``cusPassword``cusEmail``cusSex``cusPhoto``cusHobby``cusCode``cusBirthday`
                    $("#id").val(data.id);
                    $("#cusName").val(data.cusName);
                    $("#cusLoginName").val(data.cusLoginName);
                    $("#cusPassword").val(data.cusPassword);
                    $("#cusEmail").val(data.cusEmail);

                   if(data.cusSex == "男"){
                       $("input:radio[value='男']").attr('checked','true');
                   }else {
                       $("input:radio[value='女']").attr('checked','true');
                   }
                    $("#cusPhoto").val(data.cusPhoto);
                    $("#cusHobby").val(data.cusHobby);
                    $("#cusCode").val(data.cusCode);
                    $("#cusBirthday").val(data.cusBirthday);
                }
            });
        });
        function update() {

            var paramArray = $("form").serializeArray(); //序列化为json数组
            var queryString = $.param(paramArray);//将数组序列化为字符串
            $.getJSON("/CustomerNewServlet?action=update", queryString, callback);

            function callback(data) {
                if (data.flag == "true") {
                    alert("修改成功")
                    location.href = "/page/customer/cusQuery.jsp";
                } else {
                    alert("修改失败")
                }
            }
        }
    </script>
</body>
</html>
