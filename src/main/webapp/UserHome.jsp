<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
hello User

<c:if test="${not empty Userobj}">
<p>Name:${Userobj.name}</p>
<p>Email:${Userobj.email}</p>
<p>Phone:${Userobj.phone}</p>
</c:if>
</body>
</html>