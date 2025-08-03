<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order Successfully</title>
<%@ include file="all_component/AllCss.jsp"%>
<style>
/* Ensure the page takes full height and footer sticks at the bottom */
html, body {
	height: 100%;
	margin: 0;
	display: flex;
	flex-direction: column;
}

.content {
	flex-grow: 1;
}
</style>
</head>
<body style="background-color: #dedcdc">
	<%@ include file="all_component/navbar.jsp"%>
<c:if test="${empty Userobj}">
<c:redirect url="login.jsp"></c:redirect>
</c:if>
	<!-- Wrap content in a div to push footer down -->
	<div class="content container-fluid text-center mt-5 p-5">
		<div class="text-center text-success">
			<i class="fa-solid fa-thumbs-up fa-4x"></i>
		</div>
		<h2>Congratulations, Your Order is Placed</h2>
		<h3>Your Order Will Reach You Within 7 Days</h3>
		<div>
		<a href="PrintInvoicespdf" class="btn btn-success">Print Bill</a>
			<a href="Index.jsp" class="btn btn-success">Home</a>
		</div>
	</div>

	<%@ include file="all_component/footer.jsp"%>
</body>
</html>
