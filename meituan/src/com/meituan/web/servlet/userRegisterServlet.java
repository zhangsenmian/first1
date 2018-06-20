package com.meituan.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.meituan.damian.User;
import com.meituan.service.UserService;
import com.meituan.util.UUIDUtil;



public class userRegisterServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
      /*  String ckcode=request.getParameter("ckcode");
        String ckcode_session=(String) request.getSession().getAttribute("checkcode_session");
        if(!ckcode_session.equals(ckcode)){
        	request.setAttribute("ckcode_msg","验证码错误");
        	request.getRequestDispatcher("/register.jsp").forward(request, response);
        	return;
        }*/ 
		//1.设置字符编码
		request.setCharacterEncoding("utf-8");
		//2.获取数据
		User user = new User();
		boolean flag = false;
		try {
			BeanUtils.populate(user, request.getParameterMap());
			user.setId(UUIDUtil.getUUID());
			//3.调用模型
			UserService us = new UserService();
			flag = us.regist(user);
			if(flag){
				//注册成功
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}else{
				//注册失败
				request.getRequestDispatcher("/register.jsp").forward(request, response);
			}
		}catch (Exception e) {
			e.printStackTrace();
		} 
	}
      
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	public void init() throws ServletException {
		// Put your code here
	}

}
