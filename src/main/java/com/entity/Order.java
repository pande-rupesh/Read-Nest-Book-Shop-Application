package com.entity;

public class Order {
 private int id;
 private int orderid;
 private int uid;
 private String username;
 private String useremail;
 private String userphone;
 private String bookname;
 private String author;
 private String price;
 private String address;
 private String paymentype;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getOrderid() {
	return orderid;
}
public void setOrderid(int orderid) {
	this.orderid = orderid;
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
public Order(int id, int orderid, int uid, String username, String useremail, String userphone, String bookname,
		String author, String price, String address, String paymentype) {
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
	this.address = address;
	this.paymentype = paymentype;
}
public Order() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "Order [id=" + id + ", orderid=" + orderid + ", uid=" + uid + ", username=" + username + ", useremail="
			+ useremail + ", userphone=" + userphone + ", bookname=" + bookname + ", author=" + author + ", price="
			+ price + ", address=" + address + ", paymentype=" + paymentype + "]";
}
 
 
}
