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
<sform:form action="loginsucess"  method="post" modelAttribute="Login" >
email<sform:input  path="email" />
<br>
password<sform:input  path="password" />
<br>
<input type="submit" value="login"/>
</sform:form>

</body>
</html>