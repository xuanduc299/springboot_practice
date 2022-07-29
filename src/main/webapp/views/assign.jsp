<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <p>Do you really want to assign product: 
        <strong>${product.getProductName()}

        </strong> to other category ?
    </p>
    <form action="">
	    <form method="POST"
	        action="/products/updateProduct/${product.getProductID()}"  
	        modelAttribute="product">
	        <select path="categoryID">
	            <c:forEach var="category" items="${categories}">
	                <option value="${category.getCategoryID()}">
	                    ${category.getCategoryName()}
	                </option>
	            </c:forEach>                        
	        </select>
	        <input type="submit" value="Update">
	    </form>
    </form>

</body>
</html>