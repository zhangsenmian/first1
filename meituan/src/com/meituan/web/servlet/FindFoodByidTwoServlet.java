package com.meituan.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meituan.damian.Food;
import com.meituan.service.FoodService;

/**
 * Servlet implementation class FindFoodByidTwoServlet
 */
public class FindFoodByidTwoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindFoodByidTwoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=(String) request.getAttribute("id");
		
		
		FoodService ss = new FoodService();
		List<Food> list = ss.findFoodByid(id);
		
	
		if(list!=null){
			 System.out.println(list);
			 request.getSession().setAttribute("shopid", id);
			request.setAttribute("Foods", list);
			
			request.getRequestDispatcher("/admin/food/list.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
