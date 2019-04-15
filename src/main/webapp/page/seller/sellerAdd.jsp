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
        姓名<input type="text"  name="sellerName" id="sellerName">
        登录账号<input type="text"  name="sellerUser">
        密码<input type="text"  name="sellerPassword">
        性别<input type="radio" value="男" name="sellerSex" >男
        <input type="radio" value="女" name="sellerSex" >女 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br>
        生日<input type="date"  name="sellerBirthday"><br>
        证件号<input type="text"  name="sellerIdCard">
        Email<input type="text"  name="sellerEmail"><br>
        电话<input type="text"  name="sellerTel">
        地址<input type="text"  name="sellerAddress">
        <button type="submit" class="page-btn" name="save" onclick="saveNews()">保存</button>
    </form>
    <script type="text/javascript">
        function saveNews() {
        var queryString=$("form").serialize();
        $.getJSON("/doSel?action=selAdd",queryString,callback);

       function callback(data) {
           if (data.flag == "true") {
               alert("增加成功!");
           } else {
               alert("增加失败!")
           }
       }
  }
    </script>
</body>
</html>
