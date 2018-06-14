package com.meituan.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.meituan.damian.Business;
import com.meituan.util.C3P0Util;

public class BusinessDao {

	public void regist(Business business) throws SQLException {
		QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
    	qr.update("insert into business values(?,?,?,?,?)", business.getBusiness_id(), business.getBusiness_name(),business.getBusiness_password(),business.getBusiness_shopname(),business.getShop_id());
	}

	public List<Business> checkName(Business bs) throws Exception {
		QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
		return qr.query("select shop_id from business where business_name =? and business_password = ?",new BeanListHandler<Business>(Business.class),bs.getBusiness_name(),bs.getBusiness_password());
		
	}

	public List<Business> checkRegister(String username) throws Exception {
		QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
		return qr.query("select * from business where business_name =?",new BeanListHandler<Business>(Business.class),username);
	}

}
