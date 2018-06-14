package com.meituan.service;

import java.sql.SQLException;
import java.util.List;

import com.meituan.damian.PageBean;
import com.meituan.damian.Food;
import com.meituan.dao.FoodDao;


public class FoodService {
  FoodDao foodDao=new FoodDao();
  
  public List<Food> findFoodByid(String id){
	  try {
		return foodDao.findFoodByid(id);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
  }
  
  public void addFood(Food food){
	   try {
		foodDao.addFood(food);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
   /*public List<Food> findAllFoods(){
	   try {
		return FoodDao.findAllFoods();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
   }
   
 
   
    public Food findFoodById(String id){
	  try {
		return FoodDao.findFoodById(id);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
   }
    
   public void updateFood(Food Food) {
		try {
			FoodDao.updateFood(Food);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
   
   public void deleteFood(String id){
	   try {
		FoodDao.deleteFood(id);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
   
   public List<Food>  searchFood(String id,String category,String name,String minprice,String maxprice){
	   try {
		return FoodDao.searchFood(id,category,name,minprice,maxprice);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
   }*/
   
  /* public PageBean findFoodsPage(int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		try {
			int count=FoodDao.count();
			int totalPage=(int) Math.ceil(count*1.0/pageSize);
			List<Food> list=FoodDao.findFoodsPage(currentPage, pageSize);
			PageBean pb=new PageBean();
			pb.setFoods(list);
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
/*   public PageBean findFoodsPage(int currentPage, int pageSize,String category) {
		// TODO Auto-generated method stub
		try {
			int count=FoodDao.count(category);
			int totalPage=(int) Math.ceil(count*1.0/pageSize);
			List<Food> list=FoodDao.findFoodsPage(currentPage, pageSize,category);
			PageBean pb=new PageBean();
			pb.setFoods(list);
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
   
   public List<Food> findCategory(String category){
	   try {
		FoodDao.findCategory(category);
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
	   
   }
   
   public List<Food> findFoodsByName(String name){
	   try {
		return FoodDao.findFoodsByName(name);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
   }*/
   /*
   public void delAllFoods(String[] ids){
	   try {
		FoodDao.delAllFoods(ids);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
   
   
   


   
public List<Object> findFoodsName(String name){
	try {
		return FoodDao.findFoodsName(name);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
}
*/
}
