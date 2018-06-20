package com.meituan.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.registry.infomodel.User;

import org.apache.commons.beanutils.BeanUtils;

import com.meituan.damian.Food;
import com.meituan.damian.Order;
import com.meituan.damian.OrderItem;
import com.meituan.service.OrderService;



public class CreateOrderServlet extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public CreateOrderServlet() {
		super();
	}

	/**
		 * Destruction of the servlet. <br>
		 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
		 * The doGet method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to get.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Order order = new Order();
		try {
			BeanUtils.populate(order, request.getParameterMap());
			order.setId(UUID.randomUUID().toString());
			System.out.println(order.getMoney());
		   OrderService os=new OrderService();
			os.addOrder(order);
		} catch (Exception e) {
			e.printStackTrace();
		}
/*		
		Map<Food, String> cart = (Map<Food, String>) request.getSession().getAttribute("cart");
		
		//3、遍历购物车中的数据，添加到orderItem对象中，同时把多个orderItem添加到list集合中
		List<OrderItem> list = new ArrayList<OrderItem>();
		for (Food f : cart.keySet()) {
			OrderItem oi = new OrderItem();
			oi.setOrder(order);//把Order对象添加到OrderItem中
			oi.setFood(f);   //把购物车中的商品对象添加到OrderItem中
			oi.setBuynum(Integer.parseInt(cart.get(f)));//购物车中的商品数量
			
			list.add(oi);//把每个定单项添加到集合中
		}
		
		//4、把集合放入到Order对象 中
		order.setOrderItems(list);
		*/
		//调用 业务逻辑
		

		//
		
		request.getRequestDispatcher("/pay.jsp").forward(request, response);
		
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
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
