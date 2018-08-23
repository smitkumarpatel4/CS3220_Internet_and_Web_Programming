<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<jsp:useBean class="beans.BGBean" id="bg"> </jsp:useBean> 
       
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
			<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
			<title>Background Bean 2</title>
			<style>
			    body{ 
			             background-color: rgb(
												    <jsp:getProperty name="bg" property="r" />, 
												    <jsp:getProperty name="bg" property="g" />,
												    <jsp:getProperty name="bg" property="b" />
			                                   ); 
			    }
			
			</style>
	</head>
	<body>
			<h3>
	        R: <jsp:getProperty name="bg" property="r" /><br />
	        G: <jsp:getProperty name="bg" property="g" /><br />
	        B: <jsp:getProperty name="bg" property="b" /><br />
	        </h3>
	</body>
</html>