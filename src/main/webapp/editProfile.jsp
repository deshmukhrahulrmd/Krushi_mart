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

	<%-- <%User user=(User)request.getSession(); %>--%> 
	<div>
			<form action="/edit">
				<label class="label" >First Name :</label>
                <input type="text" placeholder="Enter First Name" name="firstName"/><br><br>

                <label class="label" >Last Name :</label>
                <input type="text" placeholder="Enter Second Name" name="lastName"/><br><br>

                <label class="label" >Email Id :</label>
                <input type="text" placeholder="Enter Your Email" name="email"/><br><br>
                
                <label class="label" >Phone Number :</label>
                <input type="tel" placeholder="Enter Phone Number" name="phone"/><br><br>

                <label class="label" >Address :</label>
                <input type="text" placeholder=" Enter Address" name="address"/> <br><br>
                
                <button type="submit">Edit</button>
			</form>	
				
	</div>


</body>
</html>