package com.meituan.damian;

public class Shop {
	
	private String id;
    private String name;
    private String category;
    private double startprice;
    private String img_url;
    private String business_id;
	
	public String getBusiness_id() {
		return business_id;
	}
	public void setBusiness_id(String business_id) {
		this.business_id = business_id;
	}
	public String getId() {
		return id;
	}
	public String getImg_url() {
		return img_url;
	}
	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public double getStartprice() {
		return startprice;
	}
	public void setStartprice(double startprice) {
		this.startprice = startprice;
	}
	
	
   
	
}
