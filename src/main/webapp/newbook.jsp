<%@page import="com.entity.User"%>
<%@page import="java.util.List"%>
<%@page import="com.entity.books_dtls"%>
<%@page import="com.DAO.Addbooksimpl"%>
<%@page import="com.DB.DBconnect"%>

<%
User u = (User) session.getAttribute("Userobj"); // Get user session, can be null
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Books</title>
<%@ include file="all_component/AllCss.jsp"%>
</head>
<body style="background-color: #dedcdc">
	<%@ include file="all_component/navbar.jsp"%>

	<div class="container-fluid">
		<div class="row p-3">
			<%
			Addbooksimpl dao = new Addbooksimpl(DBconnect.getConnection());
			List<books_dtls> list = dao.getallnewbooks();
			for (books_dtls b : list) {
			%>
			<div class="col-md-3">
				<div class="card crd-ho mt-3" style="border-radius: 30px;">
					<div class="card-body text-center">
						<img src="Books/<%=b.getPhotoName()%>" alt="Book Image"
							class="img-thumbnail" style="width: 170px; height: 220px;">
						<p><%=b.getBook_name()%></p>
						<p><%=b.getAuthor()%></p>
						<p>
							Category:
							<%=b.getBook_catogries()%></p>
						<div class="">
							<%
							if (u == null) { // User is not logged in
							%>
							<a href="login.jsp" class="btn btn-danger btn-sm"> <i
								class="fa-solid fa-cart-shopping"></i> Add Cart
							</a>
							<%
							} else { // User is logged in
							%>
							<a href="Cart?bid=<%=b.getBook_ID()%>&&uid=<%=u.getId()%>"
								class="btn btn-danger btn-sm"> <i
								class="fa-solid fa-cart-shopping"></i> Add Cart
							</a>
							<%
							}
							%>
							<a href="viewdeatails.jsp?bid=<%=b.getBook_ID()%>"
								class="btn btn-success btn-sm"> View Details </a> <a href="#"
								class="btn btn-danger btn-sm"> <%=b.getPrice()%> <i
								class="fa-solid fa-indian-rupee-sign"></i>
							</a>
						</div>
					</div>
				</div>
			</div>
			<%
			}
			%>
		</div>
	</div>
	<%
	String successMsg = (String) session.getAttribute("succmsg");
	String failMsg = (String) session.getAttribute("failmsg");
	if (successMsg != null || failMsg != null) {
	%>
	<script>
        window.onload = function () {
            <%if (successMsg != null) {%>
                showToast("<%=successMsg%>");
            <%} else if (failMsg != null) {%>
                showToast("<%=failMsg%>");
            <%}%>
        }

        function showToast(message) {
            const toast = document.createElement("div");
            toast.innerText = message;
            toast.style.position = "fixed";
            toast.style.top = "50%";
            toast.style.left = "50%";
            toast.style.transform = "translate(-50%, -50%)";
            toast.style.padding = "15px 30px";
            toast.style.backgroundColor = "black";
            toast.style.color = "white";
            toast.style.borderRadius = "10px";
            toast.style.fontSize = "18px";
            toast.style.boxShadow = "0 0 15px rgba(0, 0, 0, 0.3)";
            toast.style.zIndex = "10000";
            toast.style.opacity = "0.95";
            toast.style.transition = "opacity 0.5s ease-in-out";

            document.body.appendChild(toast);

            setTimeout(() => {
                toast.style.opacity = "0";
                setTimeout(() => toast.remove(), 500);
            }, 3000);
        }
    </script>
	<%
	session.removeAttribute("succmsg");
	session.removeAttribute("failmsg");
	}
	%>

</body>
</html>
