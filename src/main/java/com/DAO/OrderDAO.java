package com.DAO;

import java.util.List;

import com.entity.Order;
import com.user.servlet.Order2;

public interface OrderDAO {
	
  public boolean Saveorders(List<Order2> list);
  
   public List<Order2> GetAllOrderofUser(int id);
   
   public List<Order2> GetAllOrder();
   
   public boolean clearcart(int uid);
  
   public int getMaxOrderId();
   
   public List<Order2> getOrdersByOrderId(int orderId);
}
