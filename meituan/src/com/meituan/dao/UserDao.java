package com.meituan.dao;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;



import com.meituan.damian.User;
import com.meituan.util.C3P0Util;


public class UserDao {

	public void addUser(User user) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		String sql = "INSERT INTO USER(username,PASSWORD,gender,email,telephone,introduce,registTime) "
				+ "VALUES(?,?,?,?,?,?,?)";
		
		qr.update(sql, user.getUsername(), user.getPassword(),
				user.getGender(), user.getEmail(), user.getTelephone(),
				user.getIntroduce(),user.getRegistTime());
	}

    public User findUserByUsernamePassword(String username,String password) throws SQLException{
    	QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
    	
    	return  qr.query("select * from user where username = ? and PASSWORD = ?",new BeanHandler<User>(User.class),username,password);
    	
    	
    }
}
