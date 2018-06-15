package com.meituan.service;

import java.sql.SQLException;
import java.util.List;

import com.meituan.damian.User;
import com.meituan.dao.UserDao;
import com.meituan.exception.UserException;

public class UserService {
	UserDao ud = new UserDao();
	
	public boolean regist(User user) throws UserException {
		try {
			int i =0;
			i = ud.addUser(user);
			if(i==1){
				return true;
			}else{
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new UserException("注册失败");
		}
	}
	 public User findUserByUsernamePassword(String username,String password) throws UserException{
		 User user = new User();
		 try {
			 user= ud.findUserByUsernamePassword(username,password);
			if(user==null){
				throw new UserException("用户名或密码错误");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new UserException("用户名或密码错误");
		}
		return user;
	 }
	public boolean checkLogin(User user) throws Exception {
		List<User> list = ud.checkLogin(user);
		String username = null;
		for(User user1 : list){
			username = user1.getUsername();
		}
		if(username !=null){
			return true;
		}else{
			return false;
		}
		
	}
	public String checkEmail(String email) throws SQLException {
		List<User> list = ud.checkEmail(email);
		String e = null;
		for(User user1 : list){
			e = user1.getEmail();
		}
		return e;
	}
	public String checkUserName(String username) throws Exception {
		List<User> list = ud.checkUserName(username);
		String e = null;
		for(User user1 : list){
			e = user1.getUsername();
		}
		return e;
	}
}
