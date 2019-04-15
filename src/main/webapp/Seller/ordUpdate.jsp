<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Title</title>
    <base href="<%=request.getContextPath()%>/"/>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <script src="/static/js/jquery-1.8.2.min.js"></script>
    <%@include file="layUI.jsp"%>

</head>

<body>
    <form action="doOrd?action=ordUpdate" method="post">
        <div id="d1"></div>
        订单ID<input type="text" value="" id="id" readonly>
        商品名称<input type="text" value="" id="goodsName" readonly>
        顾客名称<input type="text" value="" id="cusName" readonly>
        订单日期<input type="date" value="" id="orderseDate"readonly><br>
        收货地址<input type="text" value="" id="orderseAddress">
        订单金额<input type="text" value="" id="orderseMoney"><br>
        发货状态<select name="orderseStatus" id="orderseStatus">
        <option value="0">卖家未发货</option>
        <option value="1">卖家已发货</option>
        <option value="2">订单已签收</option>
    </select>
        <input type="button" value="修改完成" class="layui-btn" id="btn" >
    </form>
</body>
<script src="../js/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
    $(function () {
        var id='${param.id}'
        $.getJSON("/doOrd","action=findById&id="+id,callback);
        function callback(data) {
            $("#id").val(data.id);
            $("#goodsName").val(data.goods.goodsName);
            $("#cusName").val(data.customer.cusName);
            $("#orderseDate").val(data.orderseDate);
            $("#orderseAddress").val(data.orderseAddress);
            $("#orderseMoney").val(data.orderseMoney);
            var status=data.orderseStatus;
            switch (status) {
                case 0:
                    $("#orderseStatus option[value='0']").attr("selected",true);
                    break;
                case 1:
                    $("#orderseStatus option[value='1']").attr("selected",true);
                    break;
                case 2:
                    $("#orderseStatus option[value='2']").attr("selected",true);
                    break;
            }
        }
        $("#btn").click(function () {
            var id=$("#id").val();
            var goodsName= $("#goodsName").val();
            var cusName=$("#cusName").val();
            var orderseDate=$("#orderseDate").val();
            var orderseAddress=$("#orderseAddress").val();
            var orderseMoney=$("#orderseMoney").val();
            var status=$("#orderseStatus").val();
            $.getJSON("/doOrd",{"action":"ordUpdate","id":id,"status":status},callback)
            function callback(data) {
                if(data.flag=="true"){
                    alert("修改成功");
                    window.location.href=document.referrer;
                }else {
                    alert("修改失败")
                }
            }
        })
    })
</script>
</html>
