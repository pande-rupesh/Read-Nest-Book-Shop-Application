package com.user.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.DAO.Addbooksimpl;
import com.DB.DBconnect;
import com.entity.books_dtls;

/**
 * Servlet implementation class deleteoldBook
 */
@WebServlet("/deleteoldBook")
public class deleteoldBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
   

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
		String email=request.getParameter("email");
		int id=Integer.parseInt(request.getParameter("bid"));
		
		books_dtls b=new books_dtls();
		Addbooksimpl dao=new Addbooksimpl(DBconnect.getConnection());
		boolean f=dao.deleteoldBook(email, "Old", id);
		 HttpSession httpSession=request.getSession();
		  if (f) {
			  httpSession.setAttribute("successmsg", "Book Delete Successfully......");
				response.sendRedirect("DeleteOldBookByUser.jsp");
		}else {
			httpSession.setAttribute("failmsg", "Something Went Wrong......");
			response.sendRedirect("DeleteOldBookByUser.jsp");
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	}
}

