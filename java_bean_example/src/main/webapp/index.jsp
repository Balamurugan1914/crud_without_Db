<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bank Book</title>
</head>
<body>
	<%@ include file="header.html"%>
	<hr />
	<p Style="color: yellow">
		<c:out value="${param.errorMessage}" />
	</p>
	<div>
		<form action="handlelogin.jsp">
			<label for="">User Name</label> <input type="name" name="userName" />
			<label for="">Password</label> <input type="password" name="password" />
			<input type="submit" value="Login" />
		</form>

	</div>

	<hr />
	<jsp:include page="footer.jsp" />

</body>
</html>