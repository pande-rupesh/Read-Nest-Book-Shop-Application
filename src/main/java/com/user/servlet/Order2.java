package com.user.servlet;

import java.sql.Date;
import java.time.LocalDateTime;
import java.sql.Timestamp;

public class Order2 {
	private int id;
	 private int orderid;
	 private int uid;
	 private String username;
	 private String useremail;
	 private String userphone;
	 private String bookname;
	 private String author;
	 private String price;//Toatl price;
	 
	 private String totalprice;
	 private String address;
	 private String paymentype;
	 private int quantity;
	

	
	     private Timestamp date;

	     public Timestamp getDate() {
	         return date;
	     }

	     public void setDate(Timestamp date) {
	         this.date = date;
	     }
	 

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int i) {
		this.orderid = i;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUseremail() {
		return useremail;
	}
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}
	public String getUserphone() {
		return userphone;
	}
	public void setUserphone(String userphone) {
		this.userphone = userphone;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPaymentype() {
		return paymentype;
	}
	public void setPaymentype(String paymentype) {
		this.paymentype = paymentype;
	}

	public String getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(String totalprice) {
		this.totalprice = totalprice;
	}

	public Order2(int id, int orderid, int uid, String username, String useremail, String userphone, String bookname,
			String author, String price, String totalprice, String address, String paymentype, Timestamp date,int quantity) {
		super();
		this.id = id;
		this.orderid = orderid;
		this.uid = uid;
		this.username = username;
		this.useremail = useremail;
		this.userphone = userphone;
		this.bookname = bookname;
		this.author = author;
		this.price = price;
		this.totalprice = totalprice;
		this.address = address;
		this.paymentype = paymentype;
		this.date = date;
		this.quantity=quantity;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Order2() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	 
	 
}
