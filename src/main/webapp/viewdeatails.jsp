<%@page import="com.entity.User"%>
<%@page import="com.entity.books_dtls"%>
<%@page import="com.DB.DBconnect"%>
<%@page import="com.DAO.Addbooksimpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>view Deatails</title>
<%@ include file="all_component/AllCss.jsp"%>
</head>
<body style="background-color: #dedcdc">
<%
    User u=(User)session.getAttribute("Userobj"); 
%>
	<%@ include file="all_component/navbar.jsp"%>
	<div class="container">
		<div class="row mt-3 p-4">
			<%
			int id = Integer.parseInt(request.getParameter("bid"));
			Addbooksimpl dao = new Addbooksimpl(DBconnect.getConnection());
			books_dtls b = dao.getBooks(id);
			%>
			<div class="col-md-6 text-center  p-5 border bg-white ">
				<img src="Books/<%=b.getPhotoName()%>"
					Style="height: 180px; width: 150px"><br>
				<h4 class="mt-2">
					Book Name: <span class="text-success"><%=b.getBook_name()%></span>
				</h4>
				<h4 class="mt-1">
					Author Name: <span class="text-success"><%=b.getAuthor()%></span>
				</h4>
				<h4 class="mt-1">
					Categries: <span class="text-success"><%=b.getBook_catogries()%></span>
				</h4>
			</div>

			<div class="col-md-6  text-center p-5  border bg-white">
				<h2><%=b.getBook_name()%></h2>
				<%
				if ("Old".equals(b.getBook_catogries())) {
				%>
				<h4 class="text-danger">Contact To Seller</h4>
				<h5 class="text-success">
					<i class="fa-solid fa-envelope"></i>Email:
					<%=b.getEmail()%></h5>

				<%
				}
				%>

				<div class="row mt-4">
					<div class="col-md-4 text-center text-danger p-2">
						<i class="fa-solid fa-money-bill-wave fa-2x"></i><br>
						<p>Cash On Delivery</p>
					</div>
					<div class="col-md-4 text-center text-danger p-2">
						<i class="fa-solid fa-rotate-left fa-2x"></i><br>
						<p>Return Available</p>
					</div>
					<div class="col-md-4 text-center text-danger p-2">
						<i class="fa-solid fa-truck fa-2x"></i><br>
						<p>Free Shipping</p>
					</div>
				</div>

				<%
				if ("Old".equals(b.getBook_catogries())) {
				%>
				<div class="text-center  mt-4">
					<a href="Index.jsp" class="btn btn-success me-2"><i
						class="fa-solid fa-cart-shopping"></i>Continue Shopping</a> <a href=""
						class="btn btn-danger"><%=b.getPrice() %><i
						class="fa-solid fa-indian-rupee-sign"></i></a>
				</div>
				<%
				} else {
				%>
				<div class="text-center  mt-5">
							<%
						if(u==null)
						{%>
							<a href="login.jsp" class="btn btn-primary me-2"><i
								class="fa-solid fa-cart-shopping"></i>Add Cart</a>
						<%}
						else
						{%>
							<a href="Cart?bid=<%=b.getBook_ID()%>&&uid=<%=u.getId() %>" class="btn btn-primary me-2"><i
								class="fa-solid fa-cart-shopping"></i>Add Cart</a>
						<%}
						%>
							
								<a href="#"
								class="btn btn-danger me-2"><%=b.getPrice() %> <i
								class="fa-solid fa-indian-rupee-sign"></i></a>
						</div>
				<%-- <div class="text-center  mt-4">
					<a href="" class="btn btn-primary me-2"><i
						class="fa-solid fa-cart-shopping"></i>Add To Cart</a> <a href=""
						class="btn btn-danger"><%=b.getPrice() %><i
						class="fa-solid fa-indian-rupee-sign"></i></a>
				</div>
 --%>
				<%
				}
				%>

			</div>

		</div>
	</div>
</body>
</html>