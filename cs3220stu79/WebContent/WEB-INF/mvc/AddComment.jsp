<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Comment</title>
</head>
<body>


	<form method="post">
		<c:if test="${not empty nameError}">
			<p>${nameError}</p>
		</c:if>
		
		<input type="text" name="name" value="${param.name }" placeholder="Enter your name" /> <br>

		<c:if test="${not empty messageError}">
			<p>${messageError}</p>
		</c:if>

		<textarea name="message" placeholder="Enter your message">${param.message}</textarea>
		<br> <input type="submit" value="Save" />
	</form>

</body>
</html>