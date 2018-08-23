<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html  xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
<title>Lab_4 EL Operators</title>
</head>
<body>
	<p>
	<table class="table table-bordered table-dark">
		<tr align="center">
            <th colspan=4>EL Operators
            
        <tr>
		<tr align="center">
			<th colspan=2>Arithmetic Operators
			<th colspan=2>Relational Operators
		<tr align="center">
			<th>Expression
			<th>Result
			<th>Expression
			<th>Result
		<tr>
			<td>\${3+2-1}
			<td>${3+2-1}
			<td>\${1&lt;2}
			<td>${1<2}
		<tr>
			<td>\${"a"+3/2}
			<td>${"2"+3/2}
			<td>\${"a"&lt;"b"}
			<td>${"a"<"b"}
		<tr>
			<td>\${1 + 2*3 + 3/4}
			<td>${1 + 2*3 + 3/4}
			<td>\${2/3 &gt;= 3/2}
			<td>${2/3 >= 3/2}
		<tr>
			<td>\${3%2}
			<td>${3%2}
			<td>\${3/4 == 0.75}
			<td>${3/4 == 0.75}
		<tr >			
			<td>\${(8 div 2) mod 3}
			<td>${(8/2) % 3}
			<td>\${null == "test"}
			<td>${empty "null"}
		<tr align="center">
			<th colspan=2>Logical Operators
			<th colspan=2><code>empty</code> Operator
		<tr align="center">
			<th>Expression
			<th>Result
			<th>Expression
			<th>Result
		<tr>
			<td>\${(1&lt;2) && (4&lt;3)}
			<td>${(1 lt 2) && (4 lt 3)}
			<td>\${empty ""}
			<td>${null eq 'null'}
		</tr>
		<tr>
			<td>\${(1&lt;2) || (4&lt;3)}
			<td>${(1 lt 2) || (4 lt 3)}
			<td>\${empty null}
			<td>${"abc" lt 'b'}
		</tr>
		<tr>
			<td>\${!(1 &lt; 2)}
			<td>${!(1<2)}
			<td>\${empty param.blah}
			<td>${empty param.blah}
	</table>
</body>
</html>