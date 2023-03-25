<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="UpdateProper" method="get">


ID: <input type="text" name="roll" value="${requestScope.stud.roll}" readonly> <br>
Name: <input type="text" name="uname" value="${requestScope.stud.name}"> <br>
Marks: <input type="text" name="marks" value="${requestScope.stud.marks}"> <br>


<input type="submit" value="UPDATE">
</form>

</body>
</html>