<%@page import="com.DAO.Addbooksimpl"%>
<%@page import="com.DB.DBconnect"%>
<%@page import="com.entity.books_dtls"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin: Add Books</title>
<%@ include file="AllCss.jsp"%>
</head>
<body style="background-color: #dedcdc;">
	<%@ include file="navbar.jsp"%>
	<div class="container">
		<div class="row p-2">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="card-body">
						<h5 class="text-center text-primary">Edit Books</h5>

						<%
						  int id=Integer.parseInt(request.getParameter("id"));
						  Addbooksimpl dao=new Addbooksimpl(DBconnect.getConnection());
						  books_dtls b=dao.getBooks(id);
						  
						%>

						<form action="../editbook" method="post">
							<!--  enctype="multipart/form-data">-->
							<input type="hidden" name="id" value=<%=b.getBook_ID()%>>
							<div class="mb-3">
								<label for="exampleInputPassword1" class="form-label">Name</label>
								<input type="text" class="form-control"
									id="exampleInputPassword1" required="required" name="bname"
									value="<%=b.getBook_name() %>"
									pattern="[A-Za-z\s]+" 
                                    title="Only letters and spaces are allowed">
							</div>
							<div class="mb-3">
								<label for="exampleInputEmail1" class="form-label">Author
									Name </label> <input type="text" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp"
									name="Aname" value="<%=b.getAuthor() %>"
									pattern="[A-Za-z\s]+" 
                                    title="Only letters and spaces are allowed">

							</div>
							<div class="mb-3">
								<label for="exampleInputPassword1" class="form-label">Price
								</label> <input type="number" class="form-control"
									id="exampleInputPassword1" required="required" name="price" min="1"
									value="<%=b.getPrice() %>">
							</div>
							<div class="mb-3">
								<select class="form-select" aria-label="Default select example"
									name="sts">
									<%
									if("Active".equals(b.getStatus()))
									{%>
										<option value="Active">Active</option>
										<option value="Inactive">Inactive</option>
									<% }else
									{%>
									    <option value="Inactive">inactive</option>
										<option value="Active">Active</option>
										
									<% }
									
									%>
									
								</select>
							</div>

							<!--  <div class="mb-3">
								<label for="formFile" class="form-label">Choose Image</label> <input
									class="form-control" type="file" id="formFile" name="bimg">
							</div>-->
							<button type="submit" class="btn btn-primary">Update</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>