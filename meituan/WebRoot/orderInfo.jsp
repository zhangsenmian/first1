<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>
<title>电子书城</title>
<link rel="stylesheet" href="css/main.css" type="text/css" />
</head>


<body class="main">
	<jsp:include page="head.jsp" />
	<jsp:include page="menu_search.jsp" />

	<div id="divpagecontent">
		<table width="100%" border="0" cellspacing="0">
			<tr>

				<td><div style="text-align:right; margin:5px 10px 5px 0px">
						<a href="index.jsp">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;;订单详细信息
					</div>



					<table cellspacing="0" class="infocontent">
						<tr>
							<td>
							<p></p>
								<table width="100%" border="0" cellspacing="0">
									<tr>
										<td>
											<p>用户:${user.id }</p></td>
									</tr>
									<tr>
										<td>
											<table cellspacing="1" class="carttable">
												<tr>
													<td width="10%">序号</td>
													<td width="40%">商品名称</td>
													<td width="10%">价格</td>
													<td width="10%">数量</td>
													<td width="10%">小计</td>

												</tr>
											</table>
						<form action="${pageContext.request.contextPath}/servlet/CreateOrderServlet "  method="post" name="orderform">
											<c:forEach items="${cart }" var="entery" varStatus="vs">
											
											<table width="100%" border="0" cellspacing="0">
												<tr>
													<td width="10%">${vs.count }</td>
													
													<td width="40%">${entery.key.foodname }</td>
													
													<td width="10%">${entery.key.foodprice }</td>
													
													<td width="10%">${entery.value }</td>
													
													<td width="10%">${entery.value*entery.key.foodprice }</td>
													<input name="money" type="hidden" value="${entery.value*entery.key.foodprice }">
                                                     <input name="state" type="hidden" value="0">
                                                      <input name="useid" type="hidden" value="${user.id }">
												</tr>
											</table>
											</c:forEach>

											<table cellspacing="1" class="carttable">
												<tr>
													<td style="text-align:right; padding-right:40px;"><font
														style="color:#FF0000">合计：&nbsp;&nbsp;1000</font></td>
												</tr>
											</table>

											<p>
													收货地址：<input name="receiverAddress" type="text" value="xxx"
														style="width:350px" />&nbsp;&nbsp;&nbsp;&nbsp;<a href="#"></a>
													<br /> 收货人：&nbsp;&nbsp;&nbsp;&nbsp;<input
														name="receiverName" type="text" value="xxx"
														style="width:150px" />&nbsp;&nbsp;&nbsp;&nbsp;<a href="#"></a>
													<br /> 联系方式：<input type="text" name="receiverPhone"
														value="xxx" style="width:150px" />&nbsp;&nbsp;&nbsp;&nbsp;

												</p>
												</form>
											<hr>
											<p style="text-align:right">
											<!-- 	<img src="images/gif53_029.gif" onclick="_submitOrder()"width="204"
													height="51" border="0" /> -->
													<input type="image" src="images/gif53_029.gif" border="0" width="204"
													height="51"onclick="javascript:document.forms['orderform'].submit(); return false;">
											</p>
										</td>
									</tr>
								</table>
								
							</td>


						</tr>


					</table>
				</td>
			</tr>
		</table>
	</div>
<script type="text/javascript">
function _submitOrder(){
          document.getElementById("orderform").submit();
}
</script>


	<jsp:include page="foot.jsp" />


</body>
</html>
