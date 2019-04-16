<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
共<span id="total"></span>条记录&nbsp;&nbsp;
<span id="pageNo"></span>/<span id="totalPages"></span>页&nbsp;&nbsp;&nbsp;&nbsp;
<a href="javascript:void(0)" id="begin">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;
<a href="javascript:void(0)" id="prev">上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
<a href="javascript:void(0)" id="next">下一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
<a href="javascript:void(0)" id="end">最后一页</a>
</span>
<span class="page-go-form"><label>跳转至</label>
	     <input type="text" name="inputPage" id="inputPage" class="page-key"/>页
		</span>
<b  id="page-btn" class="page-btn" >跳转页面</b>
</body>
</html>
