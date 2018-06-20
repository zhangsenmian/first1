package com.meituan.dao;

import java.sql.SQLException;
import java.util.List;



import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.meituan.damian.Shop;
import com.meituan.damian.User;
import com.meituan.damian.User;
import com.meituan.util.C3P0Util;


public class UserDao {

	public int addUser(User user) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		String sql = "INSERT INTO USER(id,username,PASSWORD,email,telephone) "
				+ "VALUES(?,?,?,?,?)";
		
		return qr.update(sql, user.getId(),user.getUsername(), user.getPassword(),
				user.getEmail(), user.getTelephone()
				);
	}

    public User findUserByUsernamePassword(String username,String password) throws SQLException{
    	QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
    	
    	return  qr.query("select * from user where username = ? and PASSWORD = ?",new BeanHandler<User>(User.class),username,password);
    	
    	
    }
    
    public List<User> findAllUser() throws SQLException{
    	QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
    	return qr.query("select * from user", new BeanListHandler<User>(User.class));
    	
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
	
	 public List<User> findAllUsers() throws SQLException{
	    	QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
	    	return qr.query("select * from User", new BeanListHandler<User>(User.class));
	    	
	    }
	    
	   
	    
	    public User findUserById(String id)throws SQLException{
	    	QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
	    	return qr.query("select * from User where id=?", new BeanHandler<User>(User.class),id);
	    }
	   /* 
	    public void updateUser(User User) throws SQLException {
			QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
			qr.update("update User set name=?,startprice=?,category=?,img_url=? where id=?",
					User.getName(),User.getStartprice(),User.getCategory(),User.getImg_url(),User.getId());
			

		}
	   */
	 
	    public void deleteUser(String id) throws SQLException{
	    	QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
	    	qr.update("delete from User where id =?",id);
	    }
	    
}
