<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri ="http://www.springframework.org/tags/form" prefix="sform" %> 
<%@page isELIgnored="false" %>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Cart Data</h1>

<table  border="5">
<tr>
<th>productName</th>
<th>productPrice</th>
<th>supplierName</th>
<th>Qunatity</th>
<th>Total</th>
</tr>

<c:forEach items="${CartData}" var="cart" >
<tr>
<td>${cart.productName}</td>
<td>${cart.productPrice}</td>
<td>${cart.productSupplier}</td>
<td>${cart.productQuantity}</td>
<td>${cart.total}</td>
</tr>
</c:forEach>
</table>
</body>
</html>