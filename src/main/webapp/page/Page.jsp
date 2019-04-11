<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<base href="<%=request.getContextPath()%>/"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <p></p>
    第<b id="pageNo"></b>页&nbsp;&nbsp;
    <a class="layui-btn layui-btn-sm" href="javascript:void(0)" id="begin">首页</a>
    <a class="layui-btn layui-btn-sm" href="javascript:void(0)" id="prev">上一页</a>
    <a class="layui-btn layui-btn-sm" href="javascript:void(0)" id="next">下一页</a>
    <a class="layui-btn layui-btn-sm" href="javascript:void(0)" id="end">末页</a>
    &nbsp;&nbsp;共<b id="totalPages"></b>页&nbsp;&nbsp;
    <select id="jump1">
        <c:forEach begin="1" varStatus="tea" end="${Page.totalPage}">
            <option name="op1" value="${tea.count}">第${tea.count}页</option>
        </c:forEach>
    </select> &nbsp;&nbsp;
    <b class="layui-btn layui-btn-sm" onclick="jump()">跳转页面</b>
    <script type="text/javascript" src="js/jquery-2.1.0.js"></script>
    <script type="text/javascript">
        function jump() {
            var number=document.getElementById("jump1").value;
            location="${servletURL}&pageNumber="+number;
        }

    </script>

</body>
</html>
