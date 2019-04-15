<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <base href="<%=request.getContextPath()%>/"/>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <%@include file="layUI.jsp"%>

</head>
<body>
<form action="/GoodsNewServlet?action=add" method="post" enctype="multipart/form-data" >
    <di id="d1"></di>
    商品名称<input type="text"  name="goodsName" id="goodsName">
    小分类名称<select name="goodsSmalId" id="goodsSmalId">
    <option value="-1">全部</option>
    </select>
    商品的价格<input type="text"  name="goodsMoney" >
    商品的数量<input type="text" name="goodsNumber" >
    商品的图像<input type="file"  name="goodsImage" onchange="checkImage(this.value)"><br>
    商品的运费<input type="text"  name="goodsCarriage" >
    商品的类型<select name="goodsType" id="goodsType">
    <option value="${0}">新品</option>
    <option value="${1}">二手</option>
</select>
    商品的折扣<select name="goodsDiscId" id="goodsDiscId">
    <option value="-1">全部</option>
</select>
    <input type="submit" value="添加" class="layui-btn" id="sub"  disabled="true">
</form>
<script type="text/javascript" src="js/jquery-2.1.0.js"></script>
<script type="text/javascript">
    $(function () {
        var flag = '${param.flag}';
        if (flag != null && flag != ""){
            if (flag == "true"){
                alert("添加成功");
            }else {
                alert("添加失败");
            }
        }

        getSellerName();
        getsmall();
        getDiscRate();
    });
    function checkImage(val) {
        var type=val.substring(val.lastIndexOf(".")+1);
        console.log(type)
        var types=["gif","bmp","jpg","png"];
        var status=false;
        for(var i=0;i<types.length;i++){
            if(type.toLowerCase()==types[i]){
                status=true;
                break;
            }
        }
        console.log(status);
        if(!status){
            document.getElementById("sub").disabled=true;
        }else {
            document.getElementById("sub").disabled=false;
        }
    }
    /**
     * 商家名下拉框
     */
    function getSellerName() {
        $.getJSON("/GoodsNewServlet",{"action":"selectSell"},callback);
        function callback(data) {
            $(data).each(function () {
                $("#goodsSeId").append("<option value=" + this.id + ">" + this.goodsSeName + "</option>");
            })
        }
    }
    /**
     * 小分类下拉框
     */
    function getsmall() {
        $.getJSON("/GoodsNewServlet",{"action":"selectsmall"},callback);
        function callback(data) {
            $(data).each(function () {
                $("#goodsSmalId").append("<option value=" + this.id + ">" + this.goodsSmallName + "</option>");
            })
        }
    }
    /**
     *  折扣下拉框
     * selectDiscRate
     */
    function getDiscRate() {
        $.getJSON("/GoodsNewServlet",{"action":"selectDiscRate"},callback);
        function callback(data) {
            $(data).each(function () {
                $("#goodsDiscId").append("<option value=" + this.id + ">" + this.goodsDiscRate + "</option>");
            })
        }
    }
</script>
</body>
</html>
