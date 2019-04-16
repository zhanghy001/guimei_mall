<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <base href="<%=request.getContextPath()%>/"/>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@include file="layUI.jsp"%>
</head>
        <table width="100%" style="text-align: center" class="layui-table">
            <tr>
                <th>ID</th>
                <th>姓名</th>
                <th>登录账号</th>
                <th>性别</th>
                <th>生日</th>
                <th>证件号</th>
                <th>Email</th>
                <th>电话</th>
                <th>地址</th>
            </tr>
                <tr>
                    <td>${seller.sellerId}      </td>
                    <td>${seller.sellerName}    </td>
                    <td>${seller.sellerUser}    </td>
                    <td>${seller.sellerSex}     </td>
                    <td>${seller.sellerBirthday}</td>
                    <td>${seller.sellerIdCard}  </td>
                    <td>${seller.sellerEmail}   </td>
                    <td>${seller.sellerTel     }</td>
                    <td>${seller.sellerAddress}  </td>
                </tr>
        </table>
<script type="text/javascript">
</script>
</body>
</html>