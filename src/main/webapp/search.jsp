<%@page import="com.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.entity.books_dtls"%>
<%@page import="java.util.List"%>
<%@page import="com.DAO.Addbooksimpl"%>
<%@page import="com.DB.DBconnect"%>
<%@page import="java.sql.Connection"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Recent Book</title>
<%@ include file="all_component/AllCss.jsp"%>
<style type="text/css">


.crd-ho:hover {
	background-color: #f5f0f0;
}
</style>
</head>
<body style="background-color: #dedcdc">
<%@ include file="all_component/navbar.jsp"%>
<%
    User u=(User)session.getAttribute("Userobj"); 
%>
<div class="container-fluid">
		
		<div class="row p-3">
		<%
		    String search=request.getParameter("search"); 
		    Addbooksimpl dao2=new Addbooksimpl(DBconnect.getConnection());
		    List<books_dtls>list2=dao2.getsearchbook(search);
		    for(books_dtls b:list2)
		    {%>
		    	<div class="col-md-3">
				<div class="card crd-ho mt-3" style="border-radius: 30px;">
					<div class="card-body text-center">
						<img src="Books/<%=b.getPhotoName() %>" alt="Java Book" class="img-thumbnail"
							style="width: 150px; height: 190px;">
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
	</div>
</body>
</html>