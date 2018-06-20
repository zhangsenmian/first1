package com.meituan.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.meituan.damian.Food;
import com.meituan.service.FoodService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class cartFood
 */
public class cartFood extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//获取id中的foods信息
		JSONObject json1 = new JSONObject();
		String fid = request.getParameter("fid");
		PrintWriter out = response.getWriter();
		FoodService fService = new FoodService();
		Food food = fService.findFoodByMyId(fid);
		HttpSession session = request.getSession();
		Map<Food, String> cart = (Map<Food, String>) session.getAttribute("cart");
		int num =1;
		if(cart==null){
			cart=new HashMap<Food, String>();
		}
		if(cart.containsKey(food)){
			num=Integer.parseInt(cart.get(food))+1;
		}
		cart.put(food, num+"");
		session.setAttribute("cart", cart);
		json1.put("flag", "true");
		JSONArray jsonArray = new JSONArray();
		jsonArray.add(json1);
		out.println(jsonArray);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
