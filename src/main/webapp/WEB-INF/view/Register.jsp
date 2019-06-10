<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="sform" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<sform:form action="addUser"  method="post" modelAttribute="User" >
email<sform:input  path="email" />
<br>
password<sform:input  path="password" />
<br>
username<sform:input  path="userName" />
<br>
mobile no<sform:input  path="mobileNumber" />
<br>
Address<sform:input  path="address" />
<input type="submit" value="Register"/>
<br>
</sform:form>
</body>
</html>