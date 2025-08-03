<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
       <%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Page</title>
<%@ include file="AllCss.jsp" %>
<style>
    /* Ensure the body and html take full height of the viewport */
    html, body {
        height: 100%;
        margin: 0;
        display: flex;
        flex-direction: column;
        background-color:#dedcdc;
    }

    .container {
        flex-grow: 1; /* This will ensure the content takes up the available space */
        display: flex;
        justify-content: center; /* Center content horizontally */
        align-items: center; /* Center content vertically */
    }

    .row {
        display: flex;
        justify-content: space-between;
        width: 100%;
        max-width: 1200px; /* Optional: Limit the maximum width of the row */
    }

    .card {
        margin-bottom: 20px;
    }

    /* Ensure footer is pushed to the bottom of the page */
    footer {
        margin-top: auto; /* This ensures the footer stays at the bottom */
    }
    
    a{
    text-decoration:none;
    color:black;
    }
    a:hover{
     text-decoration:none;
    color:black
    }
</style>
</head>
<body>
<%@ include file="navbar.jsp" %>

<c:if test="${empty Userobj }">
<c:redirect url="../login.jsp"/>
</c:if>
    <div class="container">
        <div class="row p-5">
        
            <div class="col-md-3">
            <a href="add_books.jsp">
                <div class="card">
                    <div class="card-body text-center">
                        <i class="fa-solid fa-square-plus fa-5x text-primary"></i><br>
                        <h4 class="mt-2">Add Books</h4>
                    </div>
                </div>
                </a>
            </div>
            
            <!-- ------------------------------------------------------- -->
            
            <div class="col-md-3">
            <a href="all_books.jsp">
                <div class="card">
                    <div class="card-body text-center">
                        <i class="fa-solid fa-book-open fa-5x text-success"></i><br>
                        <h4 class="mt-2">All Books</h4>
                    </div>
                </div>
                </a>
            </div>
            
            <!-- ------------------------------------------------------- -->
            <div class="col-md-3">
            <a href="order.jsp">
                <div class="card">
                    <div class="card-body text-center">
                        <i class="fa-solid fa-box-open fa-5x text-warning" ></i><br>
                        <h4 class="mt-2">Orders</h4>
                    </div>
                </div>
                </a>
            </div>
            
            <!-- ------------------------------------------------------- -->
            <div class="col-md-3">
            <a href="users.jsp">
                <div class="card">
                    <div class="card-body text-center">
                        <i class="fa-solid fa-box-open fa-5x text-warning" ></i><br>
                        <h4 class="mt-2">Users</h4>
                    </div>
                </div>
                </a>
            </div>
            
            <!-- ------------------------------------------------------- -->
            
            <!-- Logout popup-->
<!-- Button trigger modal -->

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h1 class="modal-title fs-5" id="exampleModalLabel"></h1>
				<button type="button" class="btn-close" data-bs-dismiss="modal"
					aria-label="Close"></button>
			</div>
			<div class="modal-body">
				<div class="text-center">
					<h5>Do You Want To Logout</h5>
					<button type="button" class="btn btn-secondary"
						data-bs-dismiss="modal">Close</button>
					<a href="../logout" class="btn btn-primary ms-1">Logout</a>
				</div>
			</div>
			<div class="modal-footer"></div>
		</div>
	</div>
</div>
<!-- Ends Here -->
        </div>
    </div>
    <footer>
        <div class="footer">
            <%@ include file="footer.jsp" %> <!-- Assuming footer.jsp contains the footer content -->
        </div>
    </footer>
</body>
</html>
