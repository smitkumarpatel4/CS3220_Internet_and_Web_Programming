<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<jsp:useBean class="beans.BGBean" id="bg"> </jsp:useBean>  
<jsp:setProperty property="*" name="bg" />



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
        <html>
        <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Background bean with EL</title>
        <style>
        body{
          background-color: rgb(
                                 ${ bg.r},
                                 ${ bg.g},
                                 ${ bg.g}
                              );
        }
        </style>
        
</head>
<body>
<h3>

R: ${ bg.r} <br />
G: ${ bg.g} <br />
B: ${ bg.b} <br />

</h3>

<form action=BackgroundBeanWithEL.jsp method="get">
    <input type="text" name= "r" value= "${ bg.r}" placeholder="Enter the red channel value"> <br>
    <input type="text" name= "g" value= "${ bg.g}" placeholder="Enter the green channel value"> <br>
    <input type="text" name= "b" value= "${ bg.b}" placeholder="Enter the blue channel value"> <br>
    <input type="submit" value="Change the background Color"> <br>
    
</form>
</body>
</html>