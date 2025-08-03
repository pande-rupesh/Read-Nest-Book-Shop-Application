package com.user.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.DAO.CartDAOimpl;
import com.DAO.OrderDAOimpl;
import com.DB.DBconnect;
import com.entity.Cart;
import com.entity.User;
import com.mysql.cj.Session;
import com.mysql.cj.protocol.a.NativeConstants.IntegerDataType;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Servlet implementation class Order
 */
@WebServlet("/Order")
public class Order extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession httpSession = request.getSession();

		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String cheack = request.getParameter("cheack");
		String password = request.getParameter("password");
		String address = request.getParameter("hname");
		String landmark = request.getParameter("rname");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String pincode = request.getParameter("pincode");
		String payment = request.getParameter("payment");
		

		// System.out.println(name+" "+payment);

		String fullAddress = address + "," + landmark + "," + city + "," + state + "," + pincode;

		CartDAOimpl dao = new CartDAOimpl(DBconnect.getConnection());
		List<Cart> list = dao.AllOrderdBooksOfUser(id);

		if (list.isEmpty()) {
			httpSession.setAttribute("succmsg", "Please Add Books To Cart");
			response.sendRedirect("cart.jsp");

		} else {
			OrderDAOimpl dao2 = new OrderDAOimpl(DBconnect.getConnection());

			Order2 order2 = null;

			ArrayList<Order2> list2 = new ArrayList<Order2>();

			Random r = new Random();
			
			 int maxorderid=dao2.getMaxOrderId()+1;
			 //System.out.println(maxorderid);
//		   order2=new Order2();
//		    order2.setUid(id);
			for (Cart c : list) {
				order2 = new Order2();
				order2.setUid(id);
				order2.setOrderid(maxorderid);
				order2.setUsername(name);
				order2.setUseremail(email);
				order2.setUserphone(phone);
				order2.setBookname(c.getBookname());
				order2.setAuthor(c.getAuthor());
				order2.setPrice(c.getTotalprice()+"");
				order2.setAddress(fullAddress);
				order2.setPaymentype(payment);
				order2.setDate(new Timestamp(System.currentTimeMillis())); // Set current date & time
				order2.setQuantity(c.getQuantity());
				list2.add(order2);
			}

			if ("noselect".equals(payment)) {
				httpSession.setAttribute("succmsg", "Please Choose The Payment Option");
				response.sendRedirect("cart.jsp");
			} else {
				boolean f = dao2.Saveorders(list2);
				if (f) {
					boolean f3=dao2.clearcart(id);
					if (f3) {
						
						response.sendRedirect("Order_success.jsp");
					}
					else {
						httpSession.setAttribute("succmsg", "Something went Wrong");
						response.sendRedirect("cart.jsp");
					}
					
				} else {
					httpSession.setAttribute("succmsg", "Something went Wrong");
					response.sendRedirect("cart.jsp");
				}
			}
		}
	}

}



//package com.user.servlet;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//
//import java.io.IOException;
//import java.sql.Timestamp;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Random;
//
//import com.DAO.CartDAOimpl;
//import com.DAO.OrderDAOimpl;
//import com.DB.DBconnect;
//import com.entity.Cart;
//import com.user.servlet.*;
//
//@WebServlet("/Order")
//public class Order extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//
//		HttpSession httpSession = request.getSession();
//
//		// Collect user and address details
//		int id = Integer.parseInt(request.getParameter("id"));
//		String name = request.getParameter("name");
//		String email = request.getParameter("email");
//		String phone = request.getParameter("phone");
//		String address = request.getParameter("hname");
//		String landmark = request.getParameter("rname");
//		String city = request.getParameter("city");
//		String state = request.getParameter("state");
//		String pincode = request.getParameter("pincode");
//		String payment = request.getParameter("payment");
//
//		String razorpayPaymentId = request.getParameter("razorpay_payment_id");
//
//		String fullAddress = address + ", " + landmark + ", " + city + ", " + state + ", " + pincode;
//
//		CartDAOimpl dao = new CartDAOimpl(DBconnect.getConnection());
//		List<Cart> cartList = dao.AllOrderdBooksOfUser(id);
//
//		if (cartList.isEmpty()) {
//			httpSession.setAttribute("succmsg", "Please Add Books To Cart");
//			response.sendRedirect("cart.jsp");
//			return;
//		}
//
//		OrderDAOimpl dao2 = new OrderDAOimpl(DBconnect.getConnection());
//
//		ArrayList<Order2> orderList = new ArrayList<>();
//		int maxOrderId = dao2.getMaxOrderId() + 1;
//
//		for (Cart c : cartList) {
//			Order2 order = new Order2();
//			order.setUid(id);
//			order.setOrderid(maxOrderId);
//			order.setUsername(name);
//			order.setUseremail(email);
//			order.setUserphone(phone);
//			order.setBookname(c.getBookname());
//			order.setAuthor(c.getAuthor());
//			order.setPrice(String.valueOf(c.getTotalprice()));
//			order.setAddress(fullAddress);
//			order.setQuantity(c.getQuantity());
//			order.setDate(new Timestamp(System.currentTimeMillis()));
//
//			// Set payment type later based on logic
//			orderList.add(order);
//		}
//
//		if ("noselect".equals(payment)) {
//			httpSession.setAttribute("succmsg", "Please Choose The Payment Option");
//			response.sendRedirect("cart.jsp");
//
//		} else if ("UPI".equals(payment) && razorpayPaymentId != null && !razorpayPaymentId.trim().isEmpty()) {
//			// ✅ Razorpay Payment Success
//			for (Order2 o : orderList) {
//				o.setPaymentype("Razorpay - " + razorpayPaymentId);
//			}
//			boolean saved = dao2.Saveorders(orderList);
//			if (saved) {
//				dao2.clearcart(id);
//				response.sendRedirect("Order_success.jsp");
//			} else {
//				httpSession.setAttribute("succmsg", "Something went wrong while placing the order.");
//				response.sendRedirect("cart.jsp");
//			}
//
//		} else if ("COD".equals(payment)) {
//			// ✅ Cash on Delivery
//			for (Order2 o : orderList) {
//				o.setPaymentype("Cash On Delivery");
//			}
//			boolean saved = dao2.Saveorders(orderList);
//			if (saved) {
//				dao2.clearcart(id);
//				response.sendRedirect("Order_success.jsp");
//			} else {
//				httpSession.setAttribute("succmsg", "Something went wrong while placing the order.");
//				response.sendRedirect("cart.jsp");
//			}
//
//		} else {
//			// ❌ Invalid or missing payment information
//			httpSession.setAttribute("succmsg", "Payment failed or missing details.");
//			response.sendRedirect("cart.jsp");
//		}
//	}
//}




//package com.user.servlet;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//
//import java.io.IOException;
//import java.sql.Timestamp;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Random;
//
//import com.DAO.CartDAOimpl;
//import com.DAO.OrderDAOimpl;
//import com.DB.DBconnect;
//import com.entity.Cart;
//import com.user.servlet.*;
//
//@WebServlet("/Order")
//public class Order extends HttpServlet {
//    private static final long serialVersionUID = 1L;
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        HttpSession session = request.getSession();
//
//        int id = Integer.parseInt(request.getParameter("id"));
//        String name = request.getParameter("name");
//        String email = request.getParameter("email");
//        String phone = request.getParameter("phone");
//        String address = request.getParameter("hname");
//        String landmark = request.getParameter("rname");
//        String city = request.getParameter("city");
//        String state = request.getParameter("state");
//        String pincode = request.getParameter("pincode");
//        String paymentType = request.getParameter("payment");
//
//        String razorpayPaymentId = request.getParameter("razorpay_payment_id"); // From Razorpay
//
//        // Combine address
//        String fullAddress = address + ", " + landmark + ", " + city + ", " + state + ", " + pincode;
//
//        CartDAOimpl cartDAO = new CartDAOimpl(DBconnect.getConnection());
//        List<Cart> cartList = cartDAO.AllOrderdBooksOfUser(id);
//
//        if (cartList.isEmpty()) {
//            session.setAttribute("succmsg", "Cart is empty.");
//            response.sendRedirect("cart.jsp");
//            return;
//        }
//
//        OrderDAOimpl orderDAO = new OrderDAOimpl(DBconnect.getConnection());
//        int orderId = orderDAO.getMaxOrderId() + 1;
//        ArrayList<Order2> orderList = new ArrayList<>();
//
//        for (Cart c : cartList) {
//            Order2 order = new Order2();
//            order.setUid(id);
//            order.setOrderid(orderId);
//            order.setUsername(name);
//            order.setUseremail(email);
//            order.setUserphone(phone);
//            order.setBookname(c.getBookname());
//            order.setAuthor(c.getAuthor());
//            order.setPrice(c.getTotalprice() + "");
//            order.setAddress(fullAddress);
//            order.setPaymentype(paymentType);
//            order.setDate(new Timestamp(System.currentTimeMillis()));
//            order.setQuantity(c.getQuantity());
//
//            orderList.add(order);
//        }
//
//        boolean saved = orderDAO.Saveorders(orderList);
//        boolean cleared = orderDAO.clearcart(id);
//
//        if (saved && cleared) {
//            response.sendRedirect("Order_success.jsp");
//        } else {
//            session.setAttribute("succmsg", "Something went wrong during order processing.");
//            response.sendRedirect("cart.jsp");
//        }
//    }
//}
//

