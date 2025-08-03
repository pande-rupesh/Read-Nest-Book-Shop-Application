package com.admin.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;

import com.DAO.Addbooksimpl;
import com.DB.DBconnect;
import com.entity.books_dtls;

/**
 * Servlet implementation class addbooks
 */
@WebServlet("/addbooks")
@MultipartConfig
public class addbooks extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  String name=request.getParameter("bname");
	  String author=request.getParameter("Aname");
	  String price=request.getParameter("price");
	  String bookcategroie=request.getParameter("btype");
	  String status=request.getParameter("sts");
	  Part part=request.getPart("bimg");
	  String filename=part.getSubmittedFileName();
	  
	  if ("Book categories".equals(bookcategroie) || "Book Status".equals(status))
	  {
		  HttpSession httpSession=request.getSession();
		  httpSession.setAttribute("failmsg", "please select correct Book categories and status");
			response.sendRedirect("Admin/add_books.jsp");
	   }
	  else
	  {
//	  int price1 = 0;
//
//	  try {
//	      price1 = Integer.parseInt(price);
//	      if (price1 < 0) {
//	    	  HttpSession httpSession=request.getSession();
//	          httpSession.setAttribute("failmsg", "Price cannot be negative.");
//	          response.sendRedirect("Admin/add_books.jsp");
//	          return;
//	      }
//	  } catch (NumberFormatException e) {
//		  HttpSession httpSession=request.getSession();
//	      httpSession.setAttribute("failmsg", "Invalid price. Please enter a valid number.");
//	      response.sendRedirect("Admin/add_books.jsp");
//	      return;
//	  }

	  
	  books_dtls book=new books_dtls(name,author,price,bookcategroie,status,filename,"admin");
	  
	 Addbooksimpl dao=new Addbooksimpl(DBconnect.getConnection());
	  boolean f=dao.addbooks(book);
	  HttpSession httpSession=request.getSession();
	  if (f) {

		  
		  String path=getServletContext().getRealPath("")+"books";
		   File file=new File(path);
		   
		   part.write(path+File.separator+filename);
		   
		   
    	httpSession.setAttribute("successmsg", "Book Insert Successfully......");
		response.sendRedirect("Admin/add_books.jsp");
	}else {
		httpSession.setAttribute("failmsg", "Something Went Wrong......");
		response.sendRedirect("Admin/add_books.jsp");
	}
	  
	  }
	}

}
