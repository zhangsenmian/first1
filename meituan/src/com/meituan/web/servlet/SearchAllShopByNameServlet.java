package com.meituan.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meituan.damian.PageBean;
import com.meituan.damian.Shop;
import com.meituan.service.ShopService;

public class SearchAllShopByNameServlet extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public SearchAllShopByNameServlet() {
		super();
	}

	/**
		 * Destruction of the servlet. <br>
		 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
		 * The doGet method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to get.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
int pageSize = 16;
		
		int currentPage = 1;

		 String name=request.getParameter("name");		
	//	category = new String(category.getBytes("iso-8859-1"),"UTF-8");
		String currPage = request.getParameter("currentPage");
		if(currPage!=null&&!"".equals(currPage)){
			currentPage = Integer.parseInt(currPage);
		}
		
		ShopService ss = new ShopService();
		PageBean pb = ss.searchAllShopByName(currentPage, pageSize, name);
		request.setAttribute("pb", pb);
		request.setAttribute("cat", name);
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
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
