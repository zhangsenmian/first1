<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

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
    <input id="divhead10" name="name" placeholder="搜索商家，美食" type="text" ></td> 
    <td><input type="image" src="images/search1_.jpg" border="0" width="40px" height="40px" onclick="javascript:document.forms['Form_2'].submit(); return false;">
    
   <!--  <img src="images/search1_.jpg" style="width="40" height="40"  /> -->
        </td>
        </form>
      </tr>
    </table>
    </div>
  </div>
  
  
  

