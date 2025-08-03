<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!-- Upper Strip -->

<div class="container-fluid" style="background-color: #3CAB88; padding: 4px 0;">
  <div class="row">
    <div class="col-12 text-light d-flex justify-content-between px-3" style="font-size: 14px;">
      <span>Get Rs50 extra off, Use Code : APP50 GET APP</span>
     <a href="mailto:Read-nest@gmail.com" style="color: white; text-decoration: none;">
  Read-nest@gmail.com
</a>
    </div>
  </div>
</div>


<!-- First Navbar  -->

<div class="container-fluid p-3 bg-light">
	<div class="row">
		<div class="col-md-3 text-success">
			<h3>
				Read-Nest
			</h3>
		</div>

		<div class="col-md-6">
			<form class="d-flex" action="search.jsp"  method="post">
				<input class="form-control me-2 rounded-pill" 
       type="search" 
       placeholder="Search Books Here"
       aria-label="Search" 
       name="search"
       style="border: 1px solid orange; font-size: 16px; padding: 5px 10px; width: 260px;">

				<!--  <button class="btn btn-#3CAB88" type="submit">Search</button>-->
		<button class="btn" type="submit" style="background-color: orange; color: white;">Search</button>
					
			</form>
		</div>


		<c:if test="${not empty Userobj }">

			<div class="col-md-3">
				<a href="cart.jsp" class="btn btn-primary "><i
					class="fa-solid fa-cart-shopping"></i> </a> <a href="#"
					class="btn btn-success "> ${Userobj.name}</a> <a href="logout"
					class="btn btn-primary "><i
					class="fa-solid fa-right-to-bracket"></i>Logout</a>
			</div>

		</c:if>
		<c:if test="${empty Userobj }">
			<div class="col-md-3">
				<a href="login.jsp" class="btn btn-success ms-5"><i
					class="fa-solid fa-right-to-bracket"></i> Login</a> <a
					href="Register.jsp" class="btn  ms-1"
					style="background-color: orange;"><i
					class="fa-solid fa-user-plus"></i>Register</a>

			</div>
		</c:if>

	</div>
</div>



<!-- Second Navbar -->




<nav class="navbar navbar-expand-lg navbar-dark bg-custome" style="background-color: #3CAB88;">
	<div class="container-fluid">

		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="Index.jsp"><i
						class="fa-solid fa-house"></i> Home</a></li>
				<li class="nav-item"><a class="nav-link active "
					href="recentbook.jsp"><i class="fa-solid fa-book-open"></i>
						All Books</a></li>
				<li class="nav-item active"><a class="nav-link active"
					href="newbook.jsp"><i class="fa-solid fa-book-open"></i> New
						Books</a></li>
				<li class="nav-item active"><a class="nav-link active"
					href="oldbook.jsp"><i class="fa-solid fa-book-open"></i> Old User's
						Books</a></li>


			</ul>
			<form class="d-flex">

				<a href="Setting.jsp" class="btn btn-light " type="submit">
					<i class="fa-solid fa-gear"></i>Setting
				</a>
				

			</form>
			<%-- if user is not login we can see later
			<c:if test="${not empty Userobj}">
                <a href="Setting.jsp" class="btn btn-light " type="submit">
					<i class="fa-solid fa-gear"></i>Setting
                </c:if>
                <c:if test="${empty Userobj}">
				<a href="login.jsp" class="btn btn-light " type="submit">
					<i class="fa-solid fa-gear"></i>Setting
				</a>
				</c:if> --%>
		</div>
	</div>
</nav>