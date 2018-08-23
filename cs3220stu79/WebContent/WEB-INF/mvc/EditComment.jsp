<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${empty entry}">
    <c:redirect url="GuestBook"> 
</c:redirect >
</c:if>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Comment</title>
</head>
<body>

    <form method="post">
        <input type="text" name="name" value="${entry.name}" placeholder= "Enter your name"/>
         <br>
        
        <textarea name="message">${entry.message}</textarea>
        <br> 
        <input type="hidden" name="id" value="${entry.id}" /> 
        
        <input type="submit" name="save" value="Save" />
    </form>


</body>
</html>