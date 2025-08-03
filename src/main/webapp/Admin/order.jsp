<%@page import="com.user.servlet.Order2"%>
<%@page import="java.util.List"%>
<%@page import="com.DB.DBconnect"%>
<%@page import="com.mysql.cj.xdevapi.DbDoc"%>
<%@page import="com.DAO.OrderDAOimpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin:All Orders</title>
<%@ include file="AllCss.jsp"%>
</head>
<body style="background-color: #dedcdc">
<c:if test="${empty Userobj}">
<c:redirect url="login.jsp"></c:redirect>
</c:if>
	<%@ include file="navbar.jsp"%>
	<h2 class="text-center text-success">All Orders</h2>
	<table class="table">
		<thead class="bg-dark text-white">
			<tr>
				<th scope="col">Order Id</th>
				<th scope="col">User Id</th>
				<th scope="col">Name</th>
				<th scope="col">Email</th>
				<th scope="col">Address</th>
				<th scope="col">Phone No</th>
				<th scope="col">Book Name</th>
				<th scope="col">Author</th>
				<th scope="col">Price</th>
				<th scope="col">Payment Type</th>
				<th scope="col">Date</th>
			</tr>
		</thead>
		<%
		OrderDAOimpl dao=new OrderDAOimpl(DBconnect.getConnection());
		List<Order2> list=dao.GetAllOrder();
		for(Order2 o:list)
		{%>
			<tbody>
			
			<tr>
				<th scope="row"><%=o.getOrderid() %></th>
				<td><%=o.getUid() %></td>
				<td><%=o.getUsername() %></td>
				<td><%=o.getUseremail() %></td>
				<td><%=o.getAddress() %></td>
				<td><%=o.getUserphone() %></td>
				<td><%=o.getBookname() %></td>
				<td><%=o.getAuthor() %></td>
				<td><%=o.getPrice() %></td>
				<td><%=o.getPaymentype() %></td>
				<td><%=o.getDate()%></td>
			</tr>
			
		</tbody>
		<%}
		%>
		
	</table>
</body>
</html>