package com.user.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.DAO.Addbooksimpl;
import com.DAO.UserDAOImpl;
import com.DB.DBconnect;
import com.entity.User;

/**
 * Servlet implementation class UpdateUserServlet
 */
@WebServlet("/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int id=Integer.parseInt(request.getParameter("id"));
			String name=request.getParameter("name");
			String email=request.getParameter("email");
			String phone=request.getParameter("phone");
			String password=request.getParameter("password");
		   
			User user=new User();
			user.setId(id);
			user.setName(name);
			user.setEmail(email);
			user.setPhone(phone);
			user.setPassword(password);
			
			UserDAOImpl dao=new UserDAOImpl(DBconnect.getConnection());
			boolean f=dao.UpdateUserServlet(user);
			 
			HttpSession httpSession=request.getSession();
			
             if (f) {
				
				httpSession.setAttribute("Succmsg", "Data Update Successfully");
				response.sendRedirect("Register.jsp");
				
			} else {

				httpSession.setAttribute("failmsg", "Somting went wrong on server");
				response.sendRedirect("Register.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
