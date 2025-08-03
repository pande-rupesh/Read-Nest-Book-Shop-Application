<%@page import="java.util.List"%>
<%@page import="com.entity.User"%>
<%@page import="com.DB.DBconnect"%>
<%@page import="com.DAO.UserDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Users</title>
<%@ include file="AllCss.jsp"%>
</head>
<body style="background-color: #dedcdc">
	<c:if test="${empty Userobj}">
		<c:redirect url="login.jsp"></c:redirect>
	</c:if>

	<%@ include file="navbar.jsp"%>
	<c:if test="${not empty succmsg }">
		<div class="alert alert-danger text-center" role="alert"
			style="font-size: 20px">${succmsg}</div>
		<c:remove var="succmsg" scope="session" />
	</c:if>
	<div class="container">
		<h2 class="text-center text-success">All Users</h2>
		<table class="table table-striped">
			<thead class="bg-dark text-white">
				<tr>
					<th scope="col">User_ID</th>
					<th scope="col">Name</th>
					<th scope="col">Email</th>
					<th scope="col">Phone</th>
					<th scope="col">Address</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<%
			UserDAOImpl dao = new UserDAOImpl(DBconnect.getConnection());
			List<User> list = dao.getallusers();
			for (User u : list) {
			%>
			<tbody>
				<tr>
					<th scope="row"><%=u.getId()%></th>
					<td><%=u.getName()%></td>
					<td><%=u.getEmail()%></td>
					<td><%=u.getPhone()%></td>
					<td><%=u.getFullAddressString()%></td>
					<td><a href="../Removeuser?uid=<%=u.getId()%>"
						class="btn btn-danger btn-sm">Remove_User</a></td>
				</tr>

			</tbody>
			<%
			}
			%>

		</table>
	</div>
</body>
</html>