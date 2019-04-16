<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <base href="<%=request.getContextPath()%>/"/>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <script src="static/js/jquery-2.1.1.min.js"></script>
    <%@include file="layUI.jsp"%>
    <script>
        $(function () {
            var goodsNameOne=$("#goodsName").val().trim();
            var goodsSeIdOne=$("#goodsSeId").val().trim();
            $.ajax({
                url:"doSmall",
                data:"action=smallNameAll",
                type:"post",
                dataType:"json",
                success:function (list) {
                    $.each(list,function (index,all) {
                        $("#goodsSmalId").append("<option value='"+all.id+"'>"+all.smallName+"</option>")
                    })
                }
            })
     /*       $.ajax({
                url:"doSel",
                data:"action=selNameAll",
                type:"post",
                dataType:"json",
                success:function (list) {
                    $.each(list,function (index,sel) {
                        $("#goodsSeId").append("<option value='"+sel.id+"'>"+sel.sellerName+"</option>")
                    })
                }
            })*/
            $.ajax({
                url:"doDis",
                data:"action=disNameAll",
                type:"post",
                dataType:"json",
                success:function (list) {
                    $.each(list,function (index,dis) {
                        $("#goodsDiscId").append("<option value='"+dis.id+"'>"+dis.discRate+"</option>")
                    })
                }
            })

            $("#goodsName").blur(function () {
                var goodsName=$(this).val().trim();
                var goodsSeId=$("#goodsSeId").val().trim();
                var status=true;
                if(goodsNameOne==goodsName){
                    status=false;
                }
                if(status){
                    var url="doGoods";
                    var data="action=queryName&goodsName="+goodsName+"&goodsSeId="+goodsSeId;
                    $.post(url,data,function (i) {
                        if(i==1){
                            $("#sub").prop("disabled",true);
                            $("#d1").html("要输入名字并不能重名").css("color","red");
                        }else {
                            $("#sub").prop("disabled",false);
                            $("#d1").html("输入名字可以使用").css("color","red");
                        }
                    },"json");
                }
            })
            $("#goodsSeId").blur(function () {
                var goodsSeId=$(this).val().trim();
                var goodsName=$("#goodsName").val().trim();
                var status=true;
                if(goodsSeIdOne==goodsSeId){
                    status=false;
                }
                if(status){
                    var url="doGoods";
                    var data="action=queryName&goodsName="+goodsName+"&goodsSeId="+goodsSeId;
                    $.post(url,data,function (i) {
                        if(i==1){
                            $("#sub").prop("disabled",true);
                            $("#d1").html("要输入名字并不能重名").css("color","red");
                        }else {
                            $("#sub").prop("disabled",false);
                            $("#d1").html("输入名字可以使用").css("color","red");
                        }
                    },"json");
                }
            })

            function checkImage(val) {
                var type=val.substring(val.lastIndexOf(".")+1);
                var types=["gif","bmp","jpg","png"];
                var status=false;
                for(var i=0;i<types.length;i++){
                    if(type.toLowerCase()==types[i]){
                        status=true;
                        break;
                    }
                }
                if(!status){
                    document.getElementById("sub").disabled=true;
                }else {
                    document.getElementById("sub").disabled=false;
                }
            }
        })
    </script>
</head>
<body>
商品图像<table ><tr><td id="img"><img src="GoodsImage/${All.goods.goodsImage} " style="width: 200px;height: 200px"></td></tr></table>
<form action="" method="post" enctype="multipart/form-data">
    <di id="d1"></di>
    商品id<input type="text" value="${All.goods.id}" name="id" id="id" readonly>
    商品名称<input type="text" value="${All.goods.goodsName}" name="goodsName" id="goodsName">
    小分类名称<select name="goodsSmalId" id="goodsSmalId">
        <option value="${All.id}">${All.smallName}</option>
    </select>
    商品的价格<input type="text" value="${All.goods.goodsMoney}" name="goodsMoney" id="goodsMoney" >
    商品的数量<input type="text" value="${All.goods.goodsNumber}" name="goodsNumber" id="goodsNumber" ><br>
    <%--需要修改的商品图像<input type="file"  name="goodsImage" onchange="checkImage(this.value)">--%>
    商品的运费<input type="text" value="${All.goods.goodsCarriage}" name="goodsCarriage" id="goodsCarriage" >
    商品的类型<select name="goodsType" id="goodsType">
    <option value="${All.goods.goodsType}">${All.goods.goodsType==0?'新品':'二手'}</option>
    <option value="${0}">新品</option>
    <option value="${1}">二手</option>
</select>
    商家名称<select name="goodsSeId" id="goodsSeId">
    <option value="${All.seller.id}">${All.seller.sellerName}</option>
</select>
    商品的折扣<select name="goodsDiscId" id="goodsDiscId">
    <option value="${All.discount.id}">${All.discount.discRate}</option>
</select>
    <input type="button" value="修改完成" class="layui-btn" id="sub" onclick="update()" >
</form>


<script type="text/javascript" src=""></script>
<script type="text/javascript">
    $(function () {

        getSellerName();
        getsmall();
        getDiscRate();
        /**
         * 获取数据
         */
        $(function () {
            var id = '${param.id}';
            $.getJSON("/GoodsNewServlet","action=selectid&id="+id,callback);
            function callback(data) {
                var i = data.goodsImage;

                //$("#img").html("<img src='GoodsImage/'"+data.goodsImage+" style='width: 200px;height: 200px'>");
                $("#img").html("<img src='GoodsImage/"+data.goodsImage+"' style='width: 200px;height: 200px' >");
                $("#id").val(data.id);
                $("#goodsName").val(data.goodsName);
                $("#goodsSmalId").val(data.goodsSmalId);
                $("#goodsMoney").val(data.goodsMoney);
                $("#goodsNumber").val(data.goodsNumber);
                $("#goodsCarriage").val(data.goodsCarriage);
                $("#goodsType").val(data.goodsType);
                $("#goodsSeId").val(data.goodsSeId);
                $("#goodsDiscId").val(data.goodsDiscId);
            }
        });


    })

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
    /**
     * 修改
     */
    function update() {

        var paramArray = $("form").serializeArray(); //序列化为json数组
        var queryString = $.param(paramArray);//将数组序列化为字符串
        $.getJSON("/GoodsNewServlet?action=update", queryString, callback);

        function callback(data) {
            if (data.flag == "true") {
                alert("修改成功")
                location.href = "Seller/goodsQuery.jsp?sllerNa=${seller.sellerName}&sellerId=${seller.sellerId}";
            } else {
                alert("修改失败")
            }
        }
    }
</script>
</body>
</html>
