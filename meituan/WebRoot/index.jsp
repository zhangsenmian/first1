<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";   
%> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
  <base href="<%=basePath%>">
<title>美团首页</title>
<%--导入css --%>
<link rel="stylesheet" href="css/index.css" type="text/css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/my.js">
	
</script>
<script type="text/javascript">
	
	window.onload = function(){
		//得到搜索框对象
		var searchElement = document.getElementById("divhead10");
		//得到DIV元素
		var div = document.getElementById("context1");
		
		searchElement.onkeyup = function(){//给文件框注册按键弹起事件
			//获取文本框的值
			var name = this.value;
				
			
			//如果文本框不没有数据时，把div隐藏，且不向服务器发送请求
			if(name==""){
				div.style.display="none";
				return;
			} 
			
			//获得xhr对象
			var xhr = getXMLHttpRequest();
		
			//处理结果
			xhr.onreadystatechange = function(){
				if(xhr.readyState==4){//请求一 切正常
					if(xhr.status==200){//服务器响应一切正常
						var str = xhr.responseText;//得到服务器返回的数据
					 
						var ss = str.split(","); // 把字符串 1001，1002，1003 截成数组
						var childDivs = "";
						//循环把数据放入小的div中
						for(var i=0;i<ss.length;i++){
							childDivs+="<div onclick='writeText(this)' onmouseover='changeBackground_over(this)' onmouseout='changeBackground_out(this)'>"+ss[i]+"</div>";//把数组中的每个元素放到div中
						}
						
						div.innerHTML= childDivs;//把多个childDivs（div）放入列表div中
						div.style.display="block";//把列表隐藏
					}
				}
			}
			
			xhr.open("get","${pageContext.request.contextPath}/servlet/SearchShopByNameServlet?name="+name+"&time="+new Date().getTime());
			
			xhr.send(null);
		}
	}
	
	//鼠标悬浮时，改变背景色
	function changeBackground_over(div){
		div.style.backgroundColor = "gray";
	}
	//鼠标离开时，恢复背景色
	function changeBackground_out(div){
		div.style.backgroundColor = "";
	}
	
	//填充文本到搜索框
	function writeText(div){
		//得到搜索框
		var searchElement = document.getElementById("divhead10");
		searchElement.value = div.innerHTML;//把div中的文本添加到搜索框中
		div.parentNode.style.display="none";//把context1的div隐藏
	}
</script>
</head>

<body>

	
	<div id="divmain">
	
  <div id="divheadbefore">
    <div id="divheadbefore1">
         <a href="#" id="acolor">天河区 一点点(石牌西店)</a >&nbsp;|&nbsp;<a href="#" id="acolor1">切换地址</a>
    </div>
    <div id="divheadbefore2">
         <a href="register.jsp"  id="acolor">注册</a>&nbsp;|&nbsp;<a href="login.jsp" id="acolor">登录</a>
    </div>
    <div id="divheadbefore3">
        <a href="#" id="acolor">手机版</a>&nbsp;|&nbsp;<a href="#" id="acolor">美团网</a>&nbsp;|&nbsp;<a href="#" id="acolor">联系我们</a>
    </div>
  </div>
 <div class="clear"></div>
  <div id="divhead">
  
 


    <div id="divhead1">
    
    <table  cellspacing="0">
    <tr >
        <td width="296">
        <img src="images/logo1.png" width="163" height="48" border="0" /> </td> <td width="94.5">
    <a href="#">首页</a></td> <td width="144.5">
      <a href="#"> 我的订单</a></td> <td width="144.5">     
    <a href="adminregister.jsp">入驻加盟</a></td> <td >
    <form name="Form_2" action="${pageContext.request.contextPath}/servlet/SearchAllShopByNameServlet"
		method="post">
    <input id="divhead10" name="name" placeholder="搜索商家，美食" type="text" value="${user.username }"></td> 
    <td><input type="image" src="images/search1_.jpg" border="0" width="40px" height="40px" onclick="javascript:document.forms['Form_2'].submit(); return false;">
    
   <!--  <img src="images/search1_.jpg" style="width="40" height="40"  /> -->
        </td>
        </form>
      </tr>
    </table>
    </div>
  </div>
  	
	


  <div id="divmid">
  <table  cellspacing="0" >
  <tr height="80">
   <td width="60">
	     
	 </td>
      <td width="120">
	      <a href="#">商品分类</a>
	 </td>
	 <td width="60">
          <a href="${pageContext.request.contextPath  }/servlet/ShopsPageServlet?currentPage=${pb.currentPage==1?1:pb.currentPage-1}"> 全部</a>
    </td> 
    <td width="60">     
	      <a href="${pageContext.request.contextPath  }/servlet/ShopsPageServlet?currentPage=${pb.currentPage==1?1:pb.currentPage-1}&category=1"">美食</a>
	</td> 
	    <td width="60">
	      <a href="${pageContext.request.contextPath  }/servlet/ShopsPageServlet?currentPage=${pb.currentPage==1?1:pb.currentPage-1}&category=2">超市</a>
	 </td>
	 <td width="90">
          <a href="${pageContext.request.contextPath  }/servlet/ShopsPageServlet?currentPage=${pb.currentPage==1?1:pb.currentPage-1}&category=3"> 精选小吃</a>
    </td> 
    <td width="75">     
	      <a href="${pageContext.request.contextPath  }/servlet/ShopsPageServlet?currentPage=${pb.currentPage==1?1:pb.currentPage-1}&category=4">鲜果购</a>
	</td>  
	<td width="75">     
	     <a href="${pageContext.request.contextPath  }/servlet/ShopsPageServlet?currentPage=${pb.currentPage==1?1:pb.currentPage-1}&category=5">下午茶</a>
	</td> 
	  </tr>
	</table>
	</div>

<%int i=0; %>
	<div id="divlist">
	<table>
	
	<tr>
	<c:forEach items="${pb.shops }" var="s">
	<td>
         <div id="divlist1">
            <div id="preview">
             <a href="${pageContext.request.contextPath}/FindFoodByIdHomeServlet?id=${s.id }"> <img  id="scroll-loading" src="${pageContext.request.contextPath }/upload/${s.img_url}"  /></a>
              <div class="rest-tags">
              </div>
            </div>
            <div id="content">
              <div class="name">
                <span title="西贝莜面村（广州天河店）">
                   ${s.name }
                </span>
              </div>
                <div id="rankclearfix">
                
                  <span class="score-num fl">4.7分</span>
                </div>
              <div id="price">
                <span class="start-price">起送:￥${s.startprice }</span>
                <span class="send-price">
                  配送费:￥5
                </span>
                <span class="send-time"><i class="icon i-poi-timer"></i>
                      32分钟
                </span>
              </div>
              </div>
              </td>
              <% i++; 
              if(i%4==0){
                out.print("</tr><tr>");
                }
              %>
</c:forEach>

              </tr>
              </table>
          
	</div>
	<div style="height:10px"></div>
	<div align="center">
									
                  <br>

				<a href="${pageContext.request.contextPath  }/servlet/ShopsPageServlet?currentPage=${pb.currentPage==1?1:pb.currentPage-1}&category=${cat}">&lt;&lt;上一页</a>
					&nbsp;&nbsp;&nbsp;
										
				第${pb.currentPage }页/共${pb.totalPage }页&nbsp;&nbsp;&nbsp;

			    <a href="${pageContext.request.contextPath  }/servlet/ShopsPageServlet?currentPage=${pb.currentPage==pb.totalPage?pb.totalPage:pb.currentPage+1}&category=${cat}">&lt;&lt;下一页</a></li>


									
    </div>
<div style="height:10px"></div>
<hr>

  <div id="divfoot">
     <li style="list-style-type:none" align="center"  id="footfont">©2018 美团网团购 meituan.com 京ICP证070791号 京公网安备11010502025545号 电子公告服务规则</li>
  </div>

   

	</div>
	
<div id="context1" style="display:block;border:0px ;background:red; width:260px; height:200px; position:absolute;left:818px;top:88px;">
		
	</div>

</body>
</html>
