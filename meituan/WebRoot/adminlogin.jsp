<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'adminlogin.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="css/adminlogin.css">

<script>
function check(){
		var username = document.getElementById("login-mobile").value;
		var password = document.getElementById("login-verify-code").value;
		if(username == ''){
			alert("用户名不能为空");
			return false;
		}
		else if(password == ''){
			alert("密码不能为空");
			return false;
		}
		else 
			return true;
	}
</script>

  </head>
  
  <body>
    <div id="divmain">

  <div id="divhead">
    <div id="divhead1">
         <image  id="divhead1image" src="images/banner_logo2.png"/>
    </div>
    <div id="divhead2">    
             商家PC客户端 &nbsp;&nbsp;&nbsp;商家手机客户端
      </div>
  </div>

  <div id="divmid"> 
         <div  id="divmid2">
                    <br><br>
          <span id="divmid11">商家登录</span> <br><br>
          <form method="post" action="BusinessLoginServlet" onsubmit="return check()">
          <span><input id="login-mobile"  name="business_name" value="" placeholder="请输入用户名" type="text"></span><br><br>
          <span><input name="business_password" id="login-verify-code" autocomplete="off" value="" placeholder="请输入密码" type="password"></span><br><br>
          <span><input id="btn" name="" value="登录" type="submit"></span><br><br>
          </form>
           <span id="divmid13">已同意《美团网用户协议》</span><br><br>
          </div> 
  </div>



<hr>

  <div id="divfoot">
     <li style="list-style-type:none" align="center"  id="footfont">©2018 美团网团购 meituan.com 京ICP证070791号 京公网安备11010502025545号 电子公告服务规则</li>
  </div>

  </div>

  </body>
</html>
