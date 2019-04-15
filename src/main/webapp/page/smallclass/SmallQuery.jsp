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
<form action="page/smallclass/smallAdd.jsp" method="post">
    <input type="submit" value="添加小分类" class="layui-btn">
</form>

    <label>小分类名</label>
    <input type="text" name="smallName" id="smallName" value="">
    <label>大分类名</label>
    <select name="bigName" id="bigName">

    </select>
    <input class="layui-btn" type="button" onclick="getList()" value="查询">


        <table width="100%" style="text-align: center" class="layui-table">
            <tr>
                <th>小分类ID</th>
                <th>小分类名称</th>
                <th>大分类名称</th>
                <th>小分类描述</th>
                <th colspan="2">操作</th>
            </tr>

            <tbody id="smallList">


            </tbody>


            <tr>
                <td colspan="5">
                    <%@include file="../Page.jsp"%>
                </td>
            </tr>
        </table>

</body>
<script type="text/javascript" src="../../js/jquery-2.1.0.js"></script>
<script type="text/javascript">
    $("#bigName").load("doSmall?action=getBigName&id=1");
    $(function () {
        getList();
        //下一页
        $("#next").click(function () {
            pageCurrentNo++;
            getList();
        });
        //上一页
        $("#prev").click(function () {
            pageCurrentNo--;
            getList();
        });
        //首页
        $("#begin").click(function () {
            pageCurrentNo = 1;
            getList();
        });

        //末页
        $("#end").click(function () {
            pageCurrentNo= $("#totalPages").html();
            getList();

        })

    })
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


    function getList() {
       // $("#smallName").val("dd")
        var smallName= $("#smallName").val();
        var smallBigId=$("#bigName").val();
        if (smallBigId==null||smallBigId==""){
            smallBigId="-1";
        }
        $.getJSON("doSmall",{"action":"smallQuery","smallName":smallName,"smallBigId":smallBigId,"pageCurrentNo":pageCurrentNo,"pagesize":pagesize},callback)
        function callback(data) {
            $("#smallList").empty();
        //    $("#bigName").empty();
            for (var i = 0; i < data.list.length; i++) {
               $("#smallList").append(" <tr>\n" +
                   "<td>"+data.list[i].id+"</td>\n" +
                   "<td>"+data.list[i].smallName+"</td>\n" +
                   "<td>"+data.list[i].bigName+"</td>\n" +
                   "<td>"+data.list[i].smallText+"</td>\n" +
                   "<td><a class=\"layui-btn\" href=\"doSmall?action=smallUpdateById&id=\">修改</a></td>\n" +
                   "<td><a class=\"layui-btn\" href=\"doSmall?action=smallDel&id=\">删除</a></td>\n" +
                   "</tr>");
               //  alert("ddd")


            }
            $("#pageNo").empty();
            $("#pageNo").append(data.pageCurrentNo);
            $("#totalPages").empty();
            $("#totalPages").append(data.totalPages);
            showHide();
        }


    }

</script>
</html>
