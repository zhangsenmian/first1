<%@ page language="java" pageEncoding="UTF-8"%>
<HTML>
<HEAD>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath}/admin/css/Style.css"
	type="text/css" rel="stylesheet">
<script language="javascript"
	src="${pageContext.request.contextPath}/admin/js/public.js"></script>
<script language="javascript"
	src="${pageContext.request.contextPath}/admin/js/check.js"></script>
<script type="text/javascript">
	//设置类别的默认值
	function setProductCategory(t) {
		var category = document.getElementById("category");

		var ops = category.options;
		for ( var i = 0; i < ops.length; i++) {

			if (ops[i].value == t) {
				ops[i].selected = true;
				return;
			}
		}

	};
	
</script>
</HEAD>
<body  onload="setProductCategory('${shop.category}')">
	<form id="userAction_save_do" name="Form1"
		action="${pageContext.request.contextPath }/servlet/EditShopServlet" method="post"
		 enctype="multipart/form-data">
		<input type="hidden"
					name="id"  value="${shop.id }" />
<!--	enctype="multipart/form-data"  --><!--   图片加上-->
<table cellSpacing="1" cellPadding="5" width="100%" align="center"
			bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
			<tr>
				<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
					height="26"><strong><STRONG>编辑商店</STRONG> </strong></td>
			</tr>


			<tr>
				<td align="center" bgColor="#f5fafe" class="ta_01">商店名称：</td>
				<td class="ta_01" bgColor="#ffffff"><input type="text"
					name="name" class="bg" value="${shop.name }" /></td>
				<td align="center" bgColor="#f5fafe" class="ta_01">商店起送价格：</td>
				<td class="ta_01" bgColor="#ffffff"><input type="text"
					name="startprice" class="bg" value="${shop.startprice }" /></td>
			</tr>
			<tr>
				
				<td align="center" bgColor="#f5fafe" class="ta_01">商店类别：</td>
				<td class="ta_01" bgColor="#ffffff"><select name="category"
					id="category">
						<option value="" selected="selected">--选择商店类别--</option>
						<option value="美食">美食</option>
						<option value="正餐优选">正餐优选</option>
						<option value="超市">超市</option>					
						<option value="精选小吃">精选小吃</option>
						<option value="鲜果购">鲜果购</option>
						<option value="下午茶">下午茶</option>
				</select></td>
			</tr>


			<tr>
				<td align="center" bgColor="#f5fafe" class="ta_01">商店图片：</td>
				<td class="ta_01" bgColor="#ffffff" colSpan="3"><input
					type="file" name="upload" size="30" value="" /></td>
			</tr>
			
			<TR>
				<td align="center" colSpan="4" class="sep1"><img
					src="${pageContext.request.contextPath}/admin/images/shim.gif">
				</td>
			</TR>


			<tr>
				<td class="ta_01" style="WIDTH: 100%" align="center"
					bgColor="#f5fafe" colSpan="4"><input type="submit"
					class="button_ok" value="确定"> <FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>



					<input type="reset" value="重置" class="button_cancel"> <FONT
					face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT> <INPUT
					class="button_ok" type="button" onclick="history.go(-1)" value="返回" />
					<span id="Label1"> </span></td>
			</tr>
		</table>
	</form>




</body>
</HTML>