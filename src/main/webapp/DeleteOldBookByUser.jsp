<%@page import="com.entity.books_dtls"%>
<%@page import="java.util.List"%>
<%@page import="com.DB.DBconnect"%>
<%@page import="com.DAO.Addbooksimpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%@page import="com.entity.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DeleteOldBookByUser.jsp</title>
<%@ include file="all_component/AllCss.jsp"%>
</head>
<body style="background-color: #dedcdc">
	<%@ include file="all_component/navbar.jsp"%>
	<c:if test="${not empty successmsg}">
			<div class="alert alert-success text-center">${successmsg}</div>
			<c:remove var="successmsg" scope="session" />
		</c:if>
		<!-- Failure msg -->
		<c:if test="${not empty failmsg}">
			<div class="alert alert-danger text-center">${failmsg}</div>
			<c:remove var="failmsg" scope="session" />
		</c:if>
	<div class="container p-3">
		
		<table class="table table-striped bg-white">
			<thead class="bg-dark text-white">
				<tr>
					<th scope="col">Book Name</th>
					<th scope="col">Author</th>
					<th scope="col">Price</th>
					<th scope="col">Categories</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
				<%
				User u = (User) session.getAttribute("Userobj");
				String email = u.getEmail();
				Addbooksimpl dao = new Addbooksimpl(DBconnect.getConnection());
				List<books_dtls> list = dao.DeleteOldBookByUser(email, "Old");
				for (books_dtls b : list) {
				%>
				<tr>
					<th><%=b.getBook_name()%></th>
					<td><%=b.getAuthor()%></td>
					<td><%=b.getPrice()%></td>
					<td><%=b.getBook_catogries()%></td>
					<td>
						<div>
							<!--  <a href='EditBookByUser.jsp?id=<%=b.getBook_ID() %>'
					class="btn btn-sm btn-primary"><i class="fa-solid fa-pen-to-square"></i>Edit</a>--> <a
								href="deleteoldBook?email=<%=email%>&&bid=<%=b.getBook_ID()%>"
								class="btn btn-danger btn-sm">Delete</a>
						</div>
					</td>
				</tr>

				<%
				}
				%>
			</tbody>
		</table>
	</div>
</body>
</html>