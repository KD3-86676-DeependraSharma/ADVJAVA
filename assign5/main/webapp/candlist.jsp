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
<h1>Candidate List</h1>
<jsp:useBean id="ls" class="com.sunbeam.JSPBeans.CandidateListBeans"></jsp:useBean>
${ls.fetchCandidate() }
<form method="post" action="vote.jsp">
<p>id :${lg.user.id}</p>
<c:forEach var="c" items="${ls.candList}" >
<input type="radio" name="candidate" value="${c.id}"/> ${c.name} - ${c.party} <br/>
</c:forEach>
<input type="submit" value="vote">
</form>
</body>
</html>