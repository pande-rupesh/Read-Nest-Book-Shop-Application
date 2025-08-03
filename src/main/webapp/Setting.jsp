<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Setting</title>
<%@ include file="all_component/AllCss.jsp"%>
<style type="text/css">
a {
	text-decoration: none;
	color: black;
}

a:hover {
	text-decoration: none;
}
</style>
</head>
<body style="background-color: #dedcdc">
	<%@ include file="all_component/navbar.jsp"%>
<c:if test="${empty Userobj}">
<c:redirect url="login.jsp"></c:redirect>
</c:if>
	<div class="container">
		<div class="text-center">
			<h2>Hello,${Userobj.name}</h2>
		</div>
		<div class="row p-4">
			<div class="col-md-4">
				<a href="Sell_old_book.jsp">
					<div class="card text-center">
						<div class="card-body">
							<div class="text-primary">
								<i class="fa-solid fa-book-open fa-3x"></i>
							</div>
							<h3>Sell Old Book</h3>
						</div>
					</div>
				</a>
			</div>
			<div class="col-md-4">
				<a href="DeleteOldBookByUser.jsp">
					<div class="card text-center">
						<div class="card-body">
							<div class="text-danger">
								<i class="fa-solid fa-book-open fa-3x"></i>
							</div>
							<h3>Delete Your Old Book</h3>
						</div>
					</div>
				</a>
			</div>
			<div class="col-md-4">
				<a href="Edit_profile.jsp">
					<div class="card text-center">
						<div class="card-body">
							<div class="text-primary">
								<i class="fa-solid fa-book fa-3x"></i>
							</div>
							<h3>Login & Security(Edit Profile)</h3>
						</div>
					</div>
				</a>
			</div>
			<div class="col-md-6 mt-4 p-5">
				<a href="order.jsp">
					<div class="card text-center">
						<div class="card-body">
							<div class="text-danger">
								<i class="fa-solid fa-box-open fa-3x"></i>
							</div>
							<h3>My Order</h3>
							<p>Trace Your Order</p>
						</div>
					</div>
				</a>
			</div>
			<div class="col-md-6 mt-4 p-5">
				<a href="help.jsp">
					<div class="card text-center">
						<div class="card-body">
							<div class="text-primary">
								<i class="fa-solid fa-user-circle fa-3x"></i>
							</div>
							<h3>Help Center</h3>
							<p>24 * 7</p>
						</div>
					</div>
				</a>
			</div>
		</div>
	</div>
		<%-- <div class="mt-5">
		<%@ include file="all_component/footer.jsp"%>
	</div> --%>
	
</body>
</html>