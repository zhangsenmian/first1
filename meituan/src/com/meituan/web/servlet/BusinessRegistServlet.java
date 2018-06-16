package com.meituan.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.meituan.damian.Business;
import com.meituan.damian.Shop;
import com.meituan.service.BusinessSerice;
import com.meituan.service.BusinessShopService;
import com.meituan.util.UUIDUtil;

/**
 * Servlet implementation class BusinessRegistServlet
 */
public class BusinessRegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Business business = new Business();
		Shop shop = new Shop();
		try {
			//获取商家数据：
			BeanUtils.populate(business, request.getParameterMap());
			//设置商家id号
			String business_id =  UUIDUtil.getUUID();
			business.setBusiness_id(business_id);
			shop.setBusiness_id(business_id);
			//设置商店id号
			String shop_id = UUIDUtil.getUUID();
			shop.setId(shop_id);
			business.setShop_id(shop_id);
			String shopname = request.getParameter("business_shopname");
			shop.setName(shopname);
			BusinessShopService bShopService = new BusinessShopService();
			BusinessSerice bSerice = new BusinessSerice();
			bSerice.regist(business);
			bShopService.regist(shop.getId(),shop.getName());
			request.getRequestDispatcher("/registersuccess.jsp").forward(request, response);
			//request.getRequestDispatcher("/adminlogin").forward(request, response);
		} catch (Exception e) {
			request.getRequestDispatcher("/adminlogin").forward(request, response);
			e.printStackTrace();
		}
			
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
