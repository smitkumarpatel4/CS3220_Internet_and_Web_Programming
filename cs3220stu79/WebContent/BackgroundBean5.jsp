<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<jsp:useBean class="beans.BGBean" id="bg"> </jsp:useBean>
 
                <jsp:setProperty name="bg" property="r" /> 
                <jsp:setProperty name="bg" property="g" />
                <jsp:setProperty name="bg" property="b" />
      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
            <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
            <title>Background Bean 5</title>
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
            <form>
            <input type="text" name="r" placeholder="enter the red channel value"><br />
            <input type="text" name="g" placeholder="enter the green channel value"><br />
            <input type="text" name="b" placeholder="enter the blue channel value"><br />
            <input type="submit" value="see magic" >
            </form>
    </body>
</html>