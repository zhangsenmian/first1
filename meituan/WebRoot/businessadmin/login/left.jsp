<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>菜单</title>
<link href="${pageContext.request.contextPath}/businessadmin/css/left.css" rel="stylesheet" type="text/css">
</head>
<body>
<table width="100" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="12"></td>
  </tr>
</table>
<table width="100%" border="0">
  <tr>
    <td>
<div class="dtree">

	<a href="javascript: d.openAll();">展开所有</a> | <a href="javascript: d.closeAll();">关闭所有</a>
	<link rel="StyleSheet" href="${pageContext.request.contextPath}/businessadmin/css/dtree.css" type="text/css" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/businessadmin/js/dtree.js"></script>
	<script type="text/javascript">
		<!--
		d = new dTree('d');
		d.add(0,-1,'系统菜单树');
		d.add(1,0,'商品管理','/meituan/businessadmin/login/welcome.jsp','','mainFrame');
		d.add(2,0,'商品管理','/meituan/businessadmin/login/welcome.jsp','','mainFrame');
		d.add(3,0,'订单管理','/meituan/businessadmin/login/welcome.jsp','','mainFrame');
		d.add(11,2,'商品查看','${pageContext.request.contextPath }/FindFoodBusByIdServlet?id=${shop_id }','','mainFrame');
		d.add(11,1,'商店完善','/meituan/businessadmin/food/businessshopedit.jsp','','mainFrame');
		//子目录添加
		/* d.add(11,1,'商店查看','${pageContext.request.contextPath}/servlet/FindAllShopsServlet','','mainFrame');
		
		d.add(12,1,'销售榜单','/meituan/businessadmin/products/download.jsp','','mainFrame')
		
		d.add(21,2,'订单查看','/meituan/businessadmin/orders/list.jsp','','mainFrame'); */
	
		
		document.write(d);
		//-->
	</script>
</div>	</td>
  </tr>
</table>
</body>
</html>
