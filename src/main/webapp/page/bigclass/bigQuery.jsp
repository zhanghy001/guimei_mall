<%--
  Created by IntelliJ IDEA.
  User: 52203
  Date: 2018/12/28
  Time: 8:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <base href="<%=request.getContextPath()%>/"/>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@include file="../layUI.jsp"%>
</head>
<body>
<form action="page/bigclass/bigAdd.jsp" method="post">
    <input type="submit" value="添加大分类" class="layui-btn">
</form>
            <table width="100%" style="text-align: center" class="layui-table">
                <tr>
                    <th>大分类ID</th>
                    <th>大分类名称</th>
                    <th>大分类描述</th>
                    <th colspan="2">操作</th>
                </tr>
                <tbody id="bigClassInfo">


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
        $("#bigClassInfo").empty();
        $.getJSON("doBig",{"action":"bigQuery","pageCurrentNo":pageCurrentNo,"pagesize":pagesize},callback)
        function callback(data) {
            for (var i = 0; i <data.list.length ; i++) {
                $("#bigClassInfo").append("<tr>"+
                    "<td>" + data.list[i].id + "</td>"
                    +"<td>" + data.list[i].bigName + "</td>"
                    +"<td>" + data.list[i].bigText + "</td>"
                    +"<td>" +
                    // "<a href='/jsp/newsServlet?action=update&id="+ data.list[i].id+"'>编辑</a>" +
                    "<a target='iframe_context' href='doBig?action=getBig&id="+data.list[i].id+"' class=\"layui-btn\">编辑</a>" +
                    "</td>"+
                    "<td>" +
                    // "<a href='javascript:void(0)' onclick='delNews("+ data.list[i].id+")'>删除</a>" +
                    "<a href='javascript:void(0)' onclick='delBig("+ data.list[i].id+",this)' class=\"layui-btn\">删除</a>" +
                    "</td>"
                    +"</tr>");
            }

            $("#pageNo").empty();
            $("#pageNo").append(data.pageCurrentNo);
            $("#totalPages").empty();
            $("#totalPages").append(data.totalPages);


            $("#jump1").empty();
            for (var i = 1; i <= data.totalPages; i++) {
                $("#jump1").append("<option  value=" + i + ">第" + i + "页</option>");
            }
            $("#jump1").val(data.pageCurrentNo);

            showHide();

        }
    }

    function delBig(id,a) {

        if (confirm("确认删除吗？")==true){
            $.getJSON("doBig",{"action":"delBig","id":id},callback)
            function callback(data){
                if (data==true){
                    alert("删除成功");
                    $(a).parent().parent().remove();
                } else {
                    alert("删除失败");
                }
            }
        }


    }

</script>
</html>
