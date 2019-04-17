<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>购物车</title>
	<base href="<%=request.getContextPath()%>/"/>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <link href="css/guimei.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="../js/jquery-2.1.0.js"></script>
	<%@include file="layUI.jsp"%>
    <script type="text/javascript">



			/* 通过ID删除购物车项目 */
			function del(id,a) {
				if (confirm("确认删除吗？")==true){
					$.getJSON("doShop",{"action":"delShop","id":id},callback)
					function callback(data){
						if (data==true){
							alert("删除成功");
							$(a).parent().remove();
						} else {
							alert("删除失败");
						}
					}
				}
			}

  		    /* 通过ID修改购物车商品数目 */
      	function shop(s_id,s_number,i){
      	        document.getElementsByClassName("number")[i-1].value=s_number>0?s_number:1;
			if(s_number>0){
				$.getJSON("doShop",{"action":"numberAdd","shopId":s_id,"number":s_number},callback)
				function callback(data){
					if (data==true){
						$("#sheng_money").append();
					} else {
						alert("删除失败");
					}
				}
              //  location="../../doShop?action=shopUpdate&id="+s_id+"&scNumber="+s_number;
			}else {
              //  location="../../doShop?action=shopUpdate&id="+s_id+"&scNumber=1";
			}
		}



    </script>
    
</head>
<body>
<%@include file="head.jsp"%>
    <div id="wodeguc" >
		<div style="color: red">${ord}</div>
        <img src="images/img/images/mycart.gif">
        <label class="wudeguclabel">全场满100免运费</label>
        <label class="wudeguclabel">简易计算器</label>
    </div>

    <div id="quanren"  style="margin: auto;">
        <p id="wodeguc_2jibiaoti">确认商品价格与交易条件</p>
        <table border="0px" width="95%"style="margin:30px;">
	        <thead style="font-size: 16px;color:red;line-height:65px; text-align: center; ">
	        	<tr id="quanrentable_hang1">
	                <td style="width:36%;text-align:left;">商品名</td>
	                <td style="width:20%;">图片</td>
	                <td style="width:8%;">原价</td>
	                <td style="width:8%;">优惠价</td>
	                <td style="width:8%;">打折</td>
	                <td style="width:8%;">数量</td>
	                <td style="width:8%;">操作</td>
	            </tr>
        	</thead>
				<c:forEach items="${all}" var="all" varStatus="i">
			<tr >

				<td style="width:36%;text-align:left;">${all.goods.goodsName}</td>
				<td style="width:20%;"><a  href="doGoods?action=goodsLookByIg&id=${all.goods.id}" >
					<img src="GoodsImage/${all.goods.goodsImage}" style="width: 80px;height: 80px" ></a></td>
				<td style="width:8%;" name="yuanjia">${all.goods.goodsMoney}</td>
				<td style="width:8%;" name="youhuijia">${all.cheapPrice}</td>
				<td style="width:8%;" name="zhekou">${all.discount.discRate}</td>
				<td style="width:8%;" ><input class="number" type="number" value="${all.shoppingcar.scNumber}" onchange="shop(${all.shoppingcar.id},this.value,${i.count})"></td>
				<td style="width:8%;"  onclick="del(${all.shoppingcar.id},this)"><a class="layui-btn layui-btn-sm">删除</a></td>
			</tr>
				</c:forEach>
			<tr>
				<%--<td colspan="7">--%>
					<%--<jsp:include page="Page.jsp"/>--%>
				<%--</td>--%>
			</tr>
			<tr>

				<td colspan="5">
					<p >优惠金额￥:${AllPrice.allCheapPrice}<b id="sheng_money"></b></p>
				</td>
				<td>
					<p >应付金额￥:${AllPrice.allPrice}<b id="count_money"></b></p>
				</td>
				<td style="text-align: right;">
					<p><a href="BeforePage/GUIMEI/homepage.jsp">返回继续购买商品</a></p>
				</td>
			</tr>
        </table>

    </div>
	<div id="dizhi"  style="margin: auto;">
          <p id="dizhi_2jibiaoti" >补充您的邮件地址和联系人信息</p>
          <br/>
		<form action="/doShop?action=Orders" method="post">
            姓名：<input type="text" name="cusName" value="${customer.cusName}"><br>
            地址：<input type="text" name="orderseAddress" value="湖南长沙岳麓区溁湾填"><br>
            电话：<input type="text" size="4" name="quhao" value="0731">-<input type="text" size="8" name="phone" value="88858332">-<input type="text" size="4" name="fenji" value="8888">
            （区号-电话号码-分机）<br>
            手机：<input type="text" size="11" name="telpone" value="15874073679"><br>
		<input type="image" src="images/img/zhuce/submit.gif">
		</form>
    </div>
<div style="margin: 100px 0px 0px 0px"><jsp:include page="foot.jsp"/></div>
</body>
</html>