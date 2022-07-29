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
	<h1>Product List</h1>
	
	<table>
		<tr>
			<th>Product ID</th>
			<th>Product Name</th>
			<th>Price</th>
			<th>Description</th>
			<th>Actions</th>
		</tr>
		<c:forEach var="product" items="${products}">
			<tr>
				<td>${product.getProductID()}</td>
				<td>${product.getProductName()}</td>				
				<td>${product.getFromattedPrice()}</td>
				<td>${product.getDescription()}</td>
				<td><a href="../../products/changeCategory/${product.getProductID()}">Assign this product</a></td>
				
			</tr>
		</c:forEach>
	</table>
	<a href="/categories">Back category</a>
</body>
</html>