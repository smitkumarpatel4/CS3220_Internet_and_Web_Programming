<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<jsp:useBean id="cs" class="Homework3.Customer" scope="session"> </jsp:useBean> 
<jsp:setProperty property="*" name="cs" />



<c:if test="${empty entry}">
	<c:redirect url="Main">
	</c:redirect>
</c:if>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Customer Details</title>
</head>
<body>

	<form method="post">
		Name: <input type="text" name="name" value="${entry.name}"
			placeholder="Enter Customer name" /> <br>
		 Purchase item:
		<textarea name="purchase_item">${entry.purchase_item} </textarea>
		<br> Email_id:
		<textarea name="email_id">${entry.email_id}</textarea>
		<br> Phone Number:
		<textarea name="phone_number">${entry.phone_number}</textarea>
		<br> <input type="hidden" name="id" value="${entry.id}" /> <input
			type="submit" name="save" value="Save" />
	</form>


</body>
</html>