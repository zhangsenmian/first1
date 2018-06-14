package com.meituan.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meituan.damian.PageBean;
import com.meituan.service.ShopService;

public class ShopsPageServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	int pageSize = 16;
		
		int currentPage = 1;
		//String category="精选小吃";
		
		 String category=request.getParameter("category");
		 if(category==null){
				category="";
			}
		if(category.equals("1")){
			
			category="美食";
		}
		if(category.equals("2")){
			category="超市";
		}
		if(category.equals("3")){
			category="鲜果购";
		}
		if(category.equals("4")){
			category="精选小吃";
		}
		if(category.equals("5")){
			category="下午茶";
		}
	//	category = new String(category.getBytes("iso-8859-1"),"UTF-8");
		//	美食	超市	精选小吃	鲜果购	下午茶
	
		
		String currPage = request.getParameter("currentPage");
		if(currPage!=null&&!"".equals(currPage)){
			currentPage = Integer.parseInt(currPage);
		}
		
		ShopService ss = new ShopService();
		
		PageBean pb = ss.findShopsPage(currentPage,pageSize,category);
		
		
		request.setAttribute("pb", pb);
		request.setAttribute("cat", category);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
