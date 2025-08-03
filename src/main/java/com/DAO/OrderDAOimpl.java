package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Order;
import com.user.servlet.Order2;

public class OrderDAOimpl implements OrderDAO{
 private Connection connection;

public OrderDAOimpl(Connection connection) {
	super();
	this.connection = connection;
}

@Override
public boolean Saveorders(List<Order2> list) {
	boolean f=false;
	try {
		
		String query="insert into orders (orderid, uid, username, useremail, userphone, bookname, author, price, address, payment_type,Date,quantity) values (?,?,?,?,?,?,?,?,?,?,?,?)";
		connection.setAutoCommit(false);
		PreparedStatement preparedStatement=connection.prepareStatement(query);
		for(Order2 o:list)
		{
			preparedStatement.setInt(1, o.getOrderid());
			preparedStatement.setInt(2, o.getUid());
			preparedStatement.setString(3, o.getUsername());
			preparedStatement.setString(4, o.getUseremail());
			preparedStatement.setString(5, o.getUserphone());
			preparedStatement.setString(6, o.getBookname());
			preparedStatement.setString(7, o.getAuthor());
			preparedStatement.setString(8, o.getPrice());
			preparedStatement.setString(9, o.getAddress());
			preparedStatement.setString(10, o.getPaymentype());
			preparedStatement.setTimestamp(11, o.getDate()); // Save to DB
			preparedStatement.setInt(12, o.getQuantity());
			
			preparedStatement.addBatch();
		}
		int [] row=preparedStatement.executeBatch();
		connection.commit();
		f=true;
		connection.setAutoCommit(true);
		
		
	} catch (Exception e) {
		
		e.printStackTrace();
	}
	return f;
}

@Override
public List<Order2> GetAllOrderofUser(int id) {
	ArrayList<Order2> list=new ArrayList<Order2>();
	Order2 order2=null;
	try {
		String query="select * from orders where uid=?";
		PreparedStatement preparedStatement=connection.prepareStatement(query);
		preparedStatement.setInt(1, id);
		ResultSet resultSet=preparedStatement.executeQuery();
		while (resultSet.next()) {
			order2=new Order2();
			order2.setId(resultSet.getInt(1));
			order2.setOrderid(resultSet.getInt(2));
			order2.setUsername(resultSet.getString(4));
			order2.setUseremail(resultSet.getString(5));
			order2.setUserphone(resultSet.getString(6));
			order2.setBookname(resultSet.getString(7));
			order2.setAuthor(resultSet.getString(8));
			order2.setPrice(resultSet.getString(9));
			order2.setAddress(resultSet.getString(10));
			order2.setPaymentype(resultSet.getString(11));
			
			list.add(order2);

		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	
	
	
	
	
	
	return list;
	
}

@Override
public List<Order2> GetAllOrder() {
	ArrayList<Order2> list=new ArrayList<Order2>();
	Order2 order2=null;
	try {
		String query="select * from orders";
		PreparedStatement preparedStatement=connection.prepareStatement(query);
		ResultSet resultSet=preparedStatement.executeQuery();
		while (resultSet.next()) {
			order2=new Order2();
			order2.setId(resultSet.getInt(1));
			order2.setOrderid(resultSet.getInt(2));
			order2.setUid(resultSet.getInt(3));
			order2.setUsername(resultSet.getString(4));
			order2.setUseremail(resultSet.getString(5));
			order2.setUserphone(resultSet.getString(6));
			order2.setBookname(resultSet.getString(7));
			order2.setAuthor(resultSet.getString(8));
			order2.setPrice(resultSet.getString(9));
			order2.setAddress(resultSet.getString(10));
			order2.setPaymentype(resultSet.getString(11));
			order2.setDate(resultSet.getTimestamp(12));
			
			list.add(order2);

		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return list;
}

@Override
public boolean clearcart(int uid) {
	boolean f=false;
	try {
		String query="delete from cart where uid=?";
		PreparedStatement preparedStatement=connection.prepareStatement(query);
		preparedStatement.setInt(1, uid);
		int row=preparedStatement.executeUpdate();
		if (row>0) {
			f=true;
		}
	} catch (Exception e) {
		// TODO: handle exception
	}
	return f;
}

@Override
public int getMaxOrderId() {
    int maxorderid = 0;
    try {
        String query = "SELECT MAX(orderid) FROM orders";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) { // Use if instead of while since there's only one result
            maxorderid = resultSet.getInt(1); // Fetch the max order ID directly
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return maxorderid; // Now correctly returns the max order ID
}

public List<Order2> getOrdersByOrderId(int orderId) {
    List<Order2> orderList = new ArrayList<>();
    double totalprice = 0.0;
    try {
        String query = "SELECT * FROM orders WHERE orderid = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, orderId);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Order2 order = new Order2();
            order.setOrderid(rs.getInt("orderid"));
            order.setUid(rs.getInt("uid"));
            order.setUsername(rs.getString("username"));
            order.setUseremail(rs.getString("useremail"));
            order.setUserphone(rs.getString("userphone"));
            order.setBookname(rs.getString("bookname"));
            order.setAuthor(rs.getString("author"));
            order.setPrice(rs.getString("price"));
            order.setAddress(rs.getString("address"));
            order.setPaymentype(rs.getString("payment_type"));
            order.setDate(rs.getTimestamp("date"));
            order.setQuantity(rs.getInt("quantity"));
            totalprice += Double.parseDouble(rs.getString("price"));
            order.setTotalprice(String.valueOf(totalprice));

            orderList.add(order);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return orderList;
}

 
 
}
