package com.meituan.service;

import java.sql.SQLException;
import java.util.List;

import com.meituan.damian.Food;
import com.meituan.damian.Order;
import com.meituan.dao.FoodDao;
import com.meituan.dao.OrderDao;
import com.meituan.dao.OrderItemDao;


public class OrderService {
	
	OrderDao orderDao = new OrderDao();
	OrderItemDao orderItemDao = new OrderItemDao();
	FoodDao foodDao = new FoodDao();
	
	public void addOrder(Order order){
		try {
			
			orderDao.addOrder(order);
			/*orderItemDao.addOrderItem(order);*/
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
	}
/*
	public List<Order> findOrdersByUserId(int id) {
		try {
			return orderDao.findOrders(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Order findOrdersByOrderId(String orderid) {
		try {
			return orderDao.findOrdersByOrderId(orderid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}*/
}
