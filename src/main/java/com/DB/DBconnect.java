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
		  connection=DriverManager.getConnection("url", "username", "password");
	} catch (ClassNotFoundException e) {
	e.printStackTrace();
	}
	  catch (SQLException e) {
		e.printStackTrace();
	}
	  return connection;
  }
}
