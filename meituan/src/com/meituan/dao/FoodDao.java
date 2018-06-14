package com.meituan.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;



import com.meituan.damian.Food;
import com.meituan.util.C3P0Util;



public class FoodDao {
	

   public List<Food> findFoodByid(String id)throws SQLException{
	   QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
	   return qr.query("select * from food where shopid = ?", new BeanListHandler<Food>(Food.class),id);
  }
   
   public List<Food> addFood(Food Food) throws SQLException{
	   	QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
	   	qr.update("insert into Food values(?,?,?,?)",Food.getFid(),Food.getFoodname(),Food.getFoodprice(),Food.getImg_url());
			return null;
	       
	   }
	
	
	/* public List<Food> findAllFoods() throws SQLException{
    	QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
    	return qr.query("select * from Food", new BeanListHandler<Food>(Food.class));
    	
    }
    
    
    
    
    
    
    public void updateFood(Food Food) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		qr.update("update Food set name=?,startprice=?,category=?img_url=?where id=?",
				Food.getName(),Food.getStartprice(),Food.getCategory(),Food.getId(),Food.getImg_url());
		

	}
   
 
    public void deleteFood(String id) throws SQLException{
    	QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
    	qr.update("delete from Food where id =?",id);
    }
    
    public List<Food> searchFood(String id, String category, String name,
			String minprice, String maxprice) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		String sql = "select * from Food where 1=1";
		List list = new ArrayList();
		if(!"".equals(id.trim())){
			sql+=" and id like ?"; // 
			list.add("%"+id.trim()+"%");// 
		}
		
		if(!"".equals(category.trim())){
			sql+=" and category=?";
			list.add(category.trim());
		}
		
		if(!"".equals(name.trim())){
			sql+=" and name like ?";
			list.add("%"+name.trim()+"%");
		}
		
		if(!"".equals(minprice.trim())){
			sql+=" and startprice>?";
			list.add(minprice.trim());
		}
		if(!"".equals(maxprice.trim())){
			sql+=" and startprice< ?";
			list.add(maxprice.trim());
		}
		System.out.print("11111111111111111");
    	System.out.print(sql);    	
    	System.out.print(minprice);
     	System.out.print(list.toArray());
		return qr.query(sql, new BeanListHandler<Food>(Food.class),list.toArray());
     	// qr.query(sql, new BeanListHandler<Food>(Food.class),("%"+id.trim()+"%"),category.trim(),("%"+name.trim()+"%"),minprice.trim(),maxprice.trim());
	}*/
    
    /*public List<Food> findFoodsPage(int currentPage,int pageSize) throws SQLException{
    	QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
    	return qr.query("select * from Food limit ?,?", new BeanListHandler<Food>(Food.class),(currentPage-1)*pageSize,pageSize);
    	
    }*/
    
/*    public List<Food> findFoodsPage(int currentPage,int pageSize,String category) throws SQLException{
    	QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
    	String sql="";
    	
    	if(!"".equals(category)){
    		sql="select * from Food where category =? limit ?,?";
    	   return qr.query(sql, new BeanListHandler<Food>(Food.class),category,(currentPage-1)*pageSize,pageSize);
    	}else{
    		sql="select * from Food limit ?,?";
    		return qr.query(sql, new BeanListHandler<Food>(Food.class),(currentPage-1)*pageSize,pageSize);
    	}
    }

	public int count(String category) throws SQLException {
		QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
		long l;
    	
    	if(!"".equals(category)){
    		l = (Long) qr.query("select count(*) from Food  where category = ?",new ScalarHandler(1),category);
			return (int)l;
    	}else{
    		l = (Long) qr.query("select count(*) from Food ",new ScalarHandler(1));
			return (int)l;
    	}
	         
			
	
		
		
	
	}
	
    public List<Food> findCategory(String category) throws SQLException{
    	QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
    	return qr.query("select * from Food where category = ?", new BeanListHandler<Food>(Food.class),category);
    	
    }
    
    public List<Food> findFoodsByName(String name) throws SQLException{
    	QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
    	return qr.query("select * from Food where name = ?", new BeanListHandler<Food>(Food.class),name);
    }
    */
    /*
    public void delAllFoods(String[] ids) throws SQLException{
    	QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
    	Object[][] params=new Object[ids.length][];
    	for(int i=0;i<ids.length;i++){
    		params[i]=new Object[]{ids[i]};
    	}
		
    	qr.batch("delete from Food where id =?",params);
    }
    
     */
    
   
//    public List<Food>  searchFood(String id,String category,String name,String minprice,String maxprice) throws SQLException{
//    	QueryRunner qr= new QueryRunner(C3P0Util.getDataSource());
//    	List list=new ArrayList();
//    	String sql="select * from Food where 1=1";
//    	if(!"".equals(id.trim())){
//    		sql+=" and id like ?";
//    		list.add("%"+id.trim()+"%");
//    	}
//    	if(!"".equals(category.trim())){
//    		sql+=" and category like ?";
//    		list.add(category.trim());
//    	}
////    	if(!"".equals(name.trim())){
////    		sql+=" and name like ?";
////    		list.add("%"+name.trim()+"%");
////    	}
////    	if(!"".equals(minprice.trim())){
////    		sql+=" and price > ?";
////    		list.add(minprice.trim());
////    	}
////    	if(!"".equals(maxprice.trim())){
////    		sql+=" and price < ?";
////    		list.add(maxprice.trim());
////    	}
//    	//return qr.query(sql,new BeanListHandler<Food>(Food.class), list.toArray());
//    	System.out.print("11111111111111111");
//    	System.out.print(sql);
//    	System.out.print(minprice);
//    	System.out.print(list.toArray());
//    	return qr.query(sql,new BeanListHandler<Food>(Food.class),list.toArray());
//    }
    
 
	

       /*

		  public List<Object> findFoodsName(String name) throws SQLException{
		    	QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
		    	return qr.query("select name from Food where name like ?", new ColumnListHandler(),"%"+name+"%");
		    }*/
		
    
}
