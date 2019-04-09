<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>贵美商城</title>
	<style type="text/css">
 		/*左右上下浮动图片*/
        #mm1,#mm2{
            position: absolute;
            height: 800px;
        }

        #mm2{
           	left:89%;
        }
        #mm1{
            left:3%;
        }
	</style>
    <script type="text/javascript" src="../../js/jquery-2.1.0.js"></script>
    <link href="../../css/guimei.css" rel="stylesheet" type="text/css">
</head>
<body>
<marquee id="mm1" direction="down" style="z-index: -1;"><img src="../../images/img/images/list1.jpg"></marquee>
<marquee id="mm2" direction="up" style="z-index: -1;"><img src="../../images/img/images/list2.jpg"></marquee>
</body>
</html>