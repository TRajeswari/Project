<%@page import="javax.servlet.descriptor.TaglibDescriptor"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    
<%@ include file="Header.jsp" %>
<%@taglib uri ="http://www.springframework.org/tags/form" prefix="sform" %> 
<%@page isELIgnored="false" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<sform:form action="addCat"  method="post" modelAttribute="cat">
<div class="form-group">
<sform:input  path="catagoryId"  type="hidden"/>
catagoryName <sform:input  path="catagoryName" class="form-control"  placeholder="Catagory name"   />
</div>
<div class="form-group">

catagoryDiscription <sform:input  path="catagoryDiscription"  class="form-control"  placeholder="catagory Discription" />
</div>

<input type="submit"  value="${buttonName}"/>
</sform:form>

</body>
</html>