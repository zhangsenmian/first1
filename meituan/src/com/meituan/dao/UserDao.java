package com.meituan.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.meituan.damian.User;
import com.meituan.util.C3P0Util;


public class UserDao {

	public int addUser(User user) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		String sql = "INSERT INTO USER(id,username,PASSWORD,gender,email,telephone,introduce,registTime) "
				+ "VALUES(?,?,?,?,?,?,?,?)";
		
		return qr.update(sql, user.getId(),user.getUsername(), user.getPassword(),
				user.getGender(), user.getEmail(), user.getTelephone(),
				user.getIntroduce(),user.getRegistTime());
	}

    public User findUserByUsernamePassword(String username,String password) throws SQLException{
    	QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
    	
    	return  qr.query("select * from user where username = ? and PASSWORD = ?",new BeanHandler<User>(User.class),username,password);
    	
    	
    }

	public  List<User> checkLogin(User user) throws Exception {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
    	return  qr.query("select * from user where username = ? and PASSWORD = ?",new BeanListHandler<User>(User.class),user.getUsername(),user.getPassword());
	}

	public List<User> checkEmail(String email) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
    	return  qr.query("select * from user where email = ?",new BeanListHandler<User>(User.class),email);
	}

	public List<User> checkUserName(String username) throws Exception {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
    	return  qr.query("select * from user where username = ?",new BeanListHandler<User>(User.class),username);
	}
}
