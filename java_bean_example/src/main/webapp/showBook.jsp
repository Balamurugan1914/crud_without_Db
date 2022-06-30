<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table {
	border: 1px solid blue;
}

tr, th, td {
	border: 1px solid blue;
	border-collapse: collapse;
}
</style>

</head>
<body>
	<%@ include file="header.html"%>
	<jsp: useBean id="service" class="com.example.demo.odel.Bookservice"
		scope="request" />
	<c:set var="books" valuee="${service.findAll()}" />

	<table boder="1">
		<tr>
			<th>Authour Name</th>
			<th>Book Name</th>
			<th>Book Number</th>
			<th>price</th>
		</tr>
		<c:set var="books" value="${service.findAll()}" />
		<c:forEach items="${books}" var="eachbook">
			<tr>
				<td><c:out value="${eachbook.authourName }" /></td>
				<td><c:out value="${eachbook.bookName }" /></td>
				<td><c:out value="${eachbook.bookNumber }" /></td>
				<td><c:out value="${eachbook.price }" /></td>
				<td><a href="edit?id=<c:out value="${eachBook.bookNumber}"/">Edit</td>
				<td><a href="delete?id=<c:out value="${eachBook.bookNumber}"/">Delete</td>
			</tr>
		</c:forEach>

	</table>
	<hr />
	<jsp:include page="footer.jsp" />

</body>
</html>