<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://www.springframework.org/tags/form" prefix="sform" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   <%@ page isELIgnored="false" %>
   <%@ include file="Header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<sform:form action="addPro"  method="post" modelAttribute="pro" enctype="multipart/form-data">
<sform:input  path="productId"  type="hidden"/>

ProductName <sform:input  path="productName" />
<br>
ProductDiscription  <sform:input  path="productDiscription" />
<br>
ProductPrice<sform:input  path="productPrice" />
<br>
ProductCategory <sform:select  path="productCategory" >
<c:forEach items="${Catlist}" var="cat">
<sform:option value="${cat.catagoryName}">
</sform:option>
</c:forEach>
</sform:select>
<br>
ProductSupplier <sform:select path="productSupplier">
<c:forEach items="${Suplist}" var="sup">
<sform:option value="${sup.supplierName}">
</sform:option>
</c:forEach>
</sform:select>
<br>
ProductImage<sform:input type="file" path="proImage"/><br>
<input type="submit"  value="${buttonName}" />
</sform:form>
</body>
</html>

</body>
</html>