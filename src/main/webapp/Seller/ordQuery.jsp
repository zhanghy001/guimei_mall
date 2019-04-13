<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <base href="<%=request.getContextPath()%>/"/>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <script src="static/js/jquery-2.1.1.min.js"></script>
    <%@include file="../page/layUI.jsp"%>
</head>
<body>
        <table width="100%" style="text-align: center" class="layui-table">
            <div style="color: red ;position: relative;top: 30px;">${ord}</div>
            <tr>
                <<%--th>订单ID</th>
                <th>商品名称</th>
                <th>顾客名称</th>
                <th>订单日期</th>
                <th>收货地址</th>
                <th>订单金额</th>
                <th>发货状态</th>
                <th colspan="2">操作</th>--%>
            </tr>
             <tbody>

             </tbody>
            <tr>
                <td colspan="7">
                    <%@include file="../page/Page.jsp"%>
                </td>
            </tr>
        </table>

</body>
<script type="text/javascript">
    var pageCurrentNo=parseInt(1);
    var pageSize=5;
    var totalPages;
    var id=$("id").val();
    $(function () {
        select(1);
        // showhide(parseInt($("#pageNo").html()),parseInt($("#totalPages").html()));
        $("#begin").click(function () {
            if (pageCurrentNo!=1){
                pageCurrentNo=1;
                select(pageCurrentNo);
            } else{
                alert("已经是首页了！");
            }
        })
        $("#prev").click(function () {
            if (pageCurrentNo!=1){
                pageCurrentNo=pageCurrentNo-1;
                select(pageCurrentNo);
            } else{
                alert("已经是首页了！");
            }
        })
        $("#next").click(function () {
            if (pageCurrentNo<totalPages){
                pageCurrentNo=pageCurrentNo+1;
                select(pageCurrentNo);
            } else{
                alert("已经是最后一页了！");
            }

        })
        $("#end").click(function () {
            if (pageCurrentNo<totalPages){
                pageCurrentNo=$("#totalPages").html();
                select(pageCurrentNo);
            } else{
                alert("已经是最后一页了！");
            }
        })
        $("#page-btn").click(function () {
            pageCurrentNo=$("#inputPage").val();
            if(pageCurrentNo>parseInt($("#totalPages").html())){
                alert("填写有误!");
                $("#inputPage").val("");
                return;
            }
            select(pageCurrentNo);
        })
    })


    function select(pageNo) {

        pageCurrentNo=pageNo;

        $.getJSON("/DoOrder",{"action":"select","pageSize":pageSize,"pageCurrentNo":pageCurrentNo},callback)
        function callback(data) {
            // $(data).each(function (i,em) {
            //     alert(em.cusName);
            // });
            // $("tbody").html("");
            $("tbody").html("");
            $("tbody").html("th>订单ID</th>\n" +
                "                <th>商品名称</th>\n" +
                "                <th>顾客名称</th>\n" +
                "                <th>订单日期</th>\n" +
                "                <th>收货地址</th>\n" +
                "                <th>订单金额</th>\n" +
                "                <th>发货状态</th>\n" +
                "                <th colspan=\"2\">操作</th>");

            for (var i = 0; i <data.list.length ; i++) {
                $("tbody").append("<tr>" +
                    "<td>"+data.list[i].id+"</td>" +
                    "<td>"+data.list[i].orderseGoodsId+"</td>" +
                    "<td>"+data.list[i].orderseCusId+"</td>" +
                    "<td>"+data.list[i].orderseDate+"</td>" +
                    "<td>"+data.list[i].orderseAddress+"</td>" +
                    "<td>"+data.list[i].orderseMoney+"</td>" +
                    "<td>"+data.list[i].orderseStatus+"</td>" +
                    "<td>" +
                    "<a href='javascript:void(0)' onclick='updateNews("+data.list[i].id+")'>编辑</a>" +
                    "<a href='javascript:void(0)' onclick='deleteNews("+data.list[i].id+",this)'>删除</a>" +
                    "</td>" +
                    "</tr>");
            }
            $("#total").html(data.totalCount);
            $("#pageNo").html(data.pageCurrentNo);
            $("#totalPages").html(data.totalPages);
            totalPages=parseInt($("#totalPages").html());
        }
    }
    //显示隐藏
    function showhide(currentPage,totalPages) {
        if(currentPage==1){
            $("#prev").hide();
            $("#next").show();
        }
        if(currentPage>1&&currentPage<totalPages){
            $("#prev").show();
            $("#next").show();
        }
        if(currentPage==totalPages){
            $("#prev").show();
            $("#next").hide();
        }
        if(totalPages==1){
            $("#prev").hide();
            $("#next").hide();
        }
    }
    function deleteNews(id,btn) {
        $.getJSON("/DoOrder","action=selDelById&id="+id,callback);
        function callback(data) {
            if(data.flag=="true"){
                $(btn).parent().parent().remove();
                // location.reload();
                alert("删除成功!");
            }else{
                alert("删除失败!")
            }
        }
    }
    function updateNews(id) {
        location.href="/Seller/sellerUpdate.jsp?id="+id;
    }

</script>
</html>
