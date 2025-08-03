package com.user.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.DAO.CartDAOimpl;
import com.DB.DBconnect;

/**
 * Servlet implementation class RemoveFromCart
 */
@WebServlet("/remove")
public class RemoveFromCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int cid=Integer.parseInt(request.getParameter("cid"));
		int uid=Integer.parseInt(request.getParameter("uid"));
		
		CartDAOimpl cartDAOimpl=new CartDAOimpl(DBconnect.getConnection());
		boolean f=cartDAOimpl.removefromcart(cid, uid);
		HttpSession session=request.getSession();
		if (f) {
			session.setAttribute("succmsg", "Book Remove Successfully");
			response.sendRedirect("cart.jsp");
		} else {
			session.setAttribute("failmsg", "Something went Wrong On Server");
			response.sendRedirect("cart.jsp");
		}
	}

}
