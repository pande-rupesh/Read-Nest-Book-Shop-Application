package com.entity;

public class books_dtls {
   private int book_ID;
   private String book_name;
   private String author;
   private String price;
   private String book_catogries;
   private String status;
   private String photoName;
   private String email;
public books_dtls() {
	super();
	// TODO Auto-generated constructor stub
	
	
}
public int getBook_ID() {
	return book_ID;
}
public void setBook_ID(int book_ID) {
	this.book_ID = book_ID;
}
public String getBook_name() {
	return book_name;
}
public void setBook_name(String book_name) {
	this.book_name = book_name;
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
public String getBook_catogries() {
	return book_catogries;
}
public void setBook_catogries(String book_catogries) {
	this.book_catogries = book_catogries;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public String getPhotoName() {
	return photoName;
}
public void setPhotoName(String photoName) {
	this.photoName = photoName;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public books_dtls(String book_name, String author, String price, String book_catogries, String status,
		String photoName, String email) {
	super();
	this.book_ID = book_ID;
	this.book_name = book_name;
	this.author = author;
	this.price = price;
	this.book_catogries = book_catogries;
	this.status = status;
	this.photoName = photoName;
	this.email = email;
}
@Override
public String toString() {
	return "books_dtls [book_ID=" + book_ID + ", book_name=" + book_name + ", author=" + author + ", price=" + price
			+ ", book_catogries=" + book_catogries + ", status=" + status + ", photoName=" + photoName + ", email="
			+ email + "]";
}
   
   
}
