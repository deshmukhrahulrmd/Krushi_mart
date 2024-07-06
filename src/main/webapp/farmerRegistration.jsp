<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Farmer Registration</title>
<link rel="stylesheet" href="Style.css">
</head>
<body>
	 <div class="farmer-reg-container">
		<div>
			<h1 class="farmer-form-title">Farmer Registration</h1>
		</div>
		<form action="registr" method="post" class="farmer-form-container">
			<div>
				<h2>Sign Up</h2>
			</div>
			<br>
			<br>
                <label class="farmer-reg-label">First Name: </label>
			<input type="text" placeholder="Albert" name="firstName" class="farmer-reg-input"/><br><br>

			<label class="farmer-reg-label">Last Name: </label>
			<input type="text" placeholder="Ienstin" name="lastName" class="farmer-reg-input"/><br><br>

			<label class="farmer-reg-label">Email Id: </label>
			<input type="text" placeholder="Albert@gmail.com" name="email" class="farmer-reg-input"/><br><br>

			<label class="farmer-reg-label">Phone Number: </label>
			<input type="tel" placeholder="987654321" name="phone" class="farmer-reg-input"/><br><br>

			<label class="farmer-reg-label">Address: </label>
			<input type="text" placeholder="Deccan" name="address" class="farmer-reg-input"/> <br><br>

             <label class="farmer-reg-label">New Password: </label>
			<input type="password" placeholder="********" name="nPassword" class="farmer-reg-input"/><br><br>

			<label class="farmer-reg-label">Confirm Password: </label>
			<input type="password" placeholder="********" name="cPassword" class="farmer-reg-input"/><br><br><br>

			<input name="role" value="farmer" type="hidden">
			<br><br>

			<button type="submit" class="farmer-reg-button">Register</button>
			<button type="reset" class="farmer-reg-button">Cancel</button><br><br><br>

			Already have an account?
			<a href="login.jsp" class="farmer-reg-link">Login</a>
			<br><br>
		</form>
	</div>
</body>
</html>