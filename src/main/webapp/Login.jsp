<%--
  Created by IntelliJ IDEA.
  User: 52203
  Date: 2019/1/1
  Time: 20:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>贵美登录</title>
    <%--css样式--%>
    <style>
        body{
            margin: 0px;
            padding: 0px;
            background-color: #B3B4B5;
        }
        .move{
            position: relative;
            left: 26%;
            top: 180px;

        }
        .core1{
            width: 208px;
            height: 30px;
            position: relative;
            left: 166px;
            top: -196px;
            background-color: #9a9b95;
            border: 0px;
        }
        .core2{
            width: 210px;
            height: 30px;
            position: relative;
            left: -47px;
            top: -140px;
            background-color: #9a9b95;
            border: 0px;
        }
        .core3{
            position: relative;
            left: 167px;
            top: -132px;
            font-family: 隶书;
            font-size: 19px;
            color: white;
            border: 1px;
        }
        .core4{
            position: relative;
            left: 130px;
            top: -122px;
        }
        label{
            position: relative;
            left: 906px;
            top: -112px;
            color: red;
            font-family: 隶书;
        }
        .lab2{
            position: relative;
            top: -70px;
        }
    </style>

</head>
<body>
<div class="main">
    <form class="move" method="post" action="javascript:void(0)">
        <%--<div><a href="Cuslogin.jsp">顾客</a></div>--%>
        <div style="color: red">${login}</div>
        <div><img src="img/login2.PNG" alt="" ></div>
        <div>
            <input type="text" id="userLoginName" placeholder="请输入用户名" class="core1">
            <input type="password" id="userPassword" placeholder="请输入密码" class="core2">
            <div class="core3">
                <input type="radio" name="chageLogin" value="管理员">管理员
                <input type="radio" name="chageLogin" value="商家" checked="checked">商家
            </div>
            <input type="image" src="img/login-botton.PNG" class="core4" id="img"/>
        </div>

    </form>     <label class="lab1"></label>
           <div><label class="lab2"></label></div>
                <label id="err1"></label>
</div>
</body>
<script type="text/javascript" src="js/jquery-2.1.0.js"></script>
<script type="text/javascript" >
  /*$(function () {
      var LoginName=$("#userLoginName").val();
      var LoginPwd=$("#userPassword").val();
      $.getJSON("/doSel",{"action":"login","LoginName":LoginName,"LoginPwd":LoginPwd},callback)
      function callback(data) {
          if(data.flag=="true"){

          }else {
              alert("");
          }
      }
  })*/
  <%--登录操作--%>
  $(function () {
      var nameSta=false;
      var pwdSta=false;
      $(".core4").click(function () {
          if($(".core1").val().trim()==""){
              $(".lab1").html("账号不完整");
              nameSta=false;
          }else {
              nameSta=true;
              $(".lab1").html("");
          }
          if($(".core2").val().trim()==""){
              $(".lab2").html("密码不完整");
              pwdSta=false;
          }else {
              pwdSta=true;
              $(".lab2").html("");
          }
          if(nameSta && pwdSta){
              var userLoginName=$(".core1").val();
              var userPassword=$(".core2").val();
              if($(".core3 [type=radio]:checked").val()=="商家"){
                  $.getJSON("/doSel",{"action":"sellerLogin","userLoginName":userLoginName,"userPassword":userPassword},callback);
                  function callback(data) {
                      if(data.sellerName==null || data.sellerName==""){
                          alert("用户名或密码不正确");
                      }else {
                          location.href="/Seller/index.jsp";
                      }
                  }
              }
              if($(".core3 [type=radio]:checked").val()=="管理员"){
                  $(".move").prop("action","doUser?action=userLogin&userLoginName="+userLoginName+"&userPassword="+userPassword);
              }
          }
      })
      //     $(".core4").click(function () {
      //         for(var i=0 ;i<$(".core3 [type=radio]").length;i++){
      //             if($(".core3 [type=radio]")[i].checked==true){
      //                 alert($(".core3 [type=radio]")[i])
      //             }
      //         }
      //         alert($(".core3 [type=radio]:checked").val())
      //     })
  })
</script>
</html>
