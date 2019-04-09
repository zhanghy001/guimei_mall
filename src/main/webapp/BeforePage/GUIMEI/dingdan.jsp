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
</body>
</html>