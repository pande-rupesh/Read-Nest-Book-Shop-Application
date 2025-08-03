package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.books_dtls;
import com.mysql.cj.exceptions.RSAException;

public class Addbooksimpl implements Addbooks{
    private Connection connection;

    
	public Addbooksimpl(Connection connection) {
		super();
		this.connection = connection;
	}




	@Override
	public boolean addbooks(books_dtls b) {
		boolean f = false;
		try {
		String query = "insert into books(book_name,author,price,book_catogries,status,photo,user_email)values(?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement=connection.prepareStatement(query);
        
        preparedStatement.setString(1, b.getBook_name());
        preparedStatement.setString(2, b.getAuthor());
        preparedStatement.setString(3, b.getPrice());
        preparedStatement.setString(4, b.getBook_catogries());
        preparedStatement.setString(5, b.getStatus());
        preparedStatement.setString(6, b.getPhotoName());
        preparedStatement.setString(7, b.getEmail());
        
       int row= preparedStatement.executeUpdate();
       
       if(row>0)
       {
    	   f=true;
       }
        
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return f;
	}




	@Override
	public List<books_dtls> getallbooks() {
	     List<books_dtls> list=new ArrayList<books_dtls>();
	     books_dtls b=null;
	    try {
			String query="SELECT * FROM ebook.books;";
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				b = new books_dtls();
				b.setBook_ID(resultSet.getInt(1));
				b.setBook_name(resultSet.getString(2));
				b.setAuthor(resultSet.getString(3));
				b.setPrice(resultSet.getString(4));
				b.setBook_catogries(resultSet.getString(5));
				b.setStatus(resultSet.getString(6));
				b.setPhotoName(resultSet.getString(7));
				b.setEmail(resultSet.getString(8));

				list.add(b);
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	    
		return list;
	}




	@Override
	public books_dtls getBooks(int id) {
		books_dtls b=null;
		   try {
				String query="SELECT * FROM ebook.books where book_id=?";
				PreparedStatement preparedStatement=connection.prepareStatement(query);
				
				preparedStatement.setInt(1, id);
				ResultSet resultSet=preparedStatement.executeQuery();
				
				while (resultSet.next()) {
					b = new books_dtls();
					b.setBook_ID(resultSet.getInt(1));
					b.setBook_name(resultSet.getString(2));
					b.setAuthor(resultSet.getString(3));
					b.setPrice(resultSet.getString(4));
					b.setBook_catogries(resultSet.getString(5));
					b.setStatus(resultSet.getString(6));
					b.setPhotoName(resultSet.getString(7));
					b.setEmail(resultSet.getString(8));
					
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		
		return b;
	}




	@Override
	public boolean editbook(books_dtls b) {
		boolean f=false;
		try {
			String query="update ebook.books set book_name=?,author=?,price=?,status=? where book_id=?";
			
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1,b.getBook_name());
			preparedStatement.setString(2,b.getAuthor());
			preparedStatement.setString(3, b.getPrice());
			preparedStatement.setString(4, b.getStatus());
			preparedStatement.setInt(5, b.getBook_ID());
			
			int row=preparedStatement.executeUpdate();
			if (row>0) {
				f=true;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return f;
	}




	@Override
	public boolean deletebook(int id) {
		boolean f=false;
		try {
			String query="delete from ebook.books where book_id=?";
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			int row=preparedStatement.executeUpdate();
			if (row>0) {
				f=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return f;
	}




	@Override
	public List<books_dtls> getnewbook() {
		  List<books_dtls> list=new ArrayList<books_dtls>();
		     books_dtls b=null;
		    try {
				String query="SELECT * FROM ebook.books where book_catogries=? and status=?";
				//ORDER BY book_id DESC;
				PreparedStatement preparedStatement=connection.prepareStatement(query);
				
				preparedStatement.setString(1,"New");
				preparedStatement.setString(2,"Active");
				
				ResultSet resultSet=preparedStatement.executeQuery();
				int i=1;
				while (resultSet.next() && i<=4) {
					b = new books_dtls();
					b.setBook_ID(resultSet.getInt(1));
					b.setBook_name(resultSet.getString(2));
					b.setAuthor(resultSet.getString(3));
					b.setPrice(resultSet.getString(4));
					b.setBook_catogries(resultSet.getString(5));
					b.setStatus(resultSet.getString(6));
					b.setPhotoName(resultSet.getString(7));
					b.setEmail(resultSet.getString(8));

					list.add(b);
					i++;
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		    
			return list;
	}




	@Override
	public List<books_dtls> getrecentbooks() {
		 List<books_dtls> list=new ArrayList<books_dtls>();
	     books_dtls b=null;
	    try {
			String query="SELECT * FROM ebook.books where status=? ORDER BY book_id DESC";
			//ORDER BY book_id DESC;
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			
			preparedStatement.setString(1,"Active");
			
			
			ResultSet resultSet=preparedStatement.executeQuery();
			int i=1;
			while (resultSet.next() && i<=4) {
				b = new books_dtls();
				b.setBook_ID(resultSet.getInt(1));
				b.setBook_name(resultSet.getString(2));
				b.setAuthor(resultSet.getString(3));
				b.setPrice(resultSet.getString(4));
				b.setBook_catogries(resultSet.getString(5));
				b.setStatus(resultSet.getString(6));
				b.setPhotoName(resultSet.getString(7));
				b.setEmail(resultSet.getString(8));

				list.add(b);
				i++;
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	    
		return list;
	
	}




	@Override
	public List<books_dtls> getOldbooks() {
		 List<books_dtls> list=new ArrayList<books_dtls>();
	     books_dtls b=null;
	    try {
			String query="SELECT * FROM ebook.books where book_catogries=? and status=?";
			//ORDER BY book_id DESC;
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			
			preparedStatement.setString(1,"Old");
			preparedStatement.setString(2,"Active");
			
			ResultSet resultSet=preparedStatement.executeQuery();
			int i=1;
			while (resultSet.next() && i<=4) {
				b = new books_dtls();
				b.setBook_ID(resultSet.getInt(1));
				b.setBook_name(resultSet.getString(2));
				b.setAuthor(resultSet.getString(3));
				b.setPrice(resultSet.getString(4));
				b.setBook_catogries(resultSet.getString(5));
				b.setStatus(resultSet.getString(6));
				b.setPhotoName(resultSet.getString(7));
				b.setEmail(resultSet.getString(8));

				list.add(b);
				i++;
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	    
		return list;
	}




	@Override
	public List<books_dtls> getallrecentbooks() {
		List<books_dtls> list=new ArrayList<books_dtls>();
	     books_dtls b=null;
	    try {
			String query="SELECT * FROM ebook.books where status=? ORDER BY book_id DESC";
			//ORDER BY book_id DESC;
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			
			preparedStatement.setString(1,"Active");
			
			
			ResultSet resultSet=preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				b = new books_dtls();
				b.setBook_ID(resultSet.getInt(1));
				b.setBook_name(resultSet.getString(2));
				b.setAuthor(resultSet.getString(3));
				b.setPrice(resultSet.getString(4));
				b.setBook_catogries(resultSet.getString(5));
				b.setStatus(resultSet.getString(6));
				b.setPhotoName(resultSet.getString(7));
				b.setEmail(resultSet.getString(8));

				list.add(b);
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	    
		return list;
	}




	@Override
	public List<books_dtls> getallnewbooks() {
		  List<books_dtls> list=new ArrayList<books_dtls>();
		     books_dtls b=null;
		    try {
				String query="SELECT * FROM ebook.books where book_catogries=? and status=?";
				//ORDER BY book_id DESC;
				PreparedStatement preparedStatement=connection.prepareStatement(query);
				
				preparedStatement.setString(1,"New");
				preparedStatement.setString(2,"Active");
				
				ResultSet resultSet=preparedStatement.executeQuery();
				
				while (resultSet.next()) {
					b = new books_dtls();
					b.setBook_ID(resultSet.getInt(1));
					b.setBook_name(resultSet.getString(2));
					b.setAuthor(resultSet.getString(3));
					b.setPrice(resultSet.getString(4));
					b.setBook_catogries(resultSet.getString(5));
					b.setStatus(resultSet.getString(6));
					b.setPhotoName(resultSet.getString(7));
					b.setEmail(resultSet.getString(8));

					list.add(b);
					
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		    
			return list;
	}




	@Override
	public List<books_dtls> getalloldbooks() {
		List<books_dtls> list=new ArrayList<books_dtls>();
	     books_dtls b=null;
	    try {
			String query="SELECT * FROM ebook.books where book_catogries=? and status=?";
			//ORDER BY book_id DESC;
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			
			preparedStatement.setString(1,"Old");
			preparedStatement.setString(2,"Active");
			
			ResultSet resultSet=preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				b = new books_dtls();
				b.setBook_ID(resultSet.getInt(1));
				b.setBook_name(resultSet.getString(2));
				b.setAuthor(resultSet.getString(3));
				b.setPrice(resultSet.getString(4));
				b.setBook_catogries(resultSet.getString(5));
				b.setStatus(resultSet.getString(6));
				b.setPhotoName(resultSet.getString(7));
				b.setEmail(resultSet.getString(8));

				list.add(b);
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	    
		return list;
	}




	@Override
	public List<books_dtls> DeleteOldBookByUser(String email, String book_catogries) {
		List<books_dtls> list=new ArrayList<books_dtls>();
	     books_dtls b=null;
	    try {
			String query="SELECT * FROM ebook.books where user_email=? and book_catogries=?";
			//ORDER BY book_id DESC;
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			
			preparedStatement.setString(1,email);
			preparedStatement.setString(2,book_catogries);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				b = new books_dtls();
				b.setBook_ID(resultSet.getInt(1));
				b.setBook_name(resultSet.getString(2));
				b.setAuthor(resultSet.getString(3));
				b.setPrice(resultSet.getString(4));
				b.setBook_catogries(resultSet.getString(5));
				b.setStatus(resultSet.getString(6));
				b.setPhotoName(resultSet.getString(7));
				b.setEmail(resultSet.getString(8));

				list.add(b);
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	    
		return list;
	}




	@Override
	public boolean deleteoldBook(String email, String book_catogries, int bid) {
		boolean f=false;
		try {
			String query="delete from ebook.books where user_email=? and book_catogries=? and book_id=?";
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1,email);
			preparedStatement.setString(2,book_catogries);
			preparedStatement.setInt(3, bid);
			int row=preparedStatement.executeUpdate();
			if (row>0) {
				f=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return f;
	}




	@Override
	public List<books_dtls> getsearchbook(String search) {
		List<books_dtls> list=new ArrayList<books_dtls>();
	     books_dtls b=null;
	    try {
			String query="SELECT * FROM ebook.books where book_name like ? or author like ? or book_catogries like ? and status=? ORDER BY book_id DESC";
			//ORDER BY book_id DESC;
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1, "%"+search+"%");
			preparedStatement.setString(2, "%"+search+"%");
			preparedStatement.setString(3, "%"+search+"%");
			preparedStatement.setString(4,"Active");
			
			
			ResultSet resultSet=preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				b = new books_dtls();
				b.setBook_ID(resultSet.getInt(1));
				b.setBook_name(resultSet.getString(2));
				b.setAuthor(resultSet.getString(3));
				b.setPrice(resultSet.getString(4));
				b.setBook_catogries(resultSet.getString(5));
				b.setStatus(resultSet.getString(6));
				b.setPhotoName(resultSet.getString(7));
				b.setEmail(resultSet.getString(8));

				list.add(b);
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	    
		return list;
	}




	
	
}
