<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div style="margin: 150px;">
<form method="post" action="register.jsp">
<h1>User Registration</h1>
First Name :<input type="text" name="firstName" placeholder="enter f name"/><br/><br/>
Last Name :<input type="text" name="lastName" placeholder="enter L name"/><br/><br/>
Email  :<input type="email" name="email" placeholder="xyz@gmail.com"/><br/><br/>
Password  :<input type="password" name="password"/><br/><br/>
Dob  :<input type="date" name="dob" /><br/><br/>

<a href="index.html" >Sign in</a>
<input type="submit" value="register"/>
</form>
</div>
</body>
</html>