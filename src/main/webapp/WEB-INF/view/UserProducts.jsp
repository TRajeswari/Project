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
<h1>Shopping</h1>
 
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container-fluid">
  <div class="row">   

<c:forEach items="${UserData}" var="pro" >

<br>
<div class="col-sm-4" style="background-color:yellow;">

<img src="resources/proImages/${pro.productId}.jpg" height="100" width="100">
<br>

ProductId::<td>${pro.productId}</td>
<br>
ProductName::<td>${pro.productName}</td>
<br>
productDiscription::<td>${pro.productDiscription}</td>
<br>
ProductPrice::<td>${pro.productPrice}</td>
<br>
prductCatagory::<td>${pro.productCategory}</td>
<br>
ProductSupplier::<td>${pro.productSupplier}</td>
<br>
<a href="viewpro?proid=${pro.productId}">viewdetails</a>
</div>
</c:forEach>

</div>
</div>
</body>
</html>