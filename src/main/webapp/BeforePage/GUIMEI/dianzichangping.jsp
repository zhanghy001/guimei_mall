<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title></title>
	<base href="<%=request.getContextPath()%>/"/>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<script type="text/javascript" src="../js/jquery-2.1.0.js"></script>
    <link href="../css/guimei.css" rel="stylesheet" type="text/css">

    </head>
<body>
<%@include file="head.jsp"%>
    <div id="dzcpbody">
  		 <table border="0px" width="95%">
	        <thead style="font-size: 16px;color:red;line-height:35px; text-align: center; ">
	        	<tr id="quanrentable_hang1">
	                <td style="width:36%;text-align:left;">图片</td>
	                <td style="width:20%;">商品名/出售者</td>
	                <td style="width:8%;">原价</td>
	                <td style="width:8%;">数量</td>
	            </tr>
        	</thead>
			 <c:forEach items="${Page.pageData}" var="all">
				 <tr>
					 <td style="width:36%;text-align:left;"> <a  href="doGoods?action=goodsLookByIg&id=${all.goods.id}" >
						 <img src="GoodsImage/${all.goods.goodsImage}" style="width: 80px;height: 80px" ></a></td>
					 <td style="width:20%;">${all.goods.goodsName}<br>出售者：${all.seller.sellerName}</td>
					 <td style="width:8%;">一口价<br>${all.goods.goodsMoney}</td>
					 <td style="width:8%;">${all.goods.goodsNumber}</td>
				 </tr>
			 </c:forEach>
			 <tr>
				 <td colspan="4">
					 <%@include file="Page.jsp"%>
				 </td>
			 </tr>
        	<tbody id="shoppingcar"></tbody>
        </table>

    </div>
</body>
</html>