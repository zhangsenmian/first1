<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>bookStore注册页面</title>
<%--导入css --%>
<link rel="stylesheet" href="css/register.css" type="text/css" />
<script type="text/javascript" src="/meituan/jquery/jquery-3.3.1.min.js"></script>
	<script type="text/javascript">
	
	$(document).ready(function(){
		var myreg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
		$('#youxiang').blur(function(){
			
			var email = $(this).val();
			
			
		
			$.ajax({
		        url:"JSONServlet1",
		        type:"post",
		        data:{"email":email},
		        dataType:"json",
		        success: function(data) {
			        if(data[0].email == "false"){
			        	$("#email").html("该邮箱已经存在");
			        }else{
			        	$("#email").html("");
			        }
                },
		        error: function(XMLHttpRequest, textStatus, errorThrown) {
		            alert(XMLHttpRequest.status);
		            alert(XMLHttpRequest.readyState);
		            alert(textStatus);
		        }
		    });
 			
		});
			
		
		$('#username').blur(function(){
			
			var username = $(this).val();
		
			$.ajax({
		        url:"JSONServlet3",
		        type:"post",
		        data:{"username":username},
		        dataType:"json",
		        success: function(data) {
			        if(data[0].username == "false"){
			        	$("#check").html("该用户名已经存在");
			        }else{
			        	$("#check").html("");
			        }
                },
		        error: function(XMLHttpRequest, textStatus, errorThrown) {
		            alert(XMLHttpRequest.status);
		            alert(XMLHttpRequest.readyState);
		            alert(textStatus);
		        }
		    });
		});
		
	});

	function check(){
		var youxiang = document.getElementById("youxiang").value;
		var username = document.getElementById("username").value;
		var password = document.getElementById("login-verify-code").value;
		var telephone = document.getElementById("tel").value;
		if(youxiang == ''){
			alert("邮箱不能为空");
			return false;
		}
		else if(username == ''){
			alert("用户名不能为空");
			return false;
		}
		else if(password == ''){
			alert("密码不能为空");
			return false;
		}
		else if(login_shop == ''){
			alert("电话号码不能为空");
			return false;
		}
		else 
			return true;
	}
	
	function changeImage() {

		document.getElementById("img").src = "${pageContext.request.contextPath}/imageCode?time="
				+ new Date().getTime();
	}
	
	</script>

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
                    <br><br>
          <span id="divmid11">账号注册</span><br><br>
          <form method="post" action="userRegisterServlet" onsubmit="return check()">
           <span><input class="login-mobile"  id="youxiang" name="email" value="" placeholder="请输入邮箱" type="text"></span><span id="email"></span><br><br>
          <span><input class="login-mobile" id="username"  name="username" value="" placeholder="请输入用户名" type="text"><span id="check"></span></span><br><br>
          <span><input name="password" id="login-verify-code" autocomplete="off" value="" placeholder="请输入密码" type="password"></span><br><br>
           <span><input class="login-mobile" id="tel" name="telephone" value="" placeholder="请输入电话" type="text"></span><br><br>
          <span><input id="btn" name="commitpassword" value="同意并注册" type="submit"></span><br><br>
          </form>
           <span id="divmid13">已同意《美团网用户协议》</span><br><br>
           
  </div>



<hr>

  <div id="divfoot">
     <li style="list-style-type:none" align="center"  id="footfont">©2018 美团网团购 meituan.com 京ICP证070791号 京公网安备11010502025545号 电子公告服务规则</li>
  </div>

  </div>


</body>
</html>
