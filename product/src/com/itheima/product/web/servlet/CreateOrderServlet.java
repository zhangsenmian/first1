package com.itheima.product.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.itheima.product.domain.Order;
import com.itheima.product.domain.OrderItem;
import com.itheima.product.domain.Product;
import com.itheima.product.domain.User;
import com.itheima.product.service.OrderService;

public class CreateOrderServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1����װOrder����
		Order order = new Order();
		try {
			BeanUtils.populate(order, request.getParameterMap());
			order.setId(UUID.randomUUID().toString());
			order.setUser((User)request.getSession().getAttribute("user"));//��session�����е��û���Ϣ���浽order������
		} catch (Exception e) {
			e.printStackTrace();
		}
		//2����ȡsession�����еĹ��ﳵ����
		Map<Product, String> cart = (Map<Product, String>) request.getSession().getAttribute("cart");
		
		//3���������ﳵ�е����ݣ���ӵ�orderItem�����У�ͬʱ�Ѷ��orderItem��ӵ�list������
		List<OrderItem> list = new ArrayList<OrderItem>();
		for (Product p : cart.keySet()) {
			OrderItem oi = new OrderItem();
			oi.setOrder(order);//��Order������ӵ�OrderItem��
			oi.setP(p);   //�ѹ��ﳵ�е���Ʒ������ӵ�OrderItem��
			oi.setBuynum(Integer.parseInt(cart.get(p)));//���ﳵ�е���Ʒ����
			
			list.add(oi);//��ÿ����������ӵ�������
		}
		
		//4���Ѽ��Ϸ��뵽Order���� ��
		order.setOrderItems(list);
		
		//���� ҵ���߼�
		OrderService os = new OrderService();
		os.addOrder(order);
		
		//
		request.getRequestDispatcher("/pay.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
