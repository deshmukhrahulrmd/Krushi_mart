<%@page import="krushi_mart.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% 
		User user=(User) session.getAttribute("userByLogIn");
	%>
	<%=user%>
	<div>
		<form action="changePassword?userId=<%=user.getId()%>">
			<label>New Password:</label>
			 <input type="password" name="nPassword">

			<label>Conform Password:</label> 
			<input type="password"	name="cPassword">
			
			
			<button type="submit">Change</button>
			<button type="reset">Cancel</button>			
		</form>
	</div>

</body>
</html>