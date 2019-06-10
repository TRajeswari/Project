<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   <%@ page isELIgnored="false" %>
   <%@ include file="UserHeader.jsp" %>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<img src="resources/proImages/${ViewData.productId}.jpg" height="300" width="300">
<br>


<td>${ViewData.productId}</td>
<br>
<td>${ViewData.productName}</td>
<br>
<td>${ViewData.productDiscription}</td>
<br>
<td>${ViewData.productPrice}</td>
<br>
<td>${ViewData.productCategory}</td>
<br>
<td>${ViewData.productSupplier}</td>
<br>
<form action="SaveCartData">
Quantity <input type="number" name="quantity" min="1" max="3">
<input type="hidden" name="cartId" value=${ViewData.productId}>
<input type="submit" value="addtocart"/>
</form>
<a href="#">BuyNow</a>
</body>
</html>