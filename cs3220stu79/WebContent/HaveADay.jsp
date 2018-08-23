<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Have A Day</title>
</head>
<body>

	<% if( Math.random() < 0.5) { %>
	
	       <H1>Have a <I>nice</I> day!</H1>
	       
	<% } else { %>
	
	        <H1>Have a <I>lousy</I> day!</H1>
	
	<% } %>


</body>
</html>