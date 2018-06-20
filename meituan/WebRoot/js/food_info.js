$(function(){
	//为购物车添加显示和隐藏
	$(".cart-footer").click(function(){
		var list = $(".order-list");
		if(list.hasClass("showCart")==true){
			list.removeClass("showCart").addClass("hideCart");
		}else{
			list.removeClass("hideCart").addClass("showCart");
		}				
	});
	
	/*$(document).ready(function(){
	
		$(".addfood").click(function(){
			$(this).siblings("span").css("display","inline-block");
			var n = $(this).siblings("span").text();
			var num = parseInt(n)+1;
			if(num == 0){
				return;
			}
			$(this).siblings("span").html(num);
		});
	});
	*/
	
	//点击添加菜品到购物车
	$(".addfood").click(function(){
		//改变点菜的数量
		var foodNumber = alterFoodCount($(this),true);
		//加入购物车并显示
		var DBFoodId = alterCartContent($(this),foodNumber);
		//发送数据到后台并放入session
		//location.href="cartFood?fid="+$(this).attr('id');
		
		$.ajax({
	        url:'cartFood?fid='+$(this).attr('id'),
	        type:"post",
	        data:{"fid":$(this).attr("id")},
	        dataType:"json",
	        success: function(data) {
	        	
            },
	        error: function(XMLHttpRequest, textStatus, errorThrown) {
	            alert(XMLHttpRequest.status);
	            alert(XMLHttpRequest.readyState);
	            alert(textStatus);
	        }
	    });
	});
	
	
	
	//改变点菜的数量
	function alterFoodCount(addbuttun,isAdd){
		var showNumber = addbuttun.siblings(".addnum");
		var number = parseInt(showNumber.text());
		if(isAdd==true){
			number++;
			showNumber.text(number);
			if(number>0){
				showNumber.show();
			}
		}else{
			number--;
			showNumber.text(number);
			if(number==0){
				$(".addnum").css("display","none");
				
			}
		}
		return number;
	}
	
	
	
	
	//加入购物车并显示
		function alterCartContent(buttumItem,foodNumber){
			if(foodNumber==0){
				alert();
			}
			var foodId = buttumItem.attr("id");
			var dbFoodId = foodId;
			var foodPri = buttumItem.parent().siblings(".price2").children().text();
			var cartFoodId = "#cart-"+foodId;
			if(($(cartFoodId).length)>0){
				$(cartFoodId).find(".txt-count").val(foodNumber);
			}else{
				var foodTitle = buttumItem.parent().parent().siblings(".name").children().text();
				var newStr = "<li class='clearfix' id='cart-"+foodId+"' ><div class='fl foodName clearfix' title='"+foodTitle+"'>"+foodTitle+
				"</div><div class='fl modify clearfix'><a href='javascript:;' class='fl minus'>-</a>"+    
				"<input type='text' class='fl txt-count' value='"+foodNumber+" ' maxlength='2'>"+   
  
				"<a href='javascript:;' class='fl plus'>+</a></div>"+ 
				"<div class='fr pri '><span>"+ foodPri+"</span></div></li>";
				$(".shopping-cart ul").append(newStr);
				$(".shopping-cart").trigger("create");
				//通过购物车添加商品数量
				$("body").on("click",".plus",function(){
					var cartFoodId = $(this).closest("li").attr("id");
					var foodId = cartFoodId.substring(5);
					var foodNumber = alterFoodCount($("#"+foodId),true);
					var DBFoodId = alterCartContent($("#"+foodId),foodNumber);
				});
				//通过购物车减少商品数量
				$("body").on("click",".minus",function (){
					var cartFoodId = $(this).closest("li").attr("id");
					var foodId = cartFoodId.substring(5);
					var foodNumber = alterFoodCount($("#"+foodId),false);
					var DBFoodId = alterCartContent($("#"+foodId),foodNumber);
				});
				//通过输入框修改商品数量
				$("body").on("blur",".txt-count",function(){
					if($(this).val().trim()==""){
						alert("输入错误");
						return;
					}
					var cartFoodId = $(this).closest("li").attr("id");
					var foodId = cartFoodId;
					$("#"+foodId).siblings("span").text($(this).val());
					
					var DBFoodId = foodId;
				});

			}
			
			return dbFoodId;
			
		}
		
	
});


