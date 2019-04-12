<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <base href="<%=request.getContextPath()%>/"/>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@include file="layUI.jsp"%>
</head>
<body>
            <table width="100%" style="text-align: center" class="layui-table">
                    <%--<tr>--%>
                    <%--<th>姓名</th>--%>
                    <%--<th>登录账号</th>--%>
                    <%--<th>性别</th>--%>
                    <%--<th>生日</th>--%>
                    <%--<th>证件号</th>--%>
                    <%--<th>Email</th>--%>
                    <%--<th>电话</th>--%>
                    <%--<th>地址</th>--%>
                </tr>
                        <tbody></tbody>
            </table>

    <jsp:include page="/Seller/Page.jsp"></jsp:include>
</body>
<script src="/js/jquery-2.1.0.js"></script>
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

        $.getJSON("/doSel",{"action":"select","pageSize":pageSize,"pageCurrentNo":pageCurrentNo},callback)
        function callback(data) {
            // $(data).each(function (i,em) {
            //     alert(em.cusName);
            // });
            // $("tbody").html("");
            $("tbody").html("");
            $("tbody").html(" <tr>\n" +
                "                    <th>姓名</th>\n" +
                "                    <th>登录账号</th>\n" +
                "                    <th>性别</th>\n" +
                "                    <th>生日</th>\n" +
                "                    <th>证件号</th>\n" +
                "                    <th>Email</th>\n" +
                "                    <th>电话</th>\n" +
                "                    <th>地址</th>\n" +
                "                    <th>操作</th>\n" +
                "                </tr>");

            for (var i = 0; i <data.list.length ; i++) {
                $("tbody").append("<tr>" +
                    "<td>"+data.list[i].sellerName+"</td>" +
                    "<td>"+data.list[i].sellerUser+"</td>" +
                    "<td>"+data.list[i].sellerSex+"</td>" +
                    "<td>"+data.list[i].sellerBirthday+"</td>" +
                    "<td>"+data.list[i].sellerIdCard+"</td>" +
                    "<td>"+data.list[i].sellerEmail+"</td>" +
                    "<td>"+data.list[i].sellerTel+"</td>" +
                    "<td>"+data.list[i].sellerAddress+"</td>"+
                    "<td>" +
                    "<a href='javascript:void(0)' onclick='updateNews("+data.list[i].sellerId+")'>编辑</a>" +
                    "<a href='javascript:void(0)' onclick='deleteNews("+data.list[i].sellerId+",this)'>删除</a>" +
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
        $.getJSON("/doSel","action=selDelById&id="+id,callback);
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