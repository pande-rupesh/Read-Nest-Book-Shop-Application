package com.user.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import com.DAO.UserDAOImpl;
import com.DB.DBconnect;
import com.entity.User;

/**
 * Servlet implementation class Loginservlet
 */
@WebServlet("/login")
public class Loginservlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter printWriter=response.getWriter();
			String email=request.getParameter("email");
			String password=request.getParameter("password");
			printWriter.print(email);
			printWriter.print(password);
			
			UserDAOImpl dao=new UserDAOImpl(DBconnect.getConnection());
			HttpSession httpSession=request.getSession();
			
			if ("admin@gmail.com".equals(email) && "admin".equals(password)) {
				User us=new User();
				us.setName("Admin");
				httpSession.setAttribute("Userobj", us);
				response.sendRedirect("Admin/AdminHome.jsp");
			}
			
			else {
				 User us=dao.login(email, password);
				 
				 if (us!=null) {
					httpSession.setAttribute("Userobj", us);
					response.sendRedirect("Index.jsp");
				}
				 else {
					httpSession.setAttribute("failmsg", "Invalid Email and Password");
					response.sendRedirect("login.jsp");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
