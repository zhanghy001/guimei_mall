<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>购物车</title>
	<base href="<%=request.getContextPath()%>/"/>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <link href="BeforePage/css/guimei.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="../js/jquery-2.1.0.js"></script>
	<%@include file="layUI.jsp"%>
</head>
<body>
<%@include file="head.jsp"%>
    <div id="quanren"  style="margin: auto;">
        <p id="wodeguc_2jibiaoti">订单查看</p>
		<div style="color: red ;position: relative;top: 30px;">${ord}</div>
        <table border="0px" width="95%"style="margin:30px;">
	        <thead style="font-size: 16px;color:red;line-height:65px; text-align: center; ">
	        	<tr id="quanrentable_hang1">
	                <td >订单ID</td>
	                <td >商品</td>
	                <td >顾客名称</td>
	                <td >订单日期</td>
	                <td >收货地址</td>
	                <td >订单金额</td>
	                <td >发货状态</td>
	                <td >操作</td>
	            </tr>
        	</thead>

			<tr>
				<td colspan="7">
					<jsp:include page="Page.jsp"/>
				</td>
			</tr>
        </table>

    </div>
<div style="margin: 100px"><jsp:include page="foot.jsp"/></div>
<script type="text/javascript" src="js/jquery-2.1.0.js"></script>
<script type="text/javascript">
	$(function () {
		// 首页
		$("#begin").click(function () {
			pageCurrentNo = 1;
			Goods();
		});
		//  上一页
		$("#prev").click(function () {
			pageCurrentNo =pageCurrentNo - 1;
			Goods();
		});
		//  下一页
		$("#next").click(function () {
			pageCurrentNo =pageCurrentNo + 1;
			Goods();
		});
		//  末页
		$("#end").click(function () {
			pageCurrentNo = $("#totalPages").html();
			Goods();
		});
		//  转跳
		$("#page-btn").click(function () {
			pageCurrentNo = $("#inputPage").val();
			Goods();
		});
		Goods();
		getSellerName();
		getsmall();

	});

	function selectList() {
		pageCurrentNo=1;
		Goods();
	}
	function jump() {
		pageCurrentNo= $("#jump1").val();
		Goods();
	}


	//判断页码 显示 隐藏
	function showHide() {
		if (pageCurrentNo==$("#totalPages").html() ||$("#totalPages").html()==0) {
			$("#next").hide();
		}else {
			$("#next").show();
		}
		if (pageCurrentNo==1){
			$("#prev").hide();
		}else {
			$("#prev").show();
		}
	}
	function Goods() {
		$("#quanrentable_hang1").html("");
		$("#quanrentable_hang1").html("<td >订单ID</td>\n" +
				"\t                <td >商品</td>\n" +
				"\t                <td >顾客名称</td>\n" +
				"\t                <td >订单日期</td>\n" +
				"\t                <td >收货地址</td>\n" +
				"\t                <td >订单金额</td>\n" +
				"\t                <td >发货状态</td>\n" +
				"\t                <td >操作</td>");

		$.getJSON("/GoodsNewServlet",{"action":"select"},callback);
		function callback(data) {
			$("#pageNo").html(data.pageCurrentNo);
			$("#totalPages").html(data.totalPages);
			for (var i = 0; i<data.list.length ; i++) {
				var os = data.list[i].orderse.orderseStatus;
				var orderseStatus = undefined ;
				if (os == 0){
					orderseStatus = "买家已下单";
				}else if(os == 1){
					orderseStatus = "卖家已发货";
				}else {
					orderseStatus = "已收货";
				}
				$("#quanrentable_hang1").append("<td >data.list[i].orderse.id</td>\n" +
						"\t                <td ><img src='GoodsImage/"+data.list[i].goods.goodsImage+"'></td>\n" +
						"\t                <td >data.list[i].customer.goodsName</td>\n" +
						"\t                <td >data.list[i].orderse.orderseDate</td>\n" +
						"\t                <td >data.list[i].orderse.orderseAddress</td>\n" +
						"\t                <td >data.list[i].orderse.orderseMoney</td>\n" +
						"\t                <td >"+orderseStatus+"</td>\n" +
						"\t                <td class=\"layui-btn\">确认收货</td>");

			}
			showHide();
			$("#jump1").empty();
			for (var i = 1; i <= data.totalPages; i++) {
				$("#jump1").append("<option  value=" + i + ">第" + i + "页</option>");
			}
			$("#jump1").val(data.pageCurrentNo);

		}
	}






</script>
</body>
</html>