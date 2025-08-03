<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
       <%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="all_component/AllCss.jsp"%>

</head>
<body style="background-color:#dedcdc; display: flex; flex-direction: column; min-height: 100vh;">
<%@ include file="all_component/navbar.jsp"%>
    <div class="container p-2 mt-5" style="flex-grow: 1;">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card mt-4" >
					<div class=card-body>
						<h5 class="text-center">Login</h5>
						<c:if test="${not empty failmsg}">
						<p class="text-center text-danger">${failmsg}</p>
						<c:remove var="failmsg" scope="session"/>
						</c:if>
						
						<c:if test="${not empty succmsg}">
						<p class="text-center text-success">${succmsg}</p>
						<c:remove var="succmsg" scope="session"/>
						</c:if>
						
						<form action="login" method="post">
								<div class="mb-3">
									<label for="exampleInputEmail1" class="form-label">Email
										address</label> <input type="email" class="form-control"
										id="exampleInputEmail1" aria-describedby="emailHelp"  name="email">
									<div id="emailHelp" class="form-text"required="required"></div>
								</div>
								<div class="mb-3">
									<label for="exampleInputPassword1" class="form-label">Password</label>
									<input type="password" class="form-control"
										id="exampleInputPassword1"required="required" name="password">
								</div>
								<div class="text-center">
								<button type="submit" class="btn btn-primary">Submit</button><br><br>
								<a href="Register.jsp">Create Account</a>
								</div>
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