package com.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnect {
  private static Connection connection;
  
  public static Connection getConnection()
  {
	  
	  try {
		
		  Class.forName("com.mysql.cj.jdbc.Driver");
		  connection=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ebook", "root", "pande9096");
	} catch (ClassNotFoundException e) {
	e.printStackTrace();
	}
	  catch (SQLException e) {
		e.printStackTrace();
	}
	  return connection;
  }
}
