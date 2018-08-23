<%@ page contentType="text/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<%-- set data source --%>
<sql:setDataSource driver="com.mysql.jdbc.Driver"
	url="jdbc:mysql://cs3.calstatela.edu/cs3220stu79" user="cs3220stu79"
	password="DwHAs9GA" />


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>

<head>
<title>Query</title>
<body>
	<div>

		<c:if test="${not empty param.sql}">
			<c:catch var="catchException">
				<sql:query var="items" sql="${param.sql}" />
			</c:catch>
		</c:if>
		<div>
			<c:if test="${catchException != null}">
				<p>
					Invalid Query:
					<code>${param.sql}</code>
				</p>
			</c:if>

			<form action="Query.jsp" method="post">
				<div>
					<textarea rows="1" name="sql"></textarea>
				</div>
				<div>
					<input type="submit" name="submit" value="Execute SQL">
				</div>
			</form>
		</div>

		<c:if test="${not empty param.sql}">
			<c:set var="rowCount" value="0" scope="page" />
			<c:forEach items="${items.rows}" var="row">
				<c:set var="rowCount" value="${rowCount + 1 }" scope="page" />
			</c:forEach>
			<div>
				<table>
					<c:forEach items="${items.rows}" var="row">
						<tr>
							<c:forEach items="${row}" var="col">
								<td>${col.value}</td>
							</c:forEach>
						</tr>
					</c:forEach>

				</table>
			</div>

		</c:if>

	</div>
</body>

</HTML>