package com.meituan.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.mchange.v2.beans.BeansUtils;
import com.meituan.damian.Business;
import com.meituan.service.BusinessSerice;

/**
 * Servlet implementation class BusinessLoginServlet
 */
public class BusinessLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取数据
		request.setCharacterEncoding("utf-8");
		
		Business bs = new Business();
		try {
			BeanUtils.populate(bs, request.getParameterMap());
			//调用模型
			BusinessSerice bSerice = new BusinessSerice();
			bs = bSerice.checkName(bs);
			
			if(bs!=null){
				request.getSession().setAttribute("shop_id", bs.getShop_id());
				request.getSession().setAttribute("shop_name", bs.getBusiness_shopname());
				request.getRequestDispatcher("/businessadmin/login/home.jsp").forward(request, response);
			}else{
				request.getRequestDispatcher("/adminlogin.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
