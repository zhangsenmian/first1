<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>电子书城</title>
<link rel="stylesheet" href="css/food_info.css" type="text/css" />

<script type="text/javascript" src="/meituan/jquery/jquery-3.3.1.min.js"></script>



</head>

<body class="main">
<div id="divmain">
    <%@include file="head.jsp"%>

<div id="divmid">
       <div id="divmid1">
          <div id="divmid11">
          <img src="images/1caeb8290d2fa4034ade34a31e6cb5c6208640.png" width="106" height="80" border="0" /> 
        </div>
        <div id="divmid12">
          <div><span id="divmid12font"> 西贝莜面村（广州天河店） </span></div>
           <div id="divmid121"><span>4.5分</span></div>
        </div>
        
         <div id="divmid13">
          <div><span id="divmid12font">平均送餐时间</span></div>
           <div id="divmid121"><span id="divmid13font">30分钟</span></div>
        </div>
         <div id="divmid14">
          <div><span id="divmid12font"> 起送 </span></div>
           <div id="divmid121"><span id="divmid13font">20元</span></div>
        </div>
        <div id="divmid15">
          <div><span  id="divmid12font"> 配送 </span></div>
           <div id="divmid121"><span id="divmid13font">8元</span></div>
        </div>
  </div>
  </div>


  <div id="divmidnext">
        <div id="divmidnext1"><a href="#">评价</a></div>
        <div id="divmidnext1"><a href="#">食品安全档案</a>
</div>
  </div>


  <div id="divlist">
  
     <c:forEach items="${Foods }" var="b">
     
     
     <!-- <div class="j-pic-food pic-food" id="776508279">
    <div class="avatar">
      <img src="http://p1.meituan.net/210.0/wmproduct/67e7417765e1be48fb6a7e3441da4488312375.jpg" data-src="http://p1.meituan.net/210.0/wmproduct/67e7417765e1be48fb6a7e3441da4488312375.jpg" class="food-shape scroll-loading" alt="美团外卖-紫苏煎泥鳅">
    </div>

    <div class="np clearfix">
      <span class="name fl" title="${b.foodname }">
        ${b.foodname }
      </span>
    </div>

    <div class="labels clearfix">
        <div id="food-1" class="food-addcart contextCannotSelected fr">+</div>
        <span id="food776508279-cart-num" class="food-number fr" style="display:none;">0</span>
		<div class="price fl">
			<div class="only">${b.foodprice }</div>
		</div>
    </div>
  	</div>
   -->

        <div id="divlist1">
            <div id="preview">
              <img  id="scroll-loading" src="${pageContext.request.contextPath }/upload/${f.img_url}"  />
              <div class="rest-tags">
              </div>
            </div>
            <div id="content">
              <div class="name">
                <span title="${b.foodname }">
                ${b.foodname }
                </span>
              </div>
                <div id="rankclearfix">
                  <span class="score-num fl">赞7</span>
                </div>
              <div id="price">
                  <div  class="price2">
                  	<span class="start-price">￥ ${b.foodprice }</span>
                  </div>
                  <div  id="price1"> 
                  	<span class="addnum" style="display: none;" id="span_addnum">0</span>
                  	<a class="addfood" id="${b.fid }"><img src="images/fd039245d688d43f6fe978c9761ed21b0ef43b4d_.jpg"  width="24" height:="24" /></a>
                  </div>
                </div>
              </div>
              </div>
             
         </c:forEach>
          
  </div>

  </div>

<div class="shopping-cart clearfix">
	   <form method="post" action="/meituan/orderInfo.jsp" id="shoppingCartForm">
  	   <div class="order-list hideCart" style="top: -257px;">
  	   <div class="title">
       <span class="fl buy-title">购物车</span>
  	   <a href="javascript:;" class="clear-cart fr">清空菜品</a>
  	   </div>
  	    <ul style="height: auto; overflow: visible;"></ul>
		  <div class="other-charge">			
  	        <div class="clearfix delivery-cost">
  	          <span class="fl">配送费(不计入起送价)</span>
  	          <span class="fr shippingfee">¥8</span>
  	        </div>			
  	      </div>
		  		  
  	      <div class="privilege hidden" style="">
  	      </div>
  	      <div class="total">共<span class="totalnumber">1</span>份，总计<span class="bill">¥35</span></div>
  	    </div>

  	    <div class="cart-footer clearfix">
          <div class="logo icon fl"></div>
          <div class="brief-order fl" style="display: none;">
            <span class="count">1</span>
            <span class="price"><i>¥</i>35</span>
          </div>
          <div class="fr">
           <a class="ready-pay borderradius-2" href="javascript:;" style="display: none;">差<span data-left="15" class="margintominprice">0</span>元起送</a>
            <input class="go-pay fr" type="submit" value="立即下单" style="display: inline-block;">
            <input type="hidden" value="{&quot;poi&quot;:&quot;144720505017167356&quot;,&quot;foods&quot;:[{&quot;sku&quot;:254415497,&quot;attrs&quot;:[],&quot;num&quot;:1}]}" class="order-data" name="shop_cart">
          </div>
        </div>
      </form>
    </div>
	
	
	</div></div>

  <!--  <div id="gouwucar">
      <div id="gouwucar1">
              <a href="#"><img  src="images/gou_2.jpg"  width="50" height:="50"/> </a>
      </div>
      <div id="gouwucar2"> <div id="gouwucar22">&nbsp;&nbsp;差20元起送 </div></div>
  </div>
-->
<script type="text/javascript" src="js/food_info.js"></script>
</body>
</html>
