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
    <script>
        $(function () {
            $.ajax({
                url:"doOrder",
                type:"post;",
                dataType:"json",
                success:function (data) {
                    for (var i = 0; i <data.length; i++) {
                      $("#tb")
                          .append("<tr>"+
                              "<td>data[i].orderse.orderseDate<td/>"+
                              "<td>data[i].orderse.orderseAddress<td/>"+
                              "<td>data[i].orderse.orderseMoney<td/>"+
                              "<td>data[i].orderse.orderseStatus<td/>"+
                              "<td>data[i].goods.goodsName<td/>"+
                              "<td>data[i].goods.goodsMoney<td/>"+
                              "<tr/>")
                    }
                }
            })
        })
    </script>

</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <h3>
                我的订单信息
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
                    <th>订单日期</th>
                    <th>订单地址</th>
                    <th>订单金额</th>
                    <th>订单状态</th>
                    <th>商品名称</th>
                    <th>商品单价</th>
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