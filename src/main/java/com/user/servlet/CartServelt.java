package com.user.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.DAO.Addbooksimpl;
import com.DAO.CartDAOimpl;
import com.DB.DBconnect;
import com.entity.Cart;
import com.entity.books_dtls;

/**
 * Servlet implementation class CartServelt
 */
@WebServlet("/Cart")
public class CartServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bid=Integer.parseInt(request.getParameter("bid"));
		int uid=Integer.parseInt(request.getParameter("uid"));
		
		Addbooksimpl dao=new Addbooksimpl(DBconnect.getConnection());
		books_dtls b=dao.getBooks(bid);
		
		Cart c=new Cart();
		c.setBid(bid);
		c.setUid(uid);
		c.setBookname(b.getBook_name());
		c.setAuthor(b.getAuthor());
		c.setPrice(Double.parseDouble(b.getPrice()));
		c.setTotalprice(Double.parseDouble(b.getPrice()));
		
		CartDAOimpl cart=new CartDAOimpl(DBconnect.getConnection());
		boolean f=cart.addCart(c);
		HttpSession httpSession=request.getSession();
		if (f) {
			httpSession.setAttribute("succmsg","Book Added To Cart");
			response.sendRedirect("newbook.jsp");
			
		}
		else {
			httpSession.setAttribute("failmsg","Something wrong on server");
			response.sendRedirect("newbook.jsp");
		}
	}

	
}
