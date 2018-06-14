package com.meituan.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.meituan.damian.User;
import com.meituan.service.UserService;

/**
 * Servlet implementation class UserLoginServlet
 */
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.获取数据
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("mobile");
		String password = request.getParameter("code");
		boolean flag =false;
		//2.调用模型
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		UserService uService = new UserService();
		try {
			flag = uService.checkLogin(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//3.判断并保存session信息
		HttpSession session = request.getSession();
		if(flag){
			//登录成功
			session.setAttribute("login", user);
			request.getRequestDispatcher("/servlet/ShopsPageServlet").forward(request, response);
		}else{
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
