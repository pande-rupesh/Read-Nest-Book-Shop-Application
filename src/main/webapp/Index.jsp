<%@page import="com.entity.User"%>
 <%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%> 
<%@page import="com.entity.books_dtls"%>
<%@page import="java.util.List"%>
<%@page import="com.DAO.Addbooksimpl"%>
<%@page import="com.DB.DBconnect"%>
<%@page import="java.sql.Connection"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ebooks</title>
<%@ include file="all_component/AllCss.jsp"%>
<style>
    .crd-ho:hover {
      background-color: #f5f0f0;
    }
.carousel-inner {
  width: 100%;
}

.carousel-inner img {
  width: 100%;         
  height: 70vh;        
  object-fit: cover;   
}
    
  </style>
</head>
<body style="background-color: #dedcdc">

<%
    User u=(User)session.getAttribute("Userobj"); 
%>
<!-- ✅ Navbar FIRST -->
<%@ include file="all_component/navbar.jsp" %>
	<!-- Background Carousel -->
<!-- Carousel with smooth fade and 3s interval -->
<div id="backCarousel" class="carousel slide carousel-fade" data-bs-ride="carousel" data-bs-interval="2000">
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src="img/img2.jpg" class="d-block w-100" alt="Slide 1">
    </div>
    <div class="carousel-item">
      <img src="img/img1.jpg" class="d-block w-100" alt="Slide 2">
    </div>
    <div class="carousel-item">
      <img src="img/img3.jpg" class="d-block w-100" alt="Slide 3">
    </div>
    <div class="carousel-item">
      <img src="img/img4.jpg" class="d-block w-100" alt="Slide 3">
    </div>
    <div class="carousel-item">
      <img src="img/img6.jpg" class="d-block w-100" alt="Slide 3">
    </div>
    <div class="carousel-item">
      <img src="img/img7.jpg" class="d-block w-100" alt="Slide 3">
    </div>
  </div>
</div>

	<!-- Recent Books Start -->


	<div class="container-fluid">
		<h3 class="text-center  p-2">All Books</h3>
		<div class="row">
		<%
		    Addbooksimpl dao2=new Addbooksimpl(DBconnect.getConnection());
		    List<books_dtls>list2=dao2.getrecentbooks();
		    for(books_dtls b:list2)
		    {%>
		    	<div class="col-md-3">
				<div class="card crd-ho" style="border-radius: 30px;">


					<div class="card-body text-center">
						<img src="Books/<%=b.getPhotoName() %>" alt="Java Book" class="img-thumbnail"
							style="width: 170px; height: 220px;">
						<p><%=b.getBook_name() %></p>
						<p><%=b.getAuthor() %></p>
						<p>Catogries:<%=b.getBook_catogries() %></p>
						
						<%
						if(b.getBook_catogries().equals("Old"))
						{%>
							 <div class="">
							<a href="viewdeatails.jsp?bid=<%=b. getBook_ID()%>" class="btn btn-success btn-sm">View Deatails</a> <a
								href="#" class="btn btn-danger btn-sm"><%=b.getPrice() %> <i
								class="fa-solid fa-indian-rupee-sign"></i></a>
						   </div>
						<%}
						else
						{%>
							<div class="">
							<%
						if(u==null)
						{%>
							<a href="login.jsp" class="btn btn-danger btn-sm "><i
								class="fa-solid fa-cart-shopping"></i>Add Cart</a>
						<%}
						else
						{%>
							<a href="Cart?bid=<%=b.getBook_ID()%>&&uid=<%=u.getId() %>" class="btn btn-danger btn-sm "><i
								class="fa-solid fa-cart-shopping"></i>Add Cart</a>
						<%}
						%>
							
								<a href="viewdeatails.jsp?bid=<%=b. getBook_ID()%>"class="btn btn-success btn-sm">View Deatails</a> <a href="#"
								class="btn btn-danger btn-sm"><%=b.getPrice() %> <i
								class="fa-solid fa-indian-rupee-sign"></i></a>
						</div>
							
						<%}
						%>
						
					</div>
				</div>
			</div>
		    <%}
		%>
		
		</div>
		<div class="text-center mt-3">
			<a href="recentbook.jsp" class="btn btn-danger btn small text-white">View</a>
		</div>
	</div>

	<!-- Recent Books End Here -->
	<hr></hr>
	<!-- New Books Start -->

	<div class="container-fluid">
		<h3 class="text-center  p-2">New Books</h3>
		<div class="row">
			<%
			Addbooksimpl dao = new Addbooksimpl(DBconnect.getConnection());
			List<books_dtls> list = dao.getnewbook();
			for (books_dtls b : list) {
			%>
			<div class="col-md-3">
					<div class="card crd-ho" style="border-radius: 30px;">					<div class="card-body text-center">
						<img src="Books/<%=b.getPhotoName() %>" alt="Java Book" class="img-thumbnail"
							style="width: 170px; height: 220px;">
						<p><%=b.getBook_name()%></p>
						<p><%=b.getAuthor()%></p>
						<p>
							Catogries:<%=b.getBook_catogries()%></p>
						<div class="">
						<%
						if(u==null)
						{%>
							<a href="login.jsp" class="btn btn-danger btn-sm "><i
								class="fa-solid fa-cart-shopping"></i>Add Cart</a>
						<%}
						else
						{%>
							<a href="Cart?bid=<%=b.getBook_ID()%>&&uid=<%=u.getId() %>" class="btn btn-danger btn-sm "><i
								class="fa-solid fa-cart-shopping"></i>Add Cart</a>
						<%}
						%>
							 <a href=" viewdeatails.jsp?bid=<%=b. getBook_ID()%>"
								class="btn btn-success btn-sm">View Deatails</a> <a href="#"
								class="btn btn-danger btn-sm"><%=b.getPrice()%> <i
								class="fa-solid fa-indian-rupee-sign"></i></a>
						</div>
					</div>
				</div>
			</div>

			<%
			}
			%>

		</div>
		<div class="text-center mt-3">
			<a href="newbook.jsp" class="btn btn-danger btn small text-white">View</a>
		</div>
	</div>

	<!-- New Books End Here -->

	<hr></hr>
	<!-- Old Books Start -->

	<div class="container-fluid">
		<h3 class="text-center  p-2">Old User's Books</h3>
		<div class="row">
		<%
		Addbooksimpl dao3=new Addbooksimpl(DBconnect.getConnection());
		List<books_dtls>list3=dao3.getOldbooks();
		for(books_dtls b:list3)
		{%>
			<div class="col-md-3">
					<div class="card crd-ho" style="border-radius: 30px;">
					<div class="card-body text-center">
						<img src="Books/<%=b.getPhotoName() %>" alt="Java Book" class="img-thumbnail"
							style="width: 170px; height: 220px;">
						<p><%=b.getBook_name() %></p>
						<p><%=b.getAuthor() %></p>
						<p>Catogries:<%=b.getBook_catogries() %></p>
						<div class="">
							<a href="viewdeatails.jsp?bid=<%=b. getBook_ID()%>"class="btn btn-success btn-sm">View Deatails</a> <a
								href=" " class="btn btn-danger btn-sm"><%=b.getPrice()%> <i
								class="fa-solid fa-indian-rupee-sign"></i></a>
						</div>
					</div>
				</div>
			</div>
		<% }
		%>
		</div>
		<div class="text-center mt-3">
			<a href="oldbook.jsp" class="btn btn-danger btn small text-white">View</a>
		</div>
	</div>

	<!--Old Books End Here -->
	<%@ include file="all_component/footer.jsp"%>
</body>
</html>