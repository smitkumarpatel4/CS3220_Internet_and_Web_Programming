<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Details</title>
</head>
<body>


	<form method="post">
		<c:if test="${not empty nameError}">
			<p>${nameError}</p>
		</c:if>
		Name: <input type="text" name="name" value="${param.name }"placeholder="Enter your name" /> <br>

		<c:if test="${not empty itemError}">
			<p>${itemError}</p>
		</c:if>
		Purchase Details: <input name="purchase_item" placeholder="Enter item details" value="${param.purchase_item}" /><br>

		<c:if test="${not empty email_idError}">
			<p>${email_idError}</p>
		</c:if>
		Email: <input name="email_id" value="${param.email_id}" placeholder="Enter your Email" /> <br>

		<c:if test="${not empty phone_numberError}">
			<p>${phone_numberError}</p>
		</c:if>
		Phone Number: <input name="phone_number" placeholder="Enter your Phone Number" value="${param.phone_number}" /> <br>

		<br> <input type="submit" value="Save" />
	</form>

</body>
</html>