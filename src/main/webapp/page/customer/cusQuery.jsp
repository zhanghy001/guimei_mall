<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <base href="<%=request.getContextPath()%>/"/>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@include file="../layUI.jsp"%>
</head>
<body>

    <form action="" method="post" >
        <label>ID</label>
        <input type="text" name="id" id="id" value="">
        <label>姓名</label>
        <input type="text" name="cusName" id="cusName" value="">
        <label>姓别</label>
        <input type="text" name="cusSex" id="cusSex"  value="">
        <input class="layui-btn" type="button" value="查询" onclick="Announce()">
    </form>


            <table width="100%" style="text-align: center" class="layui-table">



            </table>
    <tr>
        <td colspan="10">
            <%@include file="../Page.jsp"%>
        </td>
    </tr>
    <script type="text/javascript" src="js/jquery-2.1.0.js"></script>
    <script type="text/javascript">
        var pageCurrentNo = 1; // 当前页面
        var pagesize = 5;  //  显示页面
        $(function () {
            // 首页
            $("#begin").click(function () {
                pageCurrentNo = 1;
                Announce();
            });
            //  上一页
            $("#prev").click(function () {
                pageCurrentNo =pageCurrentNo - 1;
                Announce();
            });
            //  下一页
            $("#next").click(function () {
                pageCurrentNo =pageCurrentNo + 1;
                Announce();
            });
            //  末页
            $("#end").click(function () {
                pageCurrentNo = $("#totalPages").html();
                Announce();
            });
            //  转跳
            $("#page-btn").click(function () {
                pageCurrentNo = $("#inputPage").val();
                Announce();
            });
            Announce();
        })
        function Announce() {
            $("table").html("");
            $("table").html(" <tr>\n" +
                "                    <th>ID</th>\n" +
                "                    <th>姓名</th>\n" +
                "                    <th>登录账号</th>\n" +
                "                    <th>Email</th>\n" +
                "                    <th>性别</th>\n" +
                "                    <th>头像</th>\n" +
                "                    <th>爱好</th>\n" +
                "                    <th>证件号</th>\n" +
                "                    <th>生日</th>\n" +
                "                    <th colspan=\"2\">操作</th>\n" +
                "                </tr>");

            var id = $("#id").val();
            var cusName = $("#cusName").val();
            var cusSex = $("#cusSex").val();
            $.getJSON("/CustomerNewServlet",{"action":"select","id":id,"cusName":cusName,"cusSex":cusSex,"pageCurrentNo":pageCurrentNo,"pagesize":pagesize},callback);
            function callback(data) {
                $("#pageNo").html(data.pageCurrentNo);
                $("#totalPages").html(data.totalPages);
                // alert(data.pageCurrentNo);
                // `id``cusName``cusLoginName``cusPassword``cusEmail``cusSex``cusPhoto``cusHobby``cusCode``cusBirthday`
                for (var i = 0; i<data.list.length ; i++) {
                    $("table").append("<tr>" +
                        "<td>"+data.list[i].id+"</td>" +
                        "<td>"+data.list[i].cusName+"</td>" +
                        "<td>"+data.list[i].cusLoginName+"</td>" +
                        "<td>"+data.list[i].cusEmail+"</td>"+
                        "<td>"+data.list[i].cusSex+"</td>"+
                        "<td><img src='CusImage/"+data.list[i].cusPhoto+"'> </td>"+
                        "<td>"+data.list[i].cusHobby+"</td>"+
                        "<td>"+data.list[i].cusCode+"</td>"+
                        "<td>"+data.list[i].cusBirthday+"</td>"+
                        " <th ><a class=\"layui-btn\" href=\"javascript:void(0)\" onclick='update("+data.list[i].id+")'>修改</a>" +
                        // " <a class=\"layui-btn\" href=\"javascript:void(0)\" onclick='dele("+data.list[i].id+",this)'>删除</a>" +
                        "</th>"+
                        "</tr>");
                }
                showHide();
                $("#jump1").empty();
                for (var i = 1; i <= data.totalPages; i++) {
                    $("#jump1").append("<option  value=" + i + ">第" + i + "页</option>");
                }
                $("#jump1").val(data.pageCurrentNo);
            }
        }
        function selectList() {
            pageCurrentNo=1;
            Announce();
        }
        function jump() {
            pageCurrentNo= $("#jump1").val();
            Announce();
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
        function update(id) {
            location.href = "/page/customer/cusUpdate.jsp?id="+id;
        }
    </script>
</body>
</html>
