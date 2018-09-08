<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<link rel="stylesheet" href="/css/bootstrap.min.css"></link>
	<table class="table">
		<tr>
			<td>Id</td>
			<td>Name</td>
			<td>DOB</td>
			<td>Edit</td>
			<td>Delete</td>
		</tr>
		<c:forEach items="${employeelist}" var="employee">
			<tr>
				<td>${employee.eid}</td>
				<td>${employee.ename}</td>
				<td>${employee.dob}</td>
				<td><a
					href="<%=request.getContextPath() %>/employee/edit/${employee.eid}.htm">Edit</a></td>
				<td><a
					href="<%=request.getContextPath() %>/employee/delete/${employee.eid}.htm">Delete</a></td>
			</tr>

		</c:forEach>
	</table>
	 <a href="create.htm"><button class="btn btn-primary">Create New</button></a>
</body>
</html>