<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
       <%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Admin: Add Books</title>
<%@ include file="AllCss.jsp"%>
</head>
<body style="background-color: #dedcdc;">
	<%@ include file="navbar.jsp"%>
	<c:if test="${empty Userobj }">
<c:redirect url="../login.jsp"/>
</c:if>
	<div class="container">
		<div class="row p-2">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="card-body">
						<h5 class="text-center text-primary">Add Books</h5>
						
							<c:if test="${not empty successmsg}">
						<p class="text-center text-success">${successmsg}</p>
						<c:remove var="successmsg" scope="session"/>
						</c:if>
						<!-- Failure msg -->
						<c:if test="${not empty failmsg}">
						<p class="text-center text-success">${failmsg}</p>
						<c:remove var="failmsg" scope="session"/>
						</c:if>
						
						<form action="../addbooks" method="post"
						   enctype="multipart/form-data">
							<div class="mb-3">
								<label for="exampleInputPassword1" class="form-label">Name</label>
								<input type="text" class="form-control"
									id="exampleInputPassword1" required="required" name="bname"
									pattern="[A-Za-z\s]+" 
                                    title="Only letters and spaces are allowed">
							</div>
							<div class="mb-3">
								<label for="exampleInputEmail1" class="form-label">Author
									Name </label> <input type="text" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp"
									name="Aname"
									pattern="[A-Za-z\s]+" 
                                    title="Only letters and spaces are allowed">

							</div>
							<div class="mb-3">
								<label for="exampleInputPassword1" class="form-label">Price
								</label> <input type="number" class="form-control"
									id="exampleInputPassword1" required="required" name="price" min="1">
							</div>
							<div class="mb-3">
								<select class="form-select" aria-label="Default select example" name="btype">
									<option selected>Book categories</option>
									<option value="New">New Book</option>

								</select>
							</div>
							<div class="mb-3">
								<select class="form-select" aria-label="Default select example" name="sts">
									<option selected>Book Status</option>
									<option value="Active">Active</option>
									<option value="Inactive">Inactive</option>
								</select>
							</div>

							<div class="mb-3">
								<label for="formFile" class="form-label">Choose Image</label> <input
									class="form-control" type="file" id="formFile" name="bimg">
							</div>
							<button type="submit" class="btn btn-primary">Add</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	dsfghjk
</body>
</html>