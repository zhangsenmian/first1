<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";   
%> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>美团外卖登陆页面</title>

<link rel="stylesheet" href="${path }css/login.css" type="text/css" />
</head>

<body class="main">

	<div id="divmain">

  <div id="divhead">
    <div id="divhead1">
         <image  id="divhead1image" src="images/17001023143713.png"/>
    </div>
  </div>

  <div id="divmid"> 
         <div  id="divmid2">
            <image src="images/a.png"/>
         </div>
       <div id="divmid1">
       <br><br><br>
       <form method="post" action="LoginServlet">
          <span id="divmid11">账号登录</span><br><br>
          <span><input id="login-mobile"  name="mobile" value="" placeholder="请输入登录登录用户名" type="text"></span><br><br>
          <span><input name="code" id="login-verify-code" autocomplete="off" value="" placeholder="请输入密码" type="password"></span><br><br>
          <span id="divmid12"><input value="1" name="auto_login" id="mobile-autologin" class="f-check " type="checkbox"><label class="normal" for="mobile-autologin">7天内自动登录</label></span><br><br>
          <span><input id="btn" name="commit" value="登录" type="submit"></span><br><br>
        </form>
           <span id="divmid13">提示： 未注册美团账号的手机号，登录时将自动注册美团账号，且代表您已同意《美团网用户协议》</span><br><br>
           <span id="divmid14">--------------用合作网站账号登录--------------</span>
       </div>
  </div>




  <div id="divfoot">
     <li style="list-style-type:none" align="center"  id="footfont">©2018 美团网团购 meituan.com 京ICP证070791号 京公网安备11010502025545号 电子公告服务规则</li>
  </div>

  </div>


</body>
</html>
