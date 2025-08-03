package com.DAO;

import java.util.List;

import com.entity.Cart;

public interface CartDAO {
 public boolean addCart(Cart c);
 
 public List<Cart>  AllOrderdBooksOfUser(int UserId);
 
 public boolean removefromcart(int cid,int uid);
 
 public boolean updatequantity(Cart c);
}
