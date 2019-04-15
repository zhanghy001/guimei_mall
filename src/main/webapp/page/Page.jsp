<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    第<span id="pageNo"></span>页&nbsp;&nbsp;
    <a class="layui-btn layui-btn-sm" href="javascript:void(0)" id="begin" >首页</a>
    <a class="layui-btn layui-btn-sm" href="javascript:void(0)" id="prev">上一页</a>
    <a class="layui-btn layui-btn-sm" href="javascript:void(0)" id="next" >下一页</a>
    <a class="layui-btn layui-btn-sm" href="javascript:void(0)" id="end">末页</a>
    &nbsp;&nbsp;共<span id="totalPages"></span>页&nbsp;&nbsp;
</body>

<script>
    //初始化数据
    var pageCurrentNo=1; //当期页码
    var pagesize=3;      //页面容量

</script>
</html>
