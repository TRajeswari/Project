
<%@page import="java.util.List"%>
<%@page import="com.raj.model.Catagory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ include file ="Header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Supplier Data</h1>

<table  border="5">
<tr>
<th>SupplierId</th>
<th>SupplierName</th>
<th>SupplierDetails</th>
<th>SupplierAddress</th>
<th>Edit</th>
<th>Delete</th>

</tr>

<c:forEach items="${addsup}" var="sup" >
<tr>
<td>${sup.supplierId}</td>
<td>${sup.supplierName}</td>
<td>${sup.supplierDetails}</td>
<td>${sup.supplierAddress}</td>
<td><a href="editsup?supid=${sup.supplierId}">edit</a></td>
<td><a href="delsup?supid=${sup.supplierId}">delete</a></td>
</tr>
</c:forEach>
</table>

</body>
</html>