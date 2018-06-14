package com.meituan.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meituan.service.UserService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class JSONServlet
 */
public class JSONServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置字符编码
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		//获取数据
		String email = request.getParameter("email");
		String  flag = null;
		//调用模型
		UserService userService = new UserService();
		try {
			flag = userService.checkEmail(email);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONObject json1 = new JSONObject();
		
		if(flag == null){
			json1.put("email", "true");
		}else{
			json1.put("email", "false");
		}
		JSONArray jsonArray = new JSONArray();
		jsonArray.add(json1);
		out.println(jsonArray);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
