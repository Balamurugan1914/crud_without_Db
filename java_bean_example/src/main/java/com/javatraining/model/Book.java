package com.javatraining.model;
public class Book {
	private int bookNumber;
	private String boookName;
	private String authourName;
	private double price;
	
	public Book() {
		super();
		
	}
	public Book(int bookNumber, String boookName, String authourName,double price) {
		super();
		this.bookNumber = bookNumber;
		this.boookName = boookName;
		this.authourName = authourName;
		this.price = price;
	}
	
	
	public int getBookNumber() {
		return bookNumber;
	}
	public void setBookNumber(int bookNumber) {
		this.bookNumber = bookNumber;
	}
	public String getBoookName() {
		return boookName;
	}
	public void setBoookName(String boookName) {
		this.boookName = boookName;
	}
	public String getAuthourName() {
		return authourName;
	}
	public void setAuthourNampricee(String authourName) {
		this.authourName = authourName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Book [bookNumber=" + bookNumber + ", boookName=" + boookName + ", authourName=" + authourName
				+ ", price=" + price + "]";
	}
	

}
