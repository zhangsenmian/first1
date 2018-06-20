package com.meituan.service;

import java.sql.SQLException;
import java.util.List;

import com.meituan.damian.PageBean;
import com.meituan.damian.Shop;
import com.meituan.dao.ShopDao;


public class ShopService {
  ShopDao shopDao=new ShopDao();
   public List<Shop> findAllShops(){
	   try {
		return shopDao.findAllShops();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
   }
   
  public void addShop(Shop shop){
	   try {
		shopDao.addShop(shop);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
   
    public Shop findShopById(String id){
	  try {
		return shopDao.findShopById(id);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
   }
    
   public void updateShop(Shop shop) {
		try {
			shopDao.updateShop(shop);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
   
   public void deleteShop(String id){
	   try {
		shopDao.deleteShop(id);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
   
   public List<Shop>  searchShop(String id,String category,String name,String minprice,String maxprice){
	   try {
		return shopDao.searchShop(id,category,name,minprice,maxprice);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
   }
   
   public List<Object> searchShopByName(String name){
	   try {
		return shopDao.searchShopByName(name);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
   }
   
   public PageBean searchAllShopByName(int currentPage,int pageSize,String name){
	   try {
			int count=shopDao.count2(name);
			int totalPage=(int) Math.ceil(count*1.0/pageSize);
			List<Shop> list=shopDao.searchAllShopByName(currentPage, pageSize, name);
			System.out.println(list);
			PageBean pb=new PageBean();
			pb.setShops(list);
			pb.setCount(count);
			pb.setCurrentPage(currentPage);
			pb.setPageSize(pageSize);
			pb.setTotalPage(totalPage);
			return pb;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
   }
  /* public PageBean findShopsPage(int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		try {
			int count=shopDao.count();
			int totalPage=(int) Math.ceil(count*1.0/pageSize);
			List<Shop> list=shopDao.findShopsPage(currentPage, pageSize);
			PageBean pb=new PageBean();
			pb.setShops(list);
			pb.setCount(count);
			pb.setCurrentPage(currentPage);
			pb.setPageSize(pageSize);
			pb.setTotalPage(totalPage);
			return pb;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}*/
   public PageBean findShopsPage(int currentPage, int pageSize,String category) {
		// TODO Auto-generated method stub
		try {
			int count=shopDao.count(category);
			int totalPage=(int) Math.ceil(count*1.0/pageSize);
			List<Shop> list=shopDao.findShopsPage(currentPage, pageSize,category);
			PageBean pb=new PageBean();
			pb.setShops(list);
			pb.setCount(count);
			pb.setCurrentPage(currentPage);
			pb.setPageSize(pageSize);
			pb.setTotalPage(totalPage);
			return pb;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
   }
   
   public List<Shop> findCategory(String category){
	   try {
		shopDao.findCategory(category);
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
	   
   }
   
   public List<Shop> findShopsByName(String name){
	   try {
		return shopDao.findShopsByName(name);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
   }
   /*
   public void delAllShops(String[] ids){
	   try {
		ShopDao.delAllShops(ids);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
   
   
   


   
public List<Object> findShopsName(String name){
	try {
		return ShopDao.findShopsName(name);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
}
*/
}
