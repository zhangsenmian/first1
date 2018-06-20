package com.meituan.dao;

import java.sql.SQLException;
import java.util.Date;

import org.apache.commons.dbutils.QueryRunner;

import com.meituan.damian.Order;
import com.meituan.util.C3P0Util;



public class OrderDao {
	
	public void addOrder(Order order) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		qr.update(
				"INSERT INTO orders VALUES(?,?,?,?,?,?,?,?)", order.getId(),
				order.getMoney(), order.getReceiverAddress(), order
						.getReceiverName(), order.getReceiverPhone(), order
						.getState(), 
						new Date(),order.getUseid());
	}

	
/*	public List<Order> findOrders(int id) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return qr.query("select * from orders where user_id=?",
				new BeanListHandler<Order>(Order.class), id);
	}

	//��ѯָ���û��Ķ�����Ϣ
	public Order findOrdersByOrderId(String orderid) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		//�õ�һ������
		Order order = qr.query("select * from orders where id=?", new BeanHandler<Order>(Order.class),orderid);
		//�õ���ǰ�����е����ж�����
		//List<OrderItem> orderItems = qr.query("select * from orderItem where order_id=? ", new  BeanListHandler<OrderItem>(OrderItem.class),orderid);
		//�õ����ж������е���Ʒ��Ϣ
		//List<Product> products = qr.query("select * from products where id in(select product_id from orderitem where order_id=?)", new BeanListHandler<Product>(Product.class),orderid);
		
		List<OrderItem>  orderItems = qr.query("SELECT * FROM orderitem o,products p WHERE p.id=o.product_id AND order_id=?", new ResultSetHandler<List<OrderItem>>(){

			public List<OrderItem> handle(ResultSet rs) throws SQLException {
				List<OrderItem> orderItems = new ArrayList<OrderItem>();
				while(rs.next()){
					
					//��װOrderItem����
					OrderItem oi = new OrderItem();
					oi.setBuynum(rs.getInt("buynum"));
					//��װProduct����
					Product p = new Product();
					p.setName(rs.getString("name"));
					p.setPrice(rs.getDouble("price"));
					//��ÿ��p�����װ��OrderItem������
					oi.setP(p);
					//��ÿ��OrderItem�����װ��������
					orderItems.add(oi);
				}
				return orderItems;
			}
			
		},orderid);
		
		//�����еĶ�����orderItems��ӵ���������Order��
		order.setOrderItems(orderItems);
		
		return order;
	}*/
}
