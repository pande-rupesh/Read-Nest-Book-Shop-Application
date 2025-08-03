package com.DAO;



import java.util.List;

import com.entity.User;

public interface UserDAO {
	
  public boolean isemailexits(String email);
	
  public boolean isphoneexits(String phone);
  
  public Boolean RegisterUser(User us);
  
  public User login(String email,String password);
  
  public boolean UpdateUserServlet(User us);
  
  public List<User> getallusers();
  
  public boolean Removeuser(int uid);
}
