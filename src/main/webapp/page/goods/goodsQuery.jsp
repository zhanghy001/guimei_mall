<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <base href="<%=request.getContextPath()%>/"/>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <script src="static/js/jquery-2.1.1.min.js"></script>
    <%@include file="../layUI.jsp"%>


</head>
<body>
<form action="" method="post" >
    <label>商品名称</label>
    <input type="text" name="goodsName" id="goodsName">
    <label>商家名称</label>
    <select name="sellerName" id="sellerName">
        <option value="-1">全部</option>
    </select>
    <label>小分类名称</label>
    <select name="smallName" id="smallName">
        <option value="-1">全部</option>
    </select>
    <input class="layui-btn" type="button" value="查询" onclick="Goods()">
</form>

        <table width="100%" style="text-align: center" class="layui-table">


        </table>

<tr>
    <td colspan="12">
        <%@include file="../Page.jsp"%>
    </td>
</tr>

<script type="text/javascript" src="js/jquery-2.1.0.js"></script>
<script type="text/javascript">
    var pageCurrenNo = 1; // 当前页面
    var pageSize = 5;  //  显示页面
    $(function () {
        // 首页
        $("#begin").click(function () {
            pageCurrenNo = 1;
            Goods();
        });
        //  上一页
        $("#prev").click(function () {
            pageCurrenNo =pageCurrenNo - 1;
            Goods();
        });
        //  下一页
        $("#next").click(function () {
            pageCurrenNo =pageCurrenNo + 1;
            Goods();
        });
        //  末页
        $("#end").click(function () {
            pageCurrenNo = $("#totalPages").html();
            Goods();
        });
        //  转跳
        $("#page-btn").click(function () {
            pageCurrenNo = $("#inputPage").val();
            Goods();
        });
        Goods();
        getSellerName();
        getsmall();

    });

    /**
     * 商品名下拉框
     */
    function getSellerName() {
        $.getJSON("/GoodsNewServlet",{"action":"selectSell"},callback);
        function callback(data) {
            $(data).each(function () {
                $("#sellerName").append("<option value=" + this.id + ">" + this.goodsSeName + "</option>");
            })
        }
    }

    /**
     * 小分类下拉框
     */
    function getsmall() {
        $.getJSON("/GoodsNewServlet",{"action":"selectsmall"},callback);
        function callback(data) {
            $(data).each(function () {
                $("#smallName").append("<option value=" + this.id + ">" + this.goodsSmallName + "</option>");
            })
        }
    }
    function Goods() {
        $("table").html("");
        $("table").html("<tr>\n" +
            "                <th>商品id</th>\n" +
            "                <th>商品名称</th>\n" +
            "                <th>小分类名称</th>\n" +
            "                <th>商品的价格</th>\n" +
            "                <th>商品的数量</th>\n" +
            "                <th>商品的图像</th>\n" +
            "                <th>商品的运费</th>\n" +
            "                <th>商品的类型</th>\n" +
            "                <th>商家名称</th>\n" +
            "                <th>商品的折扣</th>\n" +
            "                <th colspan=\"2\">操作</th>\n" +
            "            </tr>");

        var goodName = $("#goodsName").val();
        var sellerName = $("#sellerName").val();
        var smallName = $("#smallName").val();

        $.getJSON("/GoodsNewServlet",{"action":"select","pageCurrenNo":pageCurrenNo,"pageSize":pageSize,"goodName":goodName,"sellerName":sellerName,"smallName":smallName},callback);
        function callback(data) {
            $("#pageNo").html(data.pageCurrentNo);
            $("#totalPages").html(data.totalPages);
            for (var i = 0; i<data.list.length ; i++) {
                $("table").append("<tr>" +
                    "<td>"+data.list[i].id+"</td>" +
                    "<td>"+data.list[i].goodsName+"</td>" +
                    "<td>"+data.list[i].goodsSmallName+"</td>" +
                    "<td>"+data.list[i].goodsMoney+"</td>" +
                    "<td>"+data.list[i].goodsNumber+"</td>" +
                        "<td><img src='GoodsImage/"+data.list[i].goodsImage+"'> </td>"+
                    "<td>"+data.list[i].goodsCarriage+"</td>"+
                    "<td>${data.list[i].goodsType==0?'新品':'二手'}</td>" +
                    "<td>"+data.list[i].goodsSeName+"</td>" +
                    "<td>"+data.list[i].goodsDiscRate+"</td>" +
                    " <th ><a class=\"layui-btn\" href=\"javascript:void(0)\" onclick='update("+data.list[i].id+")'>修改</a>" +
                    " <a class=\"layui-btn\" href=\"javascript:void(0)\" onclick='dele("+data.list[i].id+",this)'>删除</a>" +
                    "</th>"+
                    "</tr>");
            }
        }
    }
    function dele(id,bit) {
        $.getJSON("/GoodsNewServlet","action=delect&id="+id,callback)
        function callback(data) {
            if (data.flag == "true"){
                $(bit).parent().parent().remove();
                alert("删除成功");
            }else {
                alert("删除失败");
            }
        }
    }
    function update(id) {
        location.href = "page/goods/goodsUpdate.jsp?id="+id;
    }
</script>
</body>
</html>
