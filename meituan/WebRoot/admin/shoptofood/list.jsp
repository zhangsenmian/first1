<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<HTML>
<HEAD>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/admin/css/Style.css"
	rel="stylesheet" type="text/css" />
<script language="javascript"
	src="${pageContext.request.contextPath}/admin/js/public.js"></script>
<script type="text/javascript">
	function addProduct() {
		window.location.href = "${pageContext.request.contextPath}/admin/food/add.jsp";
	}
	
	function delbook(id,name){
	  if(confirm("是否确定删除<<"+name+">>吗?")){
	    location.href="${pageContext.request.contextPath}/servlet/DelShopServlet?id="+id; 
	  }
	}
</script>
</HEAD>
<body>
	<br>
	<form id="Form1" name="Form1"
		action="${pageContext.request.contextPath}/servlet/SearchShopServlet"
		method="post"  >
		<table cellSpacing="1" cellPadding="0" width="100%" align="center"
			bgColor="#f5fafe" border="0">
			<TBODY>
				
				<tr>
					<td>
					
					</td>

				</tr>
				<tr>
					<td class="ta_01" align="center" bgColor="#05C0A1"><strong>商店列表</strong>
					</TD>
				</tr>
				<tr>
					<td class="ta_01" align="right">
						
					</td>
				</tr>
				<tr>
					<td class="ta_01" align="center" bgColor="#f5fafe">
						<table cellspacing="0" cellpadding="1" rules="all"
							bordercolor="gray" border="1" id="DataGrid1"
							style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
							<tr
								style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #05C0A1">
								<td align="center" width="24%">商店编号</td>
								<td align="center" width="18%">商店名称</td>
								<td width="8%" align="center">商品管理</td>
								
							</tr>
                        
							<c:forEach items="${shops }" var="b">
		
								<tr onmouseover="this.style.backgroundColor = 'white'"
									onmouseout="this.style.backgroundColor = '#F5FAFE';">
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="13%">${b.id }</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="18%">${b.name }</td>
									
										
									<td align="center" style="HEIGHT: 22px" width="13%"><a
										href="${pageContext.request.contextPath }/FindFoodByid?id=${b.id }">
											<img
											src="${pageContext.request.contextPath}/admin/images/i_edit.gif"
											border="0" style="CURSOR: hand"> </a>
									</td>
									
									
								</tr>
							</c:forEach>
						</table>
					</td>
				</tr>
			</TBODY>
		</table>
	</form>
</body>
</HTML>

