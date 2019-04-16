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
			<tbody id="goodsList">
			<%--<tr>--%>
				<%--<td style="width:36%;text-align:left;"> <a  href="doGoods?action=goodsLookByIg&id=1" >--%>
					<%--<img src="GoodsImage/A1.jpg" style="width: 80px;height: 80px" ></a></td>--%>
				<%--<td style="width:20%;">natun<br>出售者：natun</td>--%>
				<%--<td style="width:8%;">一口价<br>456</td>--%>
				<%--<td style="width:8%;">123</td>--%>
			<%--</tr>--%>

			</tbody>

			 <%--action=goodsBySmall&pageNumber=1&--%>
			 <tr>
				 <td colspan="4">
					 <%@include file="../../page/Page.jsp"%>
				 </td>
			 </tr>
        	<tbody id="shoppingcar"></tbody>
        </table>

    </div>
</body>

<script type="text/javascript">

	var smallId=${param.smallId};

	$(function () {
		// 首页
		$("#begin").click(function () {
			pageCurrentNo = 1;
			getSmallListById();
		});
		//  上一页
		$("#prev").click(function () {
			pageCurrentNo =pageCurrentNo - 1;
			getSmallListById();
		});
		//  下一页
		$("#next").click(function () {
			pageCurrentNo =pageCurrentNo + 1;
			getSmallListById();
		});
		//  末页
		$("#end").click(function () {
			pageCurrentNo = $("#totalPages").html();
			getSmallListById();
		});
		//  转跳
		$("#page-btn").click(function () {
			pageCurrentNo = $("#inputPage").val();
			getSmallListById();
		});

		getSmallListById();

	})

	//跳页
	function jump() {
		pageCurrentNo= $("#jump1").val();
		getSmallListById();
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





	function getSmallListById() {
		$("#goodsList").empty();
		$.getJSON("/GoodsNewServlet",{"action":"select","pageCurrentNo":pageCurrentNo,"pagesize":pagesize,"goodName":"","sellerName":-1,"smallName":smallId},callback);
		function callback(data) {
			$("#pageNo").html(data.pageCurrentNo);
			$("#totalPages").html(data.totalPages);
			for (var i = 0; i<data.list.length ; i++) {
				$("#goodsList").append("<tr>\n" +
						"<td style=\"width:36%;text-align:left;\"> <a  href='GoodsNewServlet?action=goodsLookByIg&id="+data.list[i].id+" ' >\n" +
						"<img src='GoodsImage/"+data.list[i].goodsImage+"' style=\"width: 80px;height: 80px\" ></a></td>\n" +
						"<td style=\"width:20%;\">"+data.list[i].goodsName+"<br>出售者："+data.list[i].goodsSeName+"</td>\n" +
						"<td style=\"width:8%;\">一口价<br>"+data.list[i].goodsMoney+"</td>\n" +
						"<td style=\"width:8%;\">"+data.list[i].goodsNumber+"</td>\n" +
						"</tr>")


			}
			showHide();
			$("#jump1").empty();
			for (var i = 1; i <= data.totalPages; i++) {
				$("#jump1").append("<option  value=" + i + ">第" + i + "页</option>");
			}
			$("#jump1").val(data.pageCurrentNo);

		}	}



</script>

</html>