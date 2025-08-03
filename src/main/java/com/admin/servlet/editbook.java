package com.admin.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import com.DAO.Addbooksimpl;
import com.DB.DBconnect;
import com.entity.books_dtls;

/**
 * Servlet implementation class editbook
 */
@WebServlet("/editbook")
public class editbook extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try {
		int id=Integer.parseInt(request.getParameter("id"));
		 String name=request.getParameter("bname");
		  String author=request.getParameter("Aname");
		  String price=request.getParameter("price");
		  String status=request.getParameter("sts");
		  
		  books_dtls b=new books_dtls();
		  b.setBook_ID(id);
		  b.setBook_name(name);
		  b.setAuthor(author);
		  b.setPrice(price);
		  b.setStatus(status);
		  Addbooksimpl dao=new Addbooksimpl(DBconnect.getConnection());
		  boolean f=dao.editbook(b);
		  
		  HttpSession httpSession=request.getSession();
		  if (f) {
			  httpSession.setAttribute("successmsg", "Book Edit Successfully......");
				response.sendRedirect("Admin/all_books.jsp");
		}else {
			httpSession.setAttribute("failmsg", "Something Went Wrong......");
			response.sendRedirect("Admin/all_books.jsp");
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	 
	
	
	}

}
