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

<h1>Catagory Data</h1>

<table  border="5">
<tr>
<th>CatagoryId</th>
<th>CatagoryName</th>
<th>CatagoryDiscription</th>
<th>Edit</th>
<th>Delete</th>
</tr>

<c:forEach items="${addcat}" var="cat" >
<tr>
<td>${cat.catagoryId}</td>
<td>${cat.catagoryName}</td>
<td>${cat.catagoryDiscription}</td>
<td><a href="editcat?catid=${cat.catagoryId}">edit</a></td>
<td><a href="delcat?catid=${cat.catagoryId}">delete</a></td>
</tr>
</c:forEach>
</table>
</body>
</html>