<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <base href="<%=request.getContextPath()%>/"/>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <%@include file="../GUIMEI/layUI.jsp"%>

</head>


            <div style="float: left; width: 80px;height: 80px;margin: 26px 0px 18px 25px;" id="goodsimg">
                <%--<a  href="doGoods?action=goodsLookByIg&id=${all.goods.id}" target="_parent">--%>
                        <%--<img src="GoodsImage/${all.goods.goodsImage}" style="width: 80px;height: 80px" ></a>--%>

            </div>



<script type="text/javascript" src="js/jquery-2.1.0.js"></script>
<script type="text/javascript">
    $(function () {
        Goods();
    })
    function Goods() {
        $("#goodsimg").html("");

        var goodName = "";
        var sellerName = -1;
        var smallName = -1;

        $.getJSON("/GoodsNewServlet",{"action":"select","pageCurrentNo":1,"pagesize":4,"goodName":goodName,"sellerName":sellerName,"smallName":smallName},callback);
        function callback(data) {
            // $("#pageNo").html(data.pageCurrentNo);
            // $("#totalPages").html(data.totalPages);
            for (var i = 0; i<data.list.length ; i++) {
                $("#goodsimg").append("<a href='#' target='_parent'>" +
                    "<img src='GoodsImage/"+data.list[i].goodsImage+"' style='width: 80px;height: 80px'>" +
                    "<br>"+data.list[i].goodsName+"</a>");

            }
        }

    }
</script>
</html>
