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
import com.entity.Cart;

@WebServlet("/Updatequantity")
public class Updatequantity extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        HttpSession httpSession = request.getSession();
        
        try {
            int cid = Integer.parseInt(request.getParameter("cid"));
            int uid = Integer.parseInt(request.getParameter("uid"));
            int bid = Integer.parseInt(request.getParameter("bid"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            double price = Double.parseDouble(request.getParameter("price"));

            // Validate quantity
            if (quantity <= 0) {
                httpSession.setAttribute("failmsg", "Quantity must be greater than zero.");
                response.sendRedirect("cart.jsp");
                return;
            }

            // Prepare Cart object
            Cart c = new Cart();
            c.setCid(cid);
            c.setBid(bid);
            c.setUid(uid);
            c.setQuantity(quantity);
            c.setTotalprice(price * quantity);

            // Update quantity in database
            CartDAOimpl dao = new CartDAOimpl(DBconnect.getConnection());
            boolean f = dao.updatequantity(c);

            if (f) {
                httpSession.setAttribute("succmsg", "Quantity updated successfully.");
            } else {
                httpSession.setAttribute("failmsg", "Failed to update quantity.");
            }
            
            response.sendRedirect("cart.jsp");

        } catch (NumberFormatException e) {
            httpSession.setAttribute("failmsg", "Invalid input format.");
            response.sendRedirect("cart.jsp");
        } catch (Exception e) {
            httpSession.setAttribute("failmsg", "Something went wrong: " + e.getMessage());
            response.sendRedirect("cart.jsp");
        }
    }
}
