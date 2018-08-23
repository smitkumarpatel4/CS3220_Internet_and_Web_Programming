<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="cs3220"
	uri="http://cs.calstatela.edu/cs3220stu79/examples"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Hello Custom Tag library Test</title>
</head>
<body>

	<p>
		This is the result of the AddTag:
		<%-- <cs3220:add op1="${param.op1}" op2="${param.op2}" /> --%>
		<cs3220:add op1="4" op2="5" />
	</p>


	<p>
		This is the requestInfo tag: <br>
		<cs3220:requestInfo type="method" />
		<br>
		<cs3220:requestInfo type="uri" />
		<br>
		<cs3220:requestInfo type="client" />

		<br> <br>
		<cs3220:requestInfo type="encoding" />

	</p>


	<p>
		This is the cap tag: <br>
		<cs3220:cap>Game Over</cs3220:cap>
		<br>
		<cs3220:cap>${param.text}</cs3220:cap>
		.
	</p>
	<form action="HelloCustomTagLib.jsp" method="post">
		<div>
			<textarea name="value"></textarea>
		</div>
		<div>
			<input type="submit" name="submit"
				value="Convert your Integer into Roman">
		</div>
	</form>
	<c:if test="${not empty param.value}">
		<p>
			This is the Roman Conversion of given number: <br>
			<cs3220:romanNumeral value="${param.value}" />
			.
		</p>
	</c:if>
	<p>
		This is the tag file:
		<cs3220:greeting name="Albert">Hello</cs3220:greeting>
	</p>


	<p>
		This is the EL function: <br>${cs3220:leetTalk('fear my mad programming skills')}.
	</p>

</body>
</html>