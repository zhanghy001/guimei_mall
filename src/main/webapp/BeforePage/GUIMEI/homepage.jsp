<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title></title>
    <base href="<%=request.getContextPath()%>/"/>
	<script type="text/javascript" src="../../js/jquery-2.1.0.js"></script>
	<script type="text/javascript" src="../../js/homepage.js"></script>
    <link href="../../css/guimei.css" rel="stylesheet" type="text/css">
    <link href="../../css/homepage.css" rel="stylesheet" type="text/css">
    <script>
        $(function () {
            $.ajax({
                url:"doSmall",
                data:"action=smallQueryByBigId&bigId=1",
                type:"post",
                dataType:"json",
                success:function (list) {
                    $.each(list,function (index,all) {
                        $("#class_1_small").append("<div><a href='/BeforePage/GUIMEI/dianzichangping.jsp?smallId="+all.id+"'>"+all.smallName+"</a></div>")
                    })
                }
            })
            $.ajax({
                url:"doSmall",
                data:"action=smallQueryByBigId&bigId=2",
                type:"post",
                dataType:"json",
                success:function (list) {
                    $.each(list,function (index,all) {
                        $("#class_2_small").append("<div><a href='/BeforePage/GUIMEI/dianzichangping.jsp?smallId="+all.id+"'>"+all.smallName+"</a></div>")
                    })
                }
            })
            $.ajax({
                url:"doSmall",
                data:"action=smallQueryByBigId&bigId=3",
                type:"post",
                dataType:"json",
                success:function (list) {
                    $.each(list,function (index,all) {
                        $("#class_3_small").append("<div><a href='/BeforePage/GUIMEI/dianzichangping.jsp?smallId="+all.id+"'>"+all.smallName+"</a></div>")
                    })
                }
            })
            $.ajax({
                url:"doSmall",
                data:"action=smallQueryByBigId&bigId=4",
                type:"post",
                dataType:"json",
                success:function (list) {
                    $.each(list,function (index,all) {
                        $("#class_4_small").append("<div><a href='/BeforePage/GUIMEI/dianzichangping.jsp?smallId="+all.id+"'>"+all.smallName+"</a></div>")
                    })
                }
            })

        var customer="${customer}";
        if(customer!=""){
            $("#login_d").hide();
            }else {
            $("#exit").hide();
            $(".a_login").hide();

        }
        })
    </script>
</head>
<body>
<%@include file="frame.jsp"%>
<%@include file="head.jsp"%>

    <div id="home_body" >
    
        <div id="body_1">
        	<p id="class_1_big" style="margin-top:38px;">家用电器</p>
			<div id="class_1_small" style="margin: 9px">
			</div>
        	<p id="class_2_big" style="margin-top:4px;">手机数码</p>
			<div id="class_2_small">
			</div>
        	<p id="class_3_big" style="margin-top:3px;">日用百货</p>
			<div id="class_3_small">
			</div>
        	<p id="class_4_big" style="margin-top:1px;">书籍</p>
			<div id="class_4_small">
			</div>
        </div>
        
        <div id="body_2">
            <div >
            <div  id="b2d2">
                <img name="adimg" src="../images/img/images/ad-01.jpg">
                <img name="adimg" style="display: none" src="../images/img/images/ad-02.jpg">
                <img name="adimg" style="display: none" src="../images/img/images/ad-03.jpg">
                <img name="adimg" style="display: none" src="../images/img/images/ad-04.jpg">
            </div>
             <div id="ad_a">
                <div class="ad_a1" onmouseover=xunhuan(1)>1</div>
                <div class="ad_a1" onmouseover=xunhuan(2)>2</div>
                <div class="ad_a1" onmouseover=xunhuan(3)>3</div>
                <div class="ad_a1" onmouseover=xunhuan(4)>4</div>
            </div>
            </div>
            <div id="b2d1" >
                <%--doGoods?action=goodsCusQuery&pageNumber=1--%>
                <iframe style="width: 100%; height: 100%;border: 0px"   src="BeforePage/GUIMEI/goodsQuery.jsp"  ></iframe>
            </div>
        </div>

        <div id="body_3">
         	<div	id="announ" style="width:210px;margin-top:44px;margin:50px 0 65px 10px;">
                <%--src="doAn?action=anQueryNew" 公告--%>
                <iframe style="width: 100%; height: 100%;border: 0px"   src="BeforePage/GUIMEI/anQuery.jsp"  ></iframe>
            </div>
            <div class="b3dx" >
                <%--新品上市--%>
                <iframe style="width: 100%; height: 100%;border: 0px"   src="BeforePage/GUIMEI/goodsQueryNew.jsp"  ></iframe>
            </div>
            <div style="width: 234px;height: 47px;position: relative;top: -100px" onclick=congzi()  >
                <img id="ad_img" style="margin-top: 6px;visibility:visible"  src="../../images/img/images/phono.jpg" >
            </div>
            <div id="b3congzhi">
                <div id="selbd_1">
                   <form action="#" method="post">
                   品&nbsp;牌：<select class="selbd">
                       <option value="联想">联想</option>
                       <option value="联想">DELL</option>
                       <option value="联想">华硕</option>
                       <option value="联想">苹果</option>
                       <option value="联想">HP</option>
                   </select><br>
                   尺&nbsp;寸：<select class="selbd">
                       <option value="联想">14英寸</option>
                       <option value="联想">16英寸</option>
                       <option value="联想">17英寸</option>
                       <option value="联想">19英寸</option>
                   </select><br>
                   价&nbsp;格：<select class="selbd">
                       <option value="联想">4000元以下</option>
                       <option value="联想">5000元以下</option>
                       <option value="联想">6000元以下</option>
                       <option value="联想">7000元以下</option>
                       <option value="联想">8000元以下</option>
                   </select>
                   <input style="margin: 8px 0 0 30px" type="image" src="../../images/img/images/tabbody2.JPG">
                   </form>
               </div>
            </div>
            <div id="b3congzhi2">
                <div id="selbd_2">
                    运营商：<select class="selbd">
                        <option>移动</option>
                        <option>联通</option>
                        <option>电信</option>
                    </select>
                    地&nbsp;&nbsp;&nbsp;区：<select class="selbd">
                        <option>北京</option>
                        <option>湖南</option>
                        <option>湖北</option>
                        <option>上海</option>
                        <option>成都</option>
                        <option>香港</option>
                    </select>
                    面&nbsp;&nbsp;&nbsp;值：<select class="selbd">
                        <option>100元</option>
                        <option>50元</option>
                        <option>20元</option>
                        <option>10元</option>
                    </select>
					<input style="margin: 8px 0 0 30px" type="image" src="../../images/img/images/tabbody2.JPG">
                </div>
            </div>
        </div>

    </div>

	<%@include file="foot.jsp"%>
</body>
</html>