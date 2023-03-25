<%@page import="java.util.Iterator"%>
<%@page import="com.dao.StudentDAO"%>
<%@page import="com.modal.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head> 
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="../css/table.css" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.3/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<%!StudentDAO dao;

	public void jspInit() {

		dao = new StudentDAO();

	}%>

	<%
		String url = application.getInitParameter("url");
		String username = application.getInitParameter("username");
		String password = application.getInitParameter("password");
	%>


	<%
		List<Student> list = dao.getAllStudent(url, username, password);
		
		application.setAttribute("list", list);
	%>
	<h1>STUDENT DATA TABLE</h1>
	<div class="container">
		<table class="table">
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Marks</th>
				<th>DELETE</th>
				<th>UPDATE</th>
			</tr>

			<c:forEach var="stud" items="${applicationScope.list }">
				<tr>
					<td><c:out value="${stud.roll}"></c:out></td>
					<td><c:out value="${stud.name}"></c:out></td>
					<td><c:out value="${stud.marks}"></c:out></td> 
					<td><a href="${pageContext.request.contextPath}/DeleteStudent?roll=${stud.roll}">DELETE</a></td>
					<td><a href="${pageContext.request.contextPath}/updateStudent?roll=${stud.roll}">UPDATE</a></td>
				</tr>
			</c:forEach>

		</table>

	</div>
	
</body>
</html>