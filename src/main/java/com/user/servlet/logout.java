package com.user.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class logout
 */
@WebServlet("/logout")
public class logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			HttpSession httpSession=request.getSession();
			httpSession.removeAttribute("Userobj");
			
			HttpSession session=request.getSession();
			session.setAttribute("succmsg", "Logout Successfully..");
			response.sendRedirect("login.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
}
