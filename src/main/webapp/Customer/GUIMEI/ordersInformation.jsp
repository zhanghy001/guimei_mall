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
    <title>订单信息</title>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.staticfile.org/jquery/2.0.0/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="../../js/jquery-2.1.0.js"></script>
    <script>
        $(function () {
        });
        function callback(list) {
            $.each(list,function (i,data){
                if(i<list.length-1){
                $("#tb")
                    .html("<tr>"+
                        "<td>"+data.orderse.orderseDate+"<td/>"+
                        "<td>"+data.orderse.orderseAddress+"<td/>"+
                        "<td>"+data.orderse.orderseMoney+"<td/>"+
                        "<td>"+data.orderse.orderseStatus+"<td/>"+
                        "<td>"+data.goods.goodsName+"<td/>"+
                        "<td>"+data.goods.goodsMoney+"<td/>"+
                        "<tr/>");
                }else {
                    $("#totalPages").html(data.totalPages);
                    $("#pageCurrentNo").html(data.pageCurrentNo);
                }
            });
        }

        function first(){
            $.getJSON("/doOrder","action=first",callback);
        }
        function forward() {
            $.getJSON("/doOrder","action=forward",callback);
        }
        function next(){
            $.getJSON("/doOrder","action=next",callback);
        }
        function last(){
            $.getJSON("/doOrder","action=last",callback);
        }
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
            <input type="button" value="查询" id="query" onclick="first()"/>
            <br/>
            <input type="button" value="首页" id="first" onclick="first()"/>
            <input type="button" value="上一页" id="forward" onclick="forward()"/>
            <input type="button" value="下一页" id="next" onclick="next()"/>
            <input type="button" value="尾页" id="last" onclick="last()"/>
            <hr/>
            总页数为:<p id="totalPages"></p>
            <br/>
            当前页为:<p id="pageCurrentNo"></p>
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