<%@page import="com.entity.Cart"%>
<%@page import="java.util.List"%>
<%@page import="com.DAO.CartDAOimpl"%>
<%@page import="com.DB.DBconnect"%>
<%@page import="com.DAO.Addbooksimpl"%>
<%@page import="com.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cart</title>
<%@ include file="all_component/AllCss.jsp"%>
</head>
<body style="background-color: #dedcdc">
	<%@ include file="all_component/navbar.jsp"%>

	<%-- <c:if test="${orderSuccess}">
        <div class="container-fluid text-center mt-5 p-5">
            <div class="text-center text-success">
                <i class="fa-solid fa-thumbs-up fa-4x"></i>
            </div>
            <h2>Congratulations, Your Order is Placed</h2>
            <h3>Your Order Will Reach You Within 7 Days</h3>
            <div>
                <a href="#" class="btn btn-success">Print Bill</a>
                <a href="Index.jsp" class="btn btn-success">Home</a>
            </div>
        </div>
        <c:remove var="orderSuccess" scope="session"/>
    </c:if>
 --%>

	<c:if test="${not empty succmsg }">
		<div class="alert alert-danger text-center" role="alert"
			style="font-size: 20px">${succmsg}</div>
		<c:remove var="succmsg" scope="session" />
	</c:if>

	<c:if test="${empty failmsg }">
		<p>${failmsg}</p>
		<c:remove var="failmsg" scope="session" />
	</c:if>

	<!--<c:if test="${not empty fail }">
	<div class="alert alert-danger text-center" role="alert" style="font-size:20px">
      ${fail}</div>
   <c:remove var="fail" scope="session"/>
	</c:if>-->


	<%
	User u = (User) session.getAttribute("Userobj");
	%>
	<c:if test="${empty Userobj}">
		<c:redirect url="login.jsp"></c:redirect>
	</c:if>
	<div class="container">
		<div class="row p-1">
			<div class="col-md-6">
				<div class="card bg-white">
					<div class="card-body">
						<h3 class="text-center text-success">Your Order's</h3>
						<table class="table table table-hover">
							<thead>
								<tr>
									<th scope="col">Book Name</th>
									<th scope="col">Author</th>
									<th scope="col">Quantity</th>
									<th scope="col">Price</th>
									<th scope="col">Action</th>
								</tr>
							</thead>

							<%
							User user = (User) session.getAttribute("Userobj");
							CartDAOimpl dao = new CartDAOimpl(DBconnect.getConnection());
							List<Cart> carts = dao.AllOrderdBooksOfUser(user.getId());
							Double totalprice = 0.00;
							for (Cart c : carts) {
								totalprice = c.getTotalcartprice();
							%>

							<tbody>
								<tr>
									<th scope="row"><%=c.getBookname()%></th>
									<td><%=c.getAuthor()%></td>
									<td>
										<form action="Updatequantity" method="post">
											<input type="hidden" name="cid" value="<%=c.getCid()%>">
											<input type="hidden" name="uid" value="<%=user.getId()%>">
											<input type="hidden" name="bid" value="<%=c.getBid()%>">
											<input type="hidden" name="price" value="<%=c.getPrice()%>">
											<input type="number" name="quantity"
												value="<%=c.getQuantity()%>" min="1" max="5"
												class="form-control" style="width: 53px; display: inline;">
											<button type="submit" class="btn btn-sm btn-primary">Update</button>
										</form>
									</td>
									<td><%=c.getTotalprice()%></td>
									<td><a
										href="remove?cid=<%=c.getCid()%>&&uid=<%=user.getId()%>"
										class="btn btn-sm btn-danger">Remove</a></td>
								</tr>

							</tbody>
							<%
							}
							%>
							<tr>
								<td class="text-primary fw-bold">Total Price</td>


								<td></td>
								<td></td>
								<td><%=totalprice%></td>
							</tr>
						</table>
					</div>
				</div>
			</div>
			<div class="col-md-6">
				<div class="card bg-white">
					<div class="card-body">
						<h3 class="text-center text-success">Address Details</h3>
						<!-- <form action="Order" method="post" class="row g-3">  
						<form action="Order" method="post" class="row g-3" -->
						<form action="Order" method="post" class="row g-3" id="orderForm">
							<input type="hidden" value="<%=u.getId()%>" name="id">
							<div class="col-md-6">
								<label for="inputEmail4" class="form-label">Name</label> <input
									type="text" class="form-control" id="inputEmail4" name="name"
									value="<%=u.getName()%>">
							</div>
							<div class="col-md-6">
								<label for="inputPassword4" class="form-label">Email</label> <input
									type="email" class="form-control" id="inputPassword4"
									name="email" value="<%=u.getEmail()%>">
							</div>

							<div class="col-md-6">
								<label for="inputEmail4" class="form-label">Phone</label> <input
									type="number" class="form-control" id="inputEmail4"
									name="phone" value="<%=u.getPhone()%>">
							</div>
							<div class="col-md-6">
								<label for="inputPassword4" class="form-label">House
									No,Building Name</label> <input type="text" class="form-control"
									id="inputPassword4" name="hname" value="<%=u.getAddress()%>">
							</div>

							<div class="col-md-6">
								<label for="inputEmail4" class="form-label">Road
									Name,Area,Colony</label> <input type="text" class="form-control"
									id="inputEmail4" name="rname" value="<%=u.getLandmark()%>">
							</div>
							<div class="col-md-6">
								<label for="inputPassword4" class="form-label">City</label> <input
									type="Text" class="form-control" id="inputPassword4"
									name="city" value="<%=u.getCity()%>">
							</div>

							<div class="col-md-6">
								<label for="inputEmail4" class="form-label">State</label> <input
									type="text" class="form-control" id="inputEmail4" name="state"
									value="<%=u.getState()%>">
							</div>
							<div class="col-md-6">
								<label for="inputPassword4" class="form-label">Pin-Code</label>
								<input type="number" class="form-control" id="inputPassword4"
									value="<%=u.getPincode()%>" name="pincode">
							</div>
							<select class="form-select" aria-label="Default select example"
								name="payment">
								<option selected value="noselect">--Payment Type--</option>
								<option value="COD">Cash On Delivery</option>
								<!-- <option value="Rozer">RozerPay</option> -->
								<option value="UPI">Online Payment(UPI)</option>
							</select>
							<div class="text-center">
								<button class="btn btn-warning">Order Now</button>
								<a href="Index.jsp" class="btn btn-success">Continue
									Shopping</a>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="https://checkout.razorpay.com/v1/checkout.js"></script>
<script>
    document.querySelector("#orderForm").addEventListener("submit", function (e) {
        const paymentMethod = document.querySelector('select[name="payment"]').value;

        if (paymentMethod === "UPI") {
            e.preventDefault(); // Stop default form submit

            var options = {
                "key": "rzp_test_tXEC55kfkKYXoI", // Replace with your actual Razorpay key
                "amount": <%=totalprice * 100%>, // Replace with dynamic amount (50000 paise = ₹500)
                "currency": "INR",
                "name": "BookStore Payment",
                "description": "Book Purchase",
                "handler": function (response) {
                    // After payment success, send form with Razorpay payment ID
                    const form = document.getElementById("orderForm");
                    
                    // Create hidden input to pass payment id
                    const razorpayPaymentIdInput = document.createElement("input");
                    razorpayPaymentIdInput.type = "hidden";
                    razorpayPaymentIdInput.name = "razorpay_payment_id";
                    razorpayPaymentIdInput.value = response.razorpay_payment_id;
                    form.appendChild(razorpayPaymentIdInput);

                    // Submit form to PaymentSuccess servlet
                    form.action = "Order";
                    form.submit();
                },
                "prefill": {
                    "name": document.querySelector('input[name="name"]').value,
                    "email": document.querySelector('input[name="email"]').value,
                    "contact": document.querySelector('input[name="phone"]').value
                },
                "theme": {
                    "color": "#3399cc"
                }
            };
            var rzp1 = new Razorpay(options);
            rzp1.open();
        }
    });
</script>
	

</body>
</html>