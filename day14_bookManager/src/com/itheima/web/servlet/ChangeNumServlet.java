package com.itheima.web.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itheima.domain.Book;
import com.itheima.service.BookServiceImpl;

public class ChangeNumServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String num = request.getParameter("num");
		//ע��ֻ����дid��hashcode
		Book b = new Book();
		b.setId(id);
		
		HttpSession session = request.getSession();
		Map<Book, String> cart = (Map<Book, String>) session.getAttribute("cart");
		//�����Ʒ����Ϊ0����ɾ������
		if("0".equals(num)){
			cart.remove(b);
		}
		//�ж�����ҵ���id��ͬ���飬
		if(cart.containsKey(b)){
			cart.put(b, num);
		}
		
		response.sendRedirect(request.getContextPath()+"/cart.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
