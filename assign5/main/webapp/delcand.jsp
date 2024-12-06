<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Candidate</title>
</head>
<body>
   <h2>Delete Candidate</h2>
   <jsp:useBean id="dc" class="com.sunbeam.JSPBeans.DeleteCandidateBean"/>
   <jsp:setProperty property="candId" name="dc" param="id"/>
    ${dc.deleteCandidate()}
    <c:choose>
    <c:when test="${dc.count==1}">
   		
    	<c:redirect url="result.jsp" />
    </c:when>
    <c:otherwise>
    	<h2>failed</h2>
    </c:otherwise>
    </c:choose>
   
  
</body>
</html>