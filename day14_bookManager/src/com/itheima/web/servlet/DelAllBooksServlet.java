package com.itheima.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.service.BookServiceImpl;

public class DelAllBooksServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//�õ�����id
		String[] ids = request.getParameterValues("ids");
		
		String path = request.getRemoteAddr();
		System.out.println(path+"�ұ�֤�������㣡");
		
		//����ɾ��ҵ��
		BookServiceImpl bs = new BookServiceImpl();
		bs.deleAllBooks(ids);
		
		request.getRequestDispatcher("bookListServlet").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
