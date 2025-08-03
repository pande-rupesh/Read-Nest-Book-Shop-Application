<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration</title>
<%@ include file="all_component/AllCss.jsp"%>
</head>
<body style="background-color: #dedcdc">
	<%@ include file="all_component/navbar.jsp"%>

	<div class="container p-2 mt-2">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class=card-body>
						<h5 class="text-center">Register Here</h5>

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
						<!-- phone number msg -->

						<c:if test="${not empty phoneErrorMsg}">
							<p class="text-center text-danger">${phoneErrorMsg}</p>
							<c:remove var="phoneErrorMsg" scope="session" />
						</c:if>


						<form action="RegServlet" method="post">

							<div class="mb-3">
								<label for="exampleInputPassword1" class="form-label">Name</label>
								<input type="text" class="form-control"
									id="exampleInputPassword1" required="required" name="name"
									pattern="[A-Za-z\s]+" 
                                    title="Only letters and spaces are allowed">
							</div>
							<div class="mb-3">
								<label for="exampleInputEmail1" class="form-label">Email
									address</label> <input type="email" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp"
									name="email">
								<div id="emailHelp" class="form-text" required="required">We'll
									never share your email with anyone else.</div>
							</div>
							<div class="mb-3">
								<label for="exampleInputPassword1" class="form-label">Phone
									Number</label> <input type="number" class="form-control"
									id="exampleInputPassword1" required="required" name="phone">
							</div>
							<div class="mb-3">
								<label for="exampleInputPassword1" class="form-label">Password</label>
								<input type="password" class="form-control"
									id="exampleInputPassword1" required="required" name="password">
							</div>

							<!-- Address Information -->

							<div class="mb-3">
								<label for="exampleInputPassword1" class="form-label">House No,Building Name</label>
								<input type="text" class="form-control"
									id="exampleInputPassword1" required="required" name="hname">
							</div>
							<div class="mb-3">
								<label for="exampleInputEmail1" class="form-label">Road Name,Area,Colony
									</label> <input type="text" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp"
									name="rname" required="required">
		
							</div>
							<div class="mb-3">
								<label for="exampleInputPassword1" class="form-label">City
									</label> <input type="text" class="form-control"
									id="exampleInputPassword1" required="required" name="city"
									pattern="[A-Za-z\s]+" 
                                    title="Only letters and spaces are allowed">
							</div>
							<div class="mb-3">
								<label for="exampleInputEmail1" class="form-label">State
									</label> <input type="text" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp"
									required="required"
									name="state"
									pattern="[A-Za-z\s]+" 
                                    title="Only letters and spaces are allowed">
		
							</div>
							<div class="mb-3">
								<label for="exampleInputPassword1" class="form-label">Pincode
									</label> <input type="number" class="form-control" required="required"
									id="exampleInputPassword1" required="required" name="pincode">
							</div>
							<div class="mb-3 form-check">
								<input type="checkbox" class="form-check-input"
									id="exampleCheck1" name="cheack"> <label
									class="form-check-label" for="exampleCheck1">Agree
									term and Condition</label>
							</div>
							<button type="submit" class="btn btn-primary">Submit</button>
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="mt-5">
		<%@ include file="all_component/footer.jsp"%>
	</div>
</body>
</html>