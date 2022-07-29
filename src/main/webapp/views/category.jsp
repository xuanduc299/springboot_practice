<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    table,th,td {
        border: 1px solid black;
     }
</style>
</head>

<body>
	<h1>hello</h1>
	<%-- <h1>Name ${name}, age ${age}</h1> --%>
	<table>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Description</th>
			<th>Action</th>
		</tr>
		<c:forEach var="category" items="${categories}">
			<tr>
				<td>${category.getCategoryID()}</td>
				<td>${category.getCategoryName()}</td>
				<td>${category.getDescription()}</td>
				<td><a href="/products/getProductByCategoryID/${category.getCategoryID()}">Show Products</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>