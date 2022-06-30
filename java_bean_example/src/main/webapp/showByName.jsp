<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show book</title>
</head>
<body>
<table border="1">
<tr>
<th>Book Number</th>
<th>Book Name</th>
<th>authour Name</th>
<th>price</th>
</tr>
<tr>
<td><c:out value="${search.bookNumber }"/></td>
<td><c:out value="${search.bookName }"/></td>
<td><c:out value="${search.authourName }"/></td>
<td><c:out value="${search.price }"/></td>
</tr>
</table>

</body>
</html>