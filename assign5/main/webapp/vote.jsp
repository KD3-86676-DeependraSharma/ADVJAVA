<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Vote page</h1>
<jsp:useBean id="vb" class="com.sunbeam.JSPBeans.VoteBean"/>
<jsp:setProperty property="candId" name="vb" param="candidate" />
<jsp:setProperty property="userId" name="vb" value="${lg.user.id }" />
<p>id :${lg.user.id}</p>
<c:choose>
		<c:when test="${lg.user.status == 0}">
			${vb.vote()}
			<c:choose>
				<c:when test="${vb.success}">
					<p>You have successfully voted.</p>
					${lg.user.setStatus(1)}
				</c:when>
				<c:otherwise>
					<p>Your voting attempt failed.</p>
				</c:otherwise>
			</c:choose>
		</c:when>
		<c:otherwise>
			<p>You have already voted.</p>
		</c:otherwise>
	</c:choose>
	<p>
	<a href="logout.jsp">Sign Out</a>
	</p>
</body>
</html>