package com.meituan.service;

import java.util.List;

import com.meituan.damian.Business;
import com.meituan.damian.User;
import com.meituan.dao.BusinessDao;

public class BusinessSerice {
	BusinessDao bdBusinessDao = new BusinessDao();
	public void regist(Business business) throws Exception {
		bdBusinessDao.regist(business);
	}
	public Business  checkName(Business bs) throws Exception {

		return bdBusinessDao.checkName(bs);
		
	}
	public String checkRegister(String username) throws Exception {
		List<Business> list = bdBusinessDao.checkRegister(username);
		String e = null;
		for(Business user1 : list){
			e = user1.getBusiness_name();
		}
		return e;
	}

}
