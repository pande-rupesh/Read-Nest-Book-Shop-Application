package com.user.servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.DAO.OrderDAOimpl;
import com.DB.DBconnect;
import com.user.servlet.*;

@WebServlet("/PrintInvoicespdf")
public class PrintInvoicespdf extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get maxOrderId from DAO
        OrderDAOimpl orderDAO = new OrderDAOimpl(DBconnect.getConnection());
        int maxOrderId = orderDAO.getMaxOrderId();

        if (maxOrderId == 0) {
            response.getWriter().write("No recent order found.");
            return;
        }

        // Fetch order details
        List<Order2> orderList = orderDAO.getOrdersByOrderId(maxOrderId);

        if (orderList.isEmpty()) {
            response.getWriter().write("No order details found.");
            return;
        }

        // Generate PDF
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=invoice_" + maxOrderId + ".pdf");

        try (OutputStream out = response.getOutputStream()) {
            PdfWriter writer = new PdfWriter(out);
            PdfDocument pdfDoc = new PdfDocument(writer);
            Document document = new Document(pdfDoc);

            // Add Invoice Header
            document.add(new Paragraph("Book Store Invoice").setBold().setFontSize(18));
            document.add(new Paragraph("Order ID: " + maxOrderId).setBold());
            document.add(new Paragraph("Order Date: " + orderList.get(0).getDate().toString()));

            // Add Customer Details
            document.add(new Paragraph("\nCustomer Details:"));
            document.add(new Paragraph("Name: " + orderList.get(0).getUsername()));
            document.add(new Paragraph("Email: " + orderList.get(0).getUseremail()));
            document.add(new Paragraph("Phone: " + orderList.get(0).getUserphone()));
            document.add(new Paragraph("Address: " + orderList.get(0).getAddress()));

            // Create Table for Order Details
            float[] columnWidths = {140F, 90F,20F, 50F, 70F};
            Table table = new Table(columnWidths);
            table.addCell("Book Name");
            table.addCell("Author");
            table.addCell("Quantity");
            table.addCell("Price");
            table.addCell("Payment Type");

            double totalAmount = 0.0;
            int totalQuantity=0;
            for (Order2 order : orderList) {
                table.addCell(order.getBookname());
                table.addCell(order.getAuthor());
                table.addCell(String.valueOf(order.getQuantity()));
                table.addCell(order.getPrice());
                table.addCell(order.getPaymentype());
                
                // Corrected total price calculation
                totalQuantity+=order.getQuantity();
                totalAmount += Double.parseDouble(order.getPrice());
            }
            document.add(table);
            document.add(new Paragraph("\nTotal Quantity: " + totalQuantity).setBold());
            document.add(new Paragraph("\nTotal Amount: " + totalAmount).setBold());

            // Thank you note
            document.add(new Paragraph("\nThank you for shopping with us!"));

            document.close();
        }
    }
}
