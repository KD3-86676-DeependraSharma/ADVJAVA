<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Candidate</title>
</head>
<body>
<h1>Edit candidate</h1>
<jsp:useBean id="ed" class="com.sunbeam.JSPBeans.EditCandidate"/>
<jsp:setProperty property="candId" name="ed" param="id"/>
${ed.editCandidate() }
<form method="post" action="updatecand.jsp" >
		<input type="hidden" name="id" value="${ed.cand.id}"/>
		Name: <input type="text" name="name" value="${ed.cand.name}"/> <br/><br/>
		Party: <input type="text" name="party" value="${ed.cand.party}"/> <br/><br/>
		Votes: <input type="text" name="votes" readonly="readonly" value="${ed.cand.votes}"/> <br/><br/>
		<input type="submit" value="Update"/>
	</form>
</form>
</body>
</html>