package com.user.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.DAO.UserDAOImpl;
import com.DB.DBconnect;

/**
 * Servlet implementation class Removeuser
 */
@WebServlet("/Removeuser")
public class Removeuser extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("uid"));
		UserDAOImpl dao=new UserDAOImpl(DBconnect.getConnection());
		boolean f=dao.Removeuser(id);
		HttpSession httpSession=request.getSession();
		if (f) {
			httpSession.setAttribute("succmsg", "User Removed Successfully");
			response.sendRedirect("Admin/users.jsp");
		}
	}

}
