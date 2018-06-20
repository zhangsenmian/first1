package com.meituan.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;

import com.meituan.damian.Order;
import com.meituan.damian.OrderItem;



public class OrderItemDao {
	
	/*public void addOrderItem(Order order) throws SQLException{
		List<OrderItem> orderItems = order.getOrderItems();//
		QueryRunner qr = new QueryRunner();
		Object[][] params = new Object[orderItems.size()][];
		
		for (int i = 0; i < params.length; i++) {
			
			params[i] = new Object[]{order.getId(),orderItems.get(i).getFood().getFid(),orderItems.get(i).getBuynum()};
		}
		qr.batch("INSERT INTO orderitem VALUES(?,?,?)", params );
	}*/
}
