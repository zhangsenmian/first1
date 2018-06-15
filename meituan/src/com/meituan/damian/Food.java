package com.meituan.damian;

public class Food {
  private String fid;
  private String foodname;
  private double foodprice;
  private String shopid;
  private String img_url;
  public String getImg_url() {
	return img_url;
}
public void setImg_url(String img_url) {
	this.img_url = img_url;
}
public String getShopid() {
	return shopid;
}
public void setShopid(String shopid) {
	this.shopid = shopid;
}

public String getFid() {
	return fid;
}
public void setFid(String fid) {
	this.fid = fid;
}
public String getFoodname() {
	return foodname;
}
public void setFoodname(String foodname) {
	this.foodname = foodname;
}
public double getFoodprice() {
	return foodprice;
}
public void setFoodprice(double foodprice) {
	this.foodprice = foodprice;
}

  
  
  
}
