<%@page import="krushi_mart.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Post</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
</head>
</head>
<body>
	<% 
		User user=(User) session.getAttribute("userByLogIn");
	%>
	
	
	<h1>New Post</h1>

	<div aligen="center">
		<form action="post" method="post">
			<fieldset>
				<lable>Product Name:</lable>
				<input name="product_name" placeHolder="Enter the product name"
					type="text"> <br>
				<br>

				<lable>Quentity:</lable>
				<input name="quentity" placeHolder="Enter the Quentity"
					type="number"> <br>
				<br>

				<lable>Price:</lable>
				<input name="price" placeHolder="Enter the price" type="text">
				<br>
				<br> <input type="hidden" name="farmer_id"
					placeHolder="Enter the Farmer Id" value="<%=user.getId() %>">
				<br>
				<br>

				<button type="submit">POST</button>
			</fieldset>
		</form>
		<a href="homePage.jsp"><button type="reset">CANCLE</button></a>	

	</div>

</body>
</html>