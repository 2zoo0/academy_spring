package com.mis.domain;

public class ProductVO {

	private String name;
	private double price;
	private int count, size;
	
	public ProductVO() {
		
	}
	
	public ProductVO(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}
	
	
	public ProductVO(String name, double price, int count, int size) {
		super();
		this.name = name;
		this.price = price;
		this.count = count;
		this.size = size;
	}




	public String getName() {
		return name;
	}
	
	public double getPrice() {
		return price;
	}
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "제품명 : " + name + "<br> 제품가격  : " + price + "원 <br> 제품사이즈 : " + size + "<br> 제품수량 " + count;
	}
	
	
	
	
	
	
}
