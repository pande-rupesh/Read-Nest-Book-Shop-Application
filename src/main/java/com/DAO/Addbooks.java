package com.DAO;

import java.util.List;

import com.entity.books_dtls;

public interface Addbooks {
  public boolean addbooks(books_dtls b);
  
  public List<books_dtls> getallbooks();
  
  public books_dtls getBooks(int id);
  
  public boolean editbook(books_dtls b);
  
  public boolean deletebook(int id);
  
  public List<books_dtls> getnewbook();
  
  public List<books_dtls> getrecentbooks();
  
  public List<books_dtls> getOldbooks();
  
  public List<books_dtls> getallrecentbooks();
  
  public List<books_dtls> getallnewbooks();
  
  public List<books_dtls> getalloldbooks();
  
 
  
  public List<books_dtls> DeleteOldBookByUser(String email,String book_catogries);
  
  public boolean deleteoldBook(String email,String book_catogries,int bid);
  
  public List<books_dtls> getsearchbook(String search);
}
