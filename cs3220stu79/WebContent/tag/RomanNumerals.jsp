<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="cs3220"
    uri="http://cs.calstatela.edu/cs3220stu79/examples"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Roman Numerals Custom Tag library Test</title>
</head>
<body>

  
    <form action="RomanNumerals.jsp" method="post">
        <div>
           Enter the Integer between 1 to 3999 between : <input  name="value">
        </div>
        <div>
            <input type="submit" name="submit"
                value="Convert your Integer into Roman">
        </div>
    </form>
    <c:if test="${not empty param.value}">
        <p>
            This is the Roman Conversion of given number:
            <cs3220:romanNumeral value="${param.value}" />
        </p>
    </c:if>
  
</body>
</html>