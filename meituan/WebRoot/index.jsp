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
<script type="text/javascript">


</script>
</head>

<body>

	
	<div id="divmain">
	
	
<%@include file="head.jsp"%>
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
             <a href="food_info.jsp"> <img  id="scroll-loading" src="${pageContext.request.contextPath }/upload/${s.img_url}"  /></a>
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
	
<div id="contex1" style="display:block;border:1px solid red;background-color:red; width:260px; height:200px; position:absolute;left:818px;top:92px;">
		
	</div>

</body>
</html>
