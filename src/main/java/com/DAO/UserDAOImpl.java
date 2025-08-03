package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.User;

public class UserDAOImpl implements UserDAO {
 
	private Connection connection;

	public UserDAOImpl(Connection connection) {
		super();
		this.connection = connection;
	}

	
	
	@Override
	public boolean isemailexits(String email) {
		boolean f=false;
		try {
			String query="select * from ebook.user where email=?";
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1, email);
			ResultSet rs=preparedStatement.executeQuery();
			if(rs.next())
			{
				f=true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return f;
	}



	@Override
	public boolean isphoneexits(String phone) {
		boolean f1=false;
		try {
			String query="select * from ebook.user where phone=?";
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1, phone);
			ResultSet rs=preparedStatement.executeQuery();
			if(rs.next())
			{
				f1=true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return f1;
	}



	@Override
	public Boolean RegisterUser(User us) {
		boolean f=false;
		try {
			
			String query="INSERT into user(name, email, phone, password, address, landmark, city, state, pincode)values(?,?,?,?,?,?,?,?,?)";
			            
			
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1, us.getName());
			preparedStatement.setString(2, us.getEmail());
			preparedStatement.setString(3, us.getPhone());
			preparedStatement.setString(4, us.getPassword());
			preparedStatement.setString(5, us.getAddress());
			preparedStatement.setString(6,us.getLandmark());
			preparedStatement.setString(7,us.getCity());
			preparedStatement.setString(8, us.getState());
			preparedStatement.setString(9,us.getPincode());
			
			int row=preparedStatement.executeUpdate();
			if(row>0)
			{
				
				f=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return f;
	}

	@Override
	public User login(String email, String password) {
		User us=null;
		
		
		try {
			
			 String query="select * from ebook.user where email=? and password=?";
			 PreparedStatement preparedStatement=connection.prepareStatement(query);
			 
			 preparedStatement.setString(1, email);
			 preparedStatement.setString(2, password);
			 
			 ResultSet resultSet=preparedStatement.executeQuery();
			 
			 if(resultSet.next())
			 {
					us = new User();
					us.setId(resultSet.getInt(1));
					us.setName(resultSet.getString(2));
					us.setEmail(resultSet.getString(3));
					us.setPhone(resultSet.getString(4));
					us.setPassword(resultSet.getString(5));
					us.setAddress(resultSet.getString(6));
					us.setLandmark(resultSet.getString(7));
					us.setCity(resultSet.getString(8));
					us.setState(resultSet.getString(9));
					us.setPincode(resultSet.getString(10));
			 }
			 
		} catch (SQLException e) {
		e.printStackTrace();
		}
		return us;
	}

	@Override
	public boolean UpdateUserServlet(User us) {
		boolean f=false;
		try {
			
			String query="update  user set name=?,email=?,phone=?,password=?  where id=?";
			            
			
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1, us.getName());
			preparedStatement.setString(2, us.getEmail());
			preparedStatement.setString(3, us.getPhone());
			preparedStatement.setString(4, us.getPassword());
			preparedStatement.setInt   (5,us.getId());
			
			int row=preparedStatement.executeUpdate();
			if(row>0)
			{
				
				f=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return f;
	}



	@Override
	public List<User> getallusers() {
		ArrayList<User> list=new ArrayList<User>();
		User user=null;
		try {
			String query="select * from user";
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			ResultSet resultSet=preparedStatement.executeQuery();
		    while(resultSet.next())
		    {
		    	user=new User();
		    	user.setId(resultSet.getInt(1));
		    	user.setName(resultSet.getString(2));
		    	user.setEmail(resultSet.getString(3));
		    	user.setPhone(resultSet.getString(4));
		    	user.setPassword(resultSet.getString(5));
		    	user.setFullAddressString(resultSet.getString(6)+","+resultSet.getString(7)+","+resultSet.getString(8)+","+resultSet.getString(9)+","+resultSet.getInt(10));
		    	list.add(user);
		    }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}



	@Override
	public boolean Removeuser(int uid) {
		boolean f=false;
		try {
			String query="delete from user where id=?";
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			preparedStatement.setInt(1, uid);
			int row=preparedStatement.executeUpdate();
			if (row>0) {
				f=true;
			}
		} catch (Exception e) {
			e.printStackTrace();		}
		return f;
	}
	
	
}
