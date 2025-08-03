<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Profile</title>
<%@ include file="all_component/AllCss.jsp"%>
</head>
<body style="background-color: #dedcdc">
	<%@ include file="all_component/navbar.jsp"%>
	<div class="container">
		<div class="row p-3">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="card-body">

						<h5 class="text-center">Edit Your Profile</h5>

						<!-- success msg -->

						<c:if test="${not empty Succmsg}">
							<p class="text-center text-success">${Succmsg}</p>
							<c:remove var="Succmsg" scope="session" />
						</c:if>
						<!-- Failure msg -->
						<c:if test="${not empty failmsg}">
							<p class="text-center text-success">${failmsg}</p>
							<c:remove var="failmsg" scope="session" />
						</c:if>

						<form action="UpdateUserServlet" method="post">
							<input type="hidden" value="${Userobj.id }" name="id">
							<div class="mb-3">
								<label for="exampleInputPassword1" class="form-label">Name</label>
								<input type="text" class="form-control"
									id="exampleInputPassword1" required="required" name="name"
									value="${Userobj.name }">
							</div>
							<div class="mb-3">
								<label for="exampleInputEmail1" class="form-label">Email
									address</label> <input type="email" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp"
									name="email" value="${Userobj.email }">
								<div id="emailHelp" class="form-text" required="required">We'll
									never share your email with anyone else.</div>
							</div>
							<div class="mb-3">
								<label for="exampleInputPassword1" class="form-label">Phone
									Number</label> <input type="number" class="form-control"
									id="exampleInputPassword1" required="required" name="phone"
									value="${Userobj.phone }">
							</div>
							<div class="mb-3">
								<label for="exampleInputPassword1" class="form-label">Password</label>
								<input type="number" class="form-control"
									id="exampleInputPassword1" required="required" name="password"
									value="${Userobj.password }">
							</div>
							<!-- <div class="mb-3 form-check">
								<input type="checkbox" class="form-check-input"
									id="exampleCheck1" name="cheack"> <label
									class="form-check-label" for="exampleCheck1">Agree
									term and Condition</label>
							</div> -->
							<div class="text-center">
								<button type="submit" class="btn btn-primary ">Update</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>