
<%@page import="java.util.List"%>
<%@page import="com.raj.model.Product"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   <%@ page isELIgnored="false" %>
   <%@ include file="Header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Product Data</h1>
<table  border="5">
<tr>
<th>ProductId</th>
<th>ProductName</th>
<th>ProductDiscription</th>
<th>ProductPrice</th>
<th>ProductCategory</th>
<th>ProductSupplier</th>
<th>Images</th>
<th>Edit</th>
<th>Delete</th>


</tr>

<c:forEach items="${ProData}" var="pro" >
<tr>
<td>${pro.productId}</td>
<td>${pro.productName}</td>
<td>${pro.productDiscription}</td>
<td>${pro.productPrice}</td>
<td>${pro.productCategory}</td>
<td>${pro.productSupplier}</td>
<td> <img src="resources/proImages/${pro.productId}.jpg" height="50" width="50"></td>
<td><a href="editpro?proid=${pro.productId}">edit</a></td>
<td><a href="delpro?proid=${pro.productId}">delete</a></td>

</tr>
</c:forEach>
</table>

</body>
</html>