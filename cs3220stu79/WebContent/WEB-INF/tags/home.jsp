<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Assignment Organizer</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/open-iconic/1.1.1/font/css/open-iconic-bootstrap.min.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
<style>
#header {
	padding: 20px;
	text-align: center;
	color: #e0a800;
	border-bottom: 2px solid #FFFFFF;
	background-color: rgba(0, 0, 0, 0.7);
}

#bodypage {
	background-color: rgba(0, 0, 0, 0.7);
}

#main {
	background-attachment: fixed;
	background-position: auto;
	background-size: cover;
	background-image: url("imgs/bg.jpg");
}
</style>
</head>
<body id='main'>
	<div id='header'>
		<h1>Assignment Organizer</h1>
	</div>
	<div id='bodypage'>
		<br>
		<div>
			<center>
				<button type="button" class="btn btn-warning" data-toggle="modal"
					data-target="#addAssignment" style="border: 1px solid #FFFFFF;">Add
					Assignment</button>
				&nbsp;&nbsp;
				<button type="button" class="btn btn-warning" data-toggle="modal"
					data-target="#addCourse" style="border: 1px solid #FFFFFF;">Add
					Course</button>
				&nbsp;&nbsp; <a href="archiveassgiments" class="btn btn-warning"
					style="border: 1px solid #FFFFFF;">Archive Completed
					Assignments</a>
			</center>
		</div>


		<div class="modal" id="addAssignment">
			<div class="modal-dialog">
				<div class="modal-content">

					<!-- Modal Header -->
					<div class="modal-header">
						<h4 class="modal-title">Add Assignemnt</h4>
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>

					<!-- Modal body -->
					<div class="modal-body">
						<form role="form" method="POST" action="addassignment">
							<div class="form-group">
								<label for="courseId">Course</label> 
								<select class="form-control" id="selectedCourse" name="selectedCourse">

									<c:forEach items="${courses}" var="course">
										<option value="${course.id}">${course.courseNumber} -
											${course.courseName}</option>
									</c:forEach>

								</select>

							</div>
							<div class="form-group">
								<label class="control-label">Assignment Description:</label>
								<div>
									<input type="text" class="form-control input-lg"
										name="assignmentDesc">
								</div>
							</div>

							<div class="form-group">
								<div>
									<button type="submit" class="btn btn-success">Add</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>

		<div class="modal" id="addCourse">
			<div class="modal-dialog">
				<div class="modal-content">

					<!-- Modal Header -->
					<div class="modal-header">
						<h4 class="modal-title">Add Course</h4>
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>

					<!-- Modal body -->
					<div class="modal-body">
						<form role="form" method="POST" action="addcourse">
							<div class="form-group">
								<label class="control-label">Course Number:</label>
								<div>
									<input type="text" class="form-control input-lg"
										name="courseNum" value="">
								</div>
							</div>
							<div class="form-group">
								<label class="control-label">Course Name:</label>
								<div>
									<input type="text" class="form-control input-lg"
										name="courseName">
								</div>
							</div>

							<div class="form-group">
								<div>
									<button type="submit" class="btn btn-success">Add</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		<br>
		<div class="container">
			<c:forEach items="${courses}" var="course">
				<div class="row">
					<div class="col-sm-12 col-md-12"
						style="border: 2px solid #FFCE00; padding-top: 10px">
						<p style="border-bottom: 1px solid #FFFFFF; padding-top: 10px; color:#FFFFFF">
							<span>${course.courseNumber}</span>&nbsp;&nbsp;&nbsp;
							<code>${course.courseName}</code>
							<a href="deletecourse?courseId=${course.id}"><span
								class="oi oi-trash float-right"></span></a>

							<c:forEach items="${assignments}" var="assignment">
								<c:if test="${assignment.courseId == course.id}">
									<p>
										<c:choose>
											<c:when test="${assignment.flag == 0}">
												<a
													href="updateassignment?assignmentId=${assignment.id}&flag=1">${assignment.assginmentDesc}</a>
												<a href="deleteassignment?assignmentId=${assignment.id}"><span
													class="oi oi-trash float-right"></span></a>
											</c:when>
											<c:otherwise>
												<strike><a
													href="updateassignment?assignmentId=${assignment.id}&flag=0">${assignment.assginmentDesc}</a></strike>
												<a href="deleteassignment?assignmentId=${assignment.id}"><span
													class="oi oi-trash float-right"></span></a>
											</c:otherwise>
										</c:choose>
									</p>
								</c:if>
							</c:forEach>


						</p>
					</div>
				</div>
				<br>
			</c:forEach>
		</div>
	</div>
</body>
</html>
