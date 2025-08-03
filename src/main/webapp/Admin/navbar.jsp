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
			<form class="d-flex" action="../search.jsp"  method="post">
				<input class="form-control me-2" type="hidden" placeholder="Search"
					aria-label="Search" name="search" 
					style="font-size: 14px; padding: 5px 10px; width: 230px;">
				<!-- <button class="btn btn-primary" type="hidden" >Search</button> -->
			</form>
		</div>

		<div class="col-md-3 ">
			<c:if test="${not empty Userobj }">
				<a href="#" class="btn btn-success "> <i
					class="fa-solid fa-user"></i>${Userobj.name}</a>
				<a data-bs-toggle="modal" data-bs-target="#exampleModal"
					class="btn  ms-1" style="background-color: orange; color: white;"><i
					class="fa-solid fa-right-to-bracket"></i>Logout</a>
			</c:if>

			<c:if test="${empty  Userobj  }">
				<a href="../login.jsp" class="btn btn-success ms-5"><i
					class="fa-solid fa-right-to-bracket"></i> Login</a>
				<a href="../Register.jsp" class="btn btn-primary ms-1"><i
					class="fa-solid fa-user-plus"></i>Register</a>
			</c:if>


		</div>
	</div>
</div>

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
					aria-current="page" href="AdminHome.jsp"><i
						class="fa-solid fa-house me-2"></i>Home</a></li>
			</ul>

		</div>
	</div>
</nav>