package com.meituan.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;



import com.meituan.damian.Shop;
import com.meituan.util.C3P0Util;


public class ShopDao {
    public List<Shop> findAllShops() throws SQLException{
    	QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
    	return qr.query("select * from Shop", new BeanListHandler<Shop>(Shop.class));
    	
    }
    
    public List<Shop> addShop(Shop shop) throws SQLException{
    	QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
    	qr.update("insert into Shop values(?,?,?,?,?)",shop.getId(),shop.getName(),shop.getCategory(),shop.getStartprice(),shop.getImg_url());
		return null;
        
    }
    
    
    public Shop findShopById(String id)throws SQLException{
    	QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
    	return qr.query("select * from Shop where id=?", new BeanHandler<Shop>(Shop.class),id);
    }
    
    public void updateShop(Shop Shop) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		qr.update("update Shop set name=?,startprice=?,category=?img_url=?where id=?",
				Shop.getName(),Shop.getStartprice(),Shop.getCategory(),Shop.getId(),Shop.getImg_url());
		

	}
   
 
    public void deleteShop(String id) throws SQLException{
    	QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
    	qr.update("delete from Shop where id =?",id);
    }
    
    public List<Shop> searchShop(String id, String category, String name,
			String minprice, String maxprice) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		String sql = "select * from Shop where 1=1";
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
		return qr.query(sql, new BeanListHandler<Shop>(Shop.class),list.toArray());
     	// qr.query(sql, new BeanListHandler<Shop>(Shop.class),("%"+id.trim()+"%"),category.trim(),("%"+name.trim()+"%"),minprice.trim(),maxprice.trim());
	}
    
    /*public List<Shop> findShopsPage(int currentPage,int pageSize) throws SQLException{
    	QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
    	return qr.query("select * from Shop limit ?,?", new BeanListHandler<Shop>(Shop.class),(currentPage-1)*pageSize,pageSize);
    	
    }*/
    
    public List<Shop> findShopsPage(int currentPage,int pageSize,String category) throws SQLException{
    	QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
    	String sql="";
    	
    	if(!"".equals(category)){
    		sql="select * from Shop where category =? limit ?,?";
    	   return qr.query(sql, new BeanListHandler<Shop>(Shop.class),category,(currentPage-1)*pageSize,pageSize);
    	}else{
    		sql="select * from Shop limit ?,?";
    		return qr.query(sql, new BeanListHandler<Shop>(Shop.class),(currentPage-1)*pageSize,pageSize);
    	}
    }

	public int count(String category) throws SQLException {
		QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
		long l;
    	
    	if(!"".equals(category)){
    		l = (Long) qr.query("select count(*) from Shop  where category = ?",new ScalarHandler(1),category);
			return (int)l;
    	}else{
    		l = (Long) qr.query("select count(*) from Shop ",new ScalarHandler(1));
			return (int)l;
    	}
	         
			
	
		
		
	
	}
	
    public List<Shop> findCategory(String category) throws SQLException{
    	QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
    	return qr.query("select * from Shop where category = ?", new BeanListHandler<Shop>(Shop.class),category);
    	
    }
    
    public List<Shop> findShopsByName(String name) throws SQLException{
    	QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
    	return qr.query("select * from Shop where name = ?", new BeanListHandler<Shop>(Shop.class),name);
    }
    
    /*
    public void delAllShops(String[] ids) throws SQLException{
    	QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
    	Object[][] params=new Object[ids.length][];
    	for(int i=0;i<ids.length;i++){
    		params[i]=new Object[]{ids[i]};
    	}
		
    	qr.batch("delete from Shop where id =?",params);
    }
    
     */
    
   
//    public List<Shop>  searchShop(String id,String category,String name,String minprice,String maxprice) throws SQLException{
//    	QueryRunner qr= new QueryRunner(C3P0Util.getDataSource());
//    	List list=new ArrayList();
//    	String sql="select * from Shop where 1=1";
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
//    	//return qr.query(sql,new BeanListHandler<Shop>(Shop.class), list.toArray());
//    	System.out.print("11111111111111111");
//    	System.out.print(sql);
//    	System.out.print(minprice);
//    	System.out.print(list.toArray());
//    	return qr.query(sql,new BeanListHandler<Shop>(Shop.class),list.toArray());
//    }
    
 
	

       /*

		  public List<Object> findShopsName(String name) throws SQLException{
		    	QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
		    	return qr.query("select name from Shop where name like ?", new ColumnListHandler(),"%"+name+"%");
		    }*/
		
    
}
