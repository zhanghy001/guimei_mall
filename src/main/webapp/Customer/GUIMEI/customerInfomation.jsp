<%--
  Created by IntelliJ IDEA.
  User: zhang
  Date: 2019/4/11
  Time: 11:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>个人信息</title>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.staticfile.org/jquery/2.0.0/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <h3>
                我的个人信息
            </h3>
        </div>
    </div>
</div>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-condensed">
                <thead>
                <tr>
                    <th>用户名称</th>
                    <th>用户登录名</th>
                    <th>密码</th>
                    <th>邮箱</th>
                    <th>性别</th>
                    <th>兴趣爱好</th>
                    <th>身份证</th>
                    <th>出生年月</th>
                </tr>
                <tr>
                    <td>${customer.cusName}</td>
                    <td>${customer.cusLoginName}</td>
                    <td>${customer.cusPassword}</td>
                    <td>${customer.cusEmail}</td>
                    <td>${customer.cusSex}</td>
                    <td>${customer.cusHobby}</td>
                    <td>${customer.cusCode}</td>
                    <td>${customer.cusBirthday}</td>
                </tr>
                </thead>
                <tbody id="tb">
                </tbody>
            </table>
        </div>
    </div>
</div>
<%--<tr class="success">--%>
<%--<td>--%>
<%--1--%>
<%--</td>--%>
<%--<td>--%>
<%--TB - Monthly--%>
<%--</td>--%>
<%--<td>--%>
<%--01/04/2012--%>
<%--</td>--%>
<%--<td>--%>
<%--Default--%>
<%--</td>--%>
<%--<td>--%>
<%--1--%>
<%--</td>--%>
<%--<td>--%>
<%--TB - Monthly--%>
<%--</td>--%>
<%--<td>--%>
<%--01/04/2012--%>
<%--</td>--%>