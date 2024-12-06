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
<jsp:useBean id="lg" class="com.sunbeam.JSPBeans.LoginBean" scope="session"/>

<jsp:setProperty name="lg" property="email" param="email" />
<jsp:setProperty name="lg" property="password" param="password" />

${lg.loginValidateUser()}

<c:choose>
    <c:when test="${lg.user != null }" >
		<c:choose>
			<c:when test="${lg.user.role == 'admin'}">
			    <p>Login Successful...</p>
				<c:redirect url="result.jsp"/>
		    </c:when>
			<c:otherwise>
				<c:redirect url="candlist.jsp"/>
			</c:otherwise>
        </c:choose>
	</c:when>
	<c:otherwise>
		<h1>Login Failed</h1>
		<p>Invalid Email or password </p>
		<a href="index.jsp" >Login again</a>
	</c:otherwise>
</c:choose>
</body>
</html>