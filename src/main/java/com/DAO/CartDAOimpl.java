package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Cart;

public class CartDAOimpl implements CartDAO {
	private Connection connection;

	public CartDAOimpl(Connection connection) {
		this.connection = connection;
	}

	@Override
	public boolean addCart(Cart c) {
		boolean f = false;

		try {
			String query = "insert into cart( bid, uid, bookname, author, price, totalprice) values(?,?,?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, c.getBid());
			preparedStatement.setInt(2, c.getUid());
			preparedStatement.setString(3, c.getBookname());
			preparedStatement.setString(4, c.getAuthor());
			preparedStatement.setDouble(5, c.getPrice());
			preparedStatement.setDouble(6, c.getTotalprice());
			
			int row=preparedStatement.executeUpdate();
			if (row>0) {
				f=true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	@Override
	public List<Cart> AllOrderdBooksOfUser(int UserId) {
		List<Cart> list=new ArrayList<Cart>();
	     Cart cart=null;
	      double TotalPrice=0;
	try {
		String query="select * from cart where uid=?";
		PreparedStatement preparedStatement=connection.prepareStatement(query);
		preparedStatement.setInt(1, UserId);
		ResultSet resultSet=preparedStatement.executeQuery();
		while(resultSet.next()) {
			cart=new Cart();
			cart.setCid(resultSet.getInt(1));
			cart.setBid(resultSet.getInt(2));
			cart.setUid(resultSet.getInt(3));
			cart.setBookname(resultSet.getString(4));
			cart.setAuthor(resultSet.getString(5));
			cart.setPrice(resultSet.getDouble(6));
			cart.setQuantity(resultSet.getInt("quantity"));
			cart.setTotalprice(resultSet.getDouble("totalprice"));
			
			//cart.setFinalprice(resultSet.getDouble(8));
			//TotalPrice=TotalPrice+resultSet.getDouble(7);
			//cart.setTotalprice(TotalPrice);
			  
			TotalPrice=TotalPrice+resultSet.getDouble("totalprice");
			cart.setTotalcartprice(TotalPrice);
			
			//cart.setPrice(TotalPrice);
			  
			  
			list.add(cart);
		}
	} catch (Exception e) {
	e.printStackTrace();;
	}
		return list;

	}

	@Override
	public boolean removefromcart(int cid, int uid) {
		boolean f=false;
		try {
			String query="delete from cart where cid=? and uid=?";
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			preparedStatement.setInt(1, cid);
			preparedStatement.setInt(2, uid);
			int row=preparedStatement.executeUpdate();
			if (row>0) {
				f=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	@Override
	public boolean updatequantity(Cart c) {
	    boolean f = false;
	    try {
	        // Use UPDATE instead of INSERT
	        String query = "UPDATE cart SET quantity = ?, totalprice = ? WHERE cid = ? AND bid = ? AND uid = ?";
	        PreparedStatement preparedStatement = connection.prepareStatement(query);
	        preparedStatement.setInt(1, c.getQuantity());
	        preparedStatement.setDouble(2, c.getTotalprice());
	        preparedStatement.setInt(3, c.getCid());
	        preparedStatement.setInt(4, c.getBid());
	        preparedStatement.setInt(5, c.getUid());

	        int row = preparedStatement.executeUpdate();
	        if (row > 0) {
	            f = true;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return f;
	}

   
}
