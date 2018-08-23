<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:useBean id="cs" class="Homework3.Customer" scope="session"> </jsp:useBean> 
<jsp:setProperty property="*" name="cs" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Main</title>
</head>
<body> 

        <form action="Search" method=post>
        Search : <input type=text name="search">
        <input type="hidden" name="search" value="search" />
        <input
            type="submit" name="search" value="search" />
        </form>
       

	<table border="1">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Purchase Details</th>
			<th>Email ID</th>
			<th>Phone Number</th>
			<th>Operations</th>
		</tr>
		<c:forEach items="${entries}" var="entry">
			<tr>
				<td>${entry.id}</td>
				<td>${entry.name}</td>
				<td><c:out value="${entry.purchase_item}" escapeXml="true" /></td>
				<td><c:out value="${entry.email_id}" escapeXml="true" /></td>
				<td><c:out value="${entry.phone_number}" escapeXml="true" /></td>
				<td><a href="EditCustomer?id=${entry.id}">Edit</a> <a
					href="RemoveCustomer?id=${entry.id}">Remove</a></td>
			</tr>
		</c:forEach>
	</table>
	<p>
		<a href="AddCustomer">Add Details</a>
	</p>
</body>
</html> 