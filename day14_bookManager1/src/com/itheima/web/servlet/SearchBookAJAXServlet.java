package com.itheima.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.domain.Book;
import com.itheima.service.BookServiceImpl;

public class SearchBookAJAXServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");//ֻ�ܽ��post��ʽ������
		response.setContentType("text/html;charset=UTF-8");
		
		String name = request.getParameter("name");
		name = new String(name.getBytes("iso-8859-1"),"UTF-8");
		BookServiceImpl bs = new BookServiceImpl();
		List<Object> list = bs.searchBookByName(name);
		
		//�Ѽ����е�����ת��Ϊ�ַ������ص���ҳ
		String str = "";
		for (int i = 0; i < list.size(); i++) {
			if(i>0){
				str+=",";
			}
			str+=list.get(i);
		}
		
		System.out.println(str);
		//��������Ӧ���ͻ���
		response.getWriter().write(str);//str 1001,1002,1003
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
