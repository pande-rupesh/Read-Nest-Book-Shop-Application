<%@page import="com.user.servlet.Order2"%>
<%@page import="java.util.List"%>
<%@page import="com.DB.DBconnect"%>
<%@page import="com.DAO.OrderDAOimpl"%>
<%@page import="com.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>orders</title>
<%@ include file="all_component/AllCss.jsp"%>
</head>
<body style="background-color: #dedcdc">
<c:if test="${empty Userobj}">
<c:redirect url="login.jsp"></c:redirect>
</c:if>
	<%@ include file="all_component/navbar.jsp"%>
	<div class="container p-2">
		<table class="table table-striped bg-white">
		<h3 class="text-center">Your Orders</h3>
			<thead class="bg-dark text-white">
				<tr>
					<th scope="col">Order Id</th>
					<th scope="col">Book Name</th>
					<th scope="col">Author</th>
					<th scope="col">Price</th>
					<th scope="col">Payment Type</th>
				</tr>
			</thead>
			<%
			User u=(User)session.getAttribute("Userobj");
			OrderDAOimpl dao=new OrderDAOimpl(DBconnect.getConnection());
			List <Order2> list=dao.GetAllOrderofUser(u.getId());
			for(Order2 o:list)
			{%>
				
					<tbody>
				<tr>
					<th scope="row"><%=o.getOrderid() %></th>
					<td><%=o.getBookname() %></td>
					<td><%=o.getAuthor() %></td>
					<td><%=o.getPrice() %></td>
					<td><%=o.getPaymentype() %></td>
					
				</tr>
			</tbody>
				
			<% }
			%>
		
		</table>
	</div>
</body>
</html>