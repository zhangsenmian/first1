package com.meituan.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meituan.damian.User;
import com.meituan.exception.UserException;
import com.meituan.service.UserService;

public class LoginServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	String username=request.getParameter("username");
	String password=request.getParameter("password");
	UserService us = new UserService();
	User user;
	try {
		user = us.findUserByUsernamePassword(username, password);
		String path="/index.jsp";
		if("admin".equals(user.getUsername())){
			path="/admin/login/home.jsp";
		}
		request.getSession().setAttribute("user", user);
		request.getRequestDispatcher(path).forward(request, response);
		
	} catch (UserException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		request.setAttribute("login_msg",e.getMessage());
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}
	
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
