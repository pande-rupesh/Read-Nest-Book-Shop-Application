<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.DAO.Addbooksimpl"%>
<%@page import="java.util.List"%>
<%@page import="com.DB.DBconnect"%>
<%@ page import="com.DAO.Addbooksimpl"%>
<%@ page import="java.util.*"%>
<%@ page import="com.entity. books_dtls"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin:All Books</title>
<%@ include file="AllCss.jsp"%>
</head>
<body>
	<%@ include file="navbar.jsp"%>
	
	<c:if test="${empty Userobj }">
<c:redirect url="../login.jsp"/>
</c:if>

	<h2 class="text-center text-success">All Books</h2>

	<c:if test="${not empty successmsg}">
		<p class="text-center text-success">${successmsg}</p>
		<c:remove var="successmsg" scope="session" />
	</c:if>
	<!-- Failure msg -->
	<c:if test="${not empty failmsg}">
		<p class="text-center text-success">${failmsg}</p>
		<c:remove var="failmsg" scope="session" />
	</c:if>

	<table class="table">
		<thead class="bg-dark text-white">
			<tr>
				<th scope="col">ID</th>
				<th scope="col">Image</th>
				<th scope="col">Book Name</th>
				<th scope="col">Author</th>
				<th scope="col">Price</th>
				<th scope="col">Categories</th>
				<th scope="col">Status</th>
				<th scope="col">Action</th>
			</tr>
		</thead>
		<tbody>
			<%  
           Addbooksimpl dao=new Addbooksimpl(DBconnect.getConnection());
            List<books_dtls> list=dao.getallbooks();
              for(books_dtls b:list){    
        %>
			<tr>
				<td><%= b.getBook_ID() %></td>
				<td><img src="../Books/<%=b.getPhotoName()%>"
					style="width: 50px; height: sopx"></td>
				<td><%=b.getBook_name() %></td>
				<td><%= b.getAuthor() %></td>
				<td><%=b.getPrice() %></td>
				<td><%=b.getBook_catogries() %></td>
				<td><%=b.getStatus() %></td>
				<td><a href='editbook.jsp?id=<%=b.getBook_ID() %>'
					class="btn btn-sm btn-primary"><i class="fa-solid fa-pen-to-square"></i>Edit</a> 
					<a href='../deletebook?id=<%=b.getBook_ID() %>'class="btn btn-sm btn-danger"><i class="fa-solid fa-trash"></i>delete</a></td>
			</tr>
			<%
        }
  %>

		</tbody>
	</table>
</body>
</html>