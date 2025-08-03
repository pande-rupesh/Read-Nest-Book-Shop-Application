package com.user.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.jar.Attributes.Name;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.spi.RegisterableService;

import com.DAO.UserDAOImpl;
import com.DB.DBconnect;
import com.entity.User;

/**
 * Servlet implementation class RegServlet
 */
@WebServlet("/RegServlet")
public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			
           PrintWriter printWriter=response.getWriter();
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		String cheack=request.getParameter("cheack");
		String password=request.getParameter("password");
		String address=request.getParameter("hname");
		String landmark=request.getParameter("rname");
		String city=request.getParameter("city");
		String state=request.getParameter("state");
		String pincode=request.getParameter("pincode");
		 
		 
	//----------------------------
		
		 UserDAOImpl dao1=new UserDAOImpl(DBconnect.getConnection());
		 boolean f2=dao1.isemailexits(email);
		 if(f2)
		 {
			 HttpSession httpSession = request.getSession();
				httpSession.setAttribute("failmsg", "Email is already registered.");
				response.sendRedirect("Register.jsp");
				return; // Exit the method early if email is already exists;
		 }
	//---------------------------------
		 
		 boolean f1=dao1.isphoneexits(phone);
		 if(f1)
		 {
			 HttpSession httpSession = request.getSession();
				httpSession.setAttribute("failmsg", "Phone is already registered.");
				response.sendRedirect("Register.jsp");
				return; // Exit the method early if Phone is already exists;
		 }
		 
	//--------------------------------------	 
		 
		 if (phone == null || !isValidPhoneNumber(phone)) {
             HttpSession httpSession = request.getSession();
             httpSession.setAttribute("failmsg", "Please enter a valid 10 digit phone number.");
             response.sendRedirect("Register.jsp");
             return; // Exit the method early if phone number is invalid
         }
		 
  //------------------------------------------		 
		 
		User us=new User();
		us.setName(name);
		us.setEmail(email);
		us.setPhone(phone);
		us.setPassword(password);
		us.setAddress(address);
		us.setLandmark(landmark);
		us.setCity(city);
		us.setState(state);
		us.setPincode(pincode);
		
		HttpSession httpSession=request.getSession();
		if (cheack != null) {
			UserDAOImpl dao = new UserDAOImpl(DBconnect.getConnection());
			boolean f = dao.RegisterUser(us);

			if (f) {
				
				httpSession.setAttribute("Succmsg", "Registration Sucessfull...");
				response.sendRedirect("Register.jsp");
				
			} else {
				printWriter.print("Data not insert Succesfully");

				httpSession.setAttribute("failmsg", "Somting went wrong on server");
				response.sendRedirect("Register.jsp");
			}
		}
		else {
			httpSession.setAttribute("failmsg", "Please Agree terms And Condition");
			response.sendRedirect("Register.jsp");
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
}
	//----------------------------------
	 private boolean isValidPhoneNumber(String phone) {
	        // Regular expression to check if phone number is exactly 10 digits
	        String regex = "^[0-9]{10}$";
	        Pattern pattern = Pattern.compile(regex);
	        Matcher matcher = pattern.matcher(phone);
	        return matcher.matches();
	    }
}
