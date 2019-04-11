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

    <table width="100%" style="text-align: center" class="layui-table">

    </table>
    <span id="pageNo"></span>/<span id="totalPages"></span>页&nbsp;&nbsp;&nbsp;&nbsp;
    <a class="layui-btn layui-btn-sm" href="javascript:void(0)" id="begin">首页</a>
    <a class="layui-btn layui-btn-sm" href="javascript:void(0)" id="prev">上一页</a>
    <a class="layui-btn layui-btn-sm" href="javascript:void(0)" id="next">下一页</a>
    <a class="layui-btn layui-btn-sm" href="javascript:void(0)" id="end">末页</a>
<script type="text/javascript" src="js/jquery-2.1.0.js"></script>
<script type="text/javascript">
    var pageCurrenNo = 1; // 当前页面
    var pageSize = 5;  //  显示页面
        $(function () {
            // 首页
            $("#begin").click(function () {
                pageCurrenNo = 1;
                Announce();
            });
            //  上一页
            $("#prev").click(function () {
                pageCurrenNo =pageCurrenNo - 1;
                Announce();
            });
            //  下一页
            $("#next").click(function () {
                pageCurrenNo =pageCurrenNo + 1;
                Announce();
            });
            //  末页
            $("#end").click(function () {
                pageCurrenNo = $("#totalPages").html();
                Announce();
            });
            //  转跳
            $("#page-btn").click(function () {
                pageCurrenNo = $("#inputPage").val();
                Announce();
            });
            Announce();
        })
        function Announce() {
            $("table").html("");
            $("table").html(" <tr>\n" +
                "            <th>ID</th>\n" +
                "            <th>标题</th>\n" +
                "            <th>内容</th>\n" +
                "            <th>日期</th>\n" +
                "            <th colspan=\"2\">操作</th>\n" +
                "        </tr>");
            $.getJSON("/NoticeServlet",{"action":"select","pageCurrenNo":pageCurrenNo,"pageSize":pageSize},callback);
            function callback(data) {
                $("#pageNo").html(data.pageCurrentNo);
                $("#totalPages").html(data.totalPages);
                // alert(data.pageCurrentNo);
                // alert(data.totalPages);
                for (var i = 0; i<data.list.length ; i++) {
                    $("table").append("<tr>" +
                        "<td>"+data.list[i].id+"</td>" +
                        "<td>"+data.list[i].aTitle+"</td>" +
                        "<td>"+data.list[i].aText+"</td>" +
                        "<td>"+data.list[i].aDate+"</td>"+
                        " <th ><a href=\"javascript:void(0)\" onclick='update("+data.list[i].id+")'>修改</a>" +
                        " <a href=\"javascript:void(0)\" onclick='dele("+data.list[i].id+",this)'>删除</a>" +
                        "</th>"+
                        "</tr>");
                }
            }
        }
    function dele(id,bit) {
        $.getJSON("/NoticeServlet","action=delect&id="+id,callback)
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
        location.href = "/page/announcement/anUpdate.jsp?id="+id;
    }
</script>
</body>
</html>
