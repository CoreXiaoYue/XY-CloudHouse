package com.xiaoyue.struts2.bean;


public class Book {
	private Integer bookId;//编号
	private String name;//书名
	private double price;//价格
	private Integer stock;//库存
	public Book(Integer bookId, String name, double price, Integer stock) {
		super();
		this.bookId = bookId;
		this.name = name;
		this.price = price;
		this.stock = stock;
	}
	public Book() {
		super();
	}
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", name=" + name + ", price=" + price
				+ ", stock=" + stock + "]";
	}

	
}
