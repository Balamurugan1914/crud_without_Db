<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="header.html"%>
	<div>
		<p style="color: green">
			<c:out value="${message}" /></p>
	</div>
	<form action="Books" method="post">
		<div><label for="bookNumber">Book Number</label><input type="text"name="bookNumber" /></div>
		<div><label for="bookName">Book Name</label><input type="text"name="bookName" /></div>
		<div><label for="authourName">Authour Name</label><input type="text"name="authourName" /></div>
		<div><label for="price">Price</label><input type="text" name="price" /></div>


		<input type="submit" value="Add" />
	</form>
	<c:if test="${!empty bookToedit }">
		<h1>Edit</h1>
	</c:if>
	<jsp:include page="footer.jsp" />
</body>
</html>