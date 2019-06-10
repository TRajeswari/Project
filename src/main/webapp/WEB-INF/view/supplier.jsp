<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri ="http://www.springframework.org/tags/form" prefix="sform" %>
    <%@ page isELIgnored="false" %>
    <%@ include file="Header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<sform:form action="addsup"  method="post" modelAttribute="sup">
<sform:input  path="supplierId"  type="hidden"/>
SupplierName <sform:input  path="supplierName" />
<br><br>
SupplierDetails <sform:input  path="supplierDetails" />
<br><br>
SupplierAddress<sform:input  path="supplierAddress"/>
<br>
<input type="submit"  value="${buttonName}">
</sform:form>

</body>
</html>