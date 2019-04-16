<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <base href="<%=request.getContextPath()%>/"/>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@include file="layUI.jsp"%>
</head>
<body>


            <div id="goodsimg" style="float: left;font-size: 10px;width: 80px;height: 80px;margin: 8px 0px 18px 40px;">

            </div>

            <div style="clear: both"><br><br><br><%@include file="Page.jsp"%></div>


            <script type="text/javascript" src="js/jquery-2.1.0.js"></script>
            <script type="text/javascript">
                // var pageCurrentNo = 1; // 当前页面
                // var pagesize = 5;  //  显示页面
                $(function () {
                    // 首页
                    $("#begin").click(function () {
                        pageCurrentNo = 1;
                        Goods();
                    });
                    //  上一页
                    $("#prev").click(function () {
                        pageCurrentNo =pageCurrentNo - 1;
                        Goods();
                    });
                    //  下一页
                    $("#next").click(function () {
                        pageCurrentNo =pageCurrentNo + 1;
                        Goods();
                    });
                    //  末页
                    $("#end").click(function () {
                        pageCurrentNo = $("#totalPages").html();
                        Goods();
                    });
                    //  转跳
                    $("#page-btn").click(function () {
                        pageCurrentNo = $("#inputPage").val();
                        Goods();
                    });
                    Goods();
                });

                function selectList() {
                    pageCurrentNo=1;
                    Goods();
                }
                function jump() {
                    pageCurrentNo= $("#jump1").val();
                    Goods();
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
                function Goods() {
                    $("#goodsimg").html("");

                    var goodName = "";
                    var sellerName = -1;
                    var smallName = -1;

                    $.getJSON("/GoodsNewServlet",{"action":"select","pageCurrentNo":pageCurrentNo,"pagesize":10,"goodName":goodName,"sellerName":sellerName,"smallName":smallName},callback);
                    function callback(data) {
                        $("#pageNo").html(data.pageCurrentNo);
                        $("#totalPages").html(data.totalPages);
                        for (var i = 0; i<data.list.length ; i++) {
                            $("#goodsimg").append("<a href='#' target='_parent'>" +
                                "<img src='GoodsImage/"+data.list[i].goodsImage+"' style='width: 80px;height: 80px'>" +
                                "<br>"+data.list[i].goodsName+"</a>");

                        }

                        showHide();
                        $("#jump1").empty();
                        for (var i = 1; i <= data.totalPages; i++) {
                            $("#jump1").append("<option  value=" + i + ">第" + i + "页</option>");
                        }
                        $("#jump1").val(data.pageCurrentNo);
                    }

                }
            </script>
</body>
</html>
