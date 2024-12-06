<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div>
<jsp:useBean id="rg" class="com.sunbeam.JSPBeans.Register"/>

<jsp:setProperty name="rg" property="firstName" param="firstName" />
<jsp:setProperty name="rg" property="lastName" param="lastName" />
<jsp:setProperty name="rg" property="email" param="email" />
<jsp:setProperty name="rg" property="password" param="password" />
<jsp:setProperty name="rg" property="dob" param="dob" />

${rg.registerUser()}

</div>
<c:choose>
		<c:when test="${rg.count == 1}">
			<p>Register successful...</p>
			<a href="index.jsp">Go back LoginPage</a>
		</c:when>
		<c:otherwise>
			<p>Register Failed...</p>
			<a href="newuser.jsp">Go back User Register</a>
		</c:otherwise>
	</c:choose>

</body>
</html>