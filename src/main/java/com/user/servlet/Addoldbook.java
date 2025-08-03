package com.user.servlet;

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

import com.DAO.Addbooksimpl;
import com.DB.DBconnect;
import com.entity.books_dtls;

/**
 * Servlet implementation class Addoldbook
 */
@WebServlet("/Addoldbook")
@MultipartConfig
public class Addoldbook extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("bname");
		  String author=request.getParameter("Aname");
		  String price=request.getParameter("price");
		  String bookcategroie=request.getParameter("btype");
		  //String status=request.getParameter("sts");
		  String status="Active";
		  Part part=request.getPart("bimg");
		  String filename=part.getSubmittedFileName();
		  String useremail=request.getParameter("email");
		  if ("Book categories".equals(bookcategroie))
		  {
			  HttpSession httpSession=request.getSession();
			  httpSession.setAttribute("failmsg", "please select correct Book categories");
				response.sendRedirect("Sell_old_book.jsp");
		   }
		  else {
			
		
		  books_dtls book=new books_dtls(name,author,price,bookcategroie,status,filename,useremail);
		  
		 Addbooksimpl dao=new Addbooksimpl(DBconnect.getConnection());
		  boolean f=dao.addbooks(book);
		  HttpSession httpSession=request.getSession();
		  if (f) {

			  
			  String path=getServletContext().getRealPath("")+"books";
			   File file=new File(path);
			   
			   part.write(path+File.separator+filename);
			   
			   
	    	httpSession.setAttribute("successmsg", "Book Insert Successfully......");
			response.sendRedirect("Sell_old_book.jsp");
		}else {
			httpSession.setAttribute("failmsg", "Something Went Wrong......");
			response.sendRedirect("Sell_old_book.jsp");
		}
	}
	}
}
