<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Final Exam</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet" href="font/css/open-iconic-bootstrap.css">
</head>
<body>
	<div class="row">
        <div class="col-sm">
            <p class="lead">Add Assignment</p>
            <hr>
            <form action="AddAssignment" method="get">
                <div class="form-group">
                    <label for="courseId">Course</label>
                    <select class="form-control" id="courseId" name="courseId">
                            
                          
                                      
                    </select>
              </div>
              <div class="form-group">
                <label for="description">Assignment Description</label>
                <input type="text" class="form-control" id="description" name="description" placeholder="Enter assignment description">             
              </div>
</body>
</html>