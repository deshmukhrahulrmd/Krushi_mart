
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Buyer Registration</title>
<link rel="stylesheet" href="Style.css">
</head>
<body>
	<div class="buyer-reg-container">
		<div>
			<h1 class="buyer-form-title">
				Buyer Registration
			</h1>
		</div>
		<form action="registr" method="post" class="buyer-form-container">
				<div>
					<h2>Sign Up</h2>
				</div>
				<br><br>
				
                <label class="buyer-reg-label">First Name: </label>
                <input type="text" placeholder="Albert" name="firstName" class="buyer-reg-input"/><br><br>

                <label class="buyer-reg-label">Last Name: </label>
                <input type="text" placeholder="Ienstin" name="lastName" class="buyer-reg-input"/><br><br>

                <label class="buyer-reg-label">Email Id: </label>
                <input type="text" placeholder="Albert@gmail.com" name="email" class="buyer-reg-input"/><br><br>
                
                <label class="buyer-reg-label">Phone Number: </label>
                <input type="tel" placeholder="987654321" name="phone" class="buyer-reg-input"/><br><br>

                <label class="buyer-reg-label">Address: </label>
                <input type="text" placeholder="Deccan" name="address" class="buyer-reg-input"/> <br><br>

                <label class="buyer-reg-label">New Password: </label>
                <input type="password" placeholder="********" name="nPassword" class="buyer-reg-input"/><br><br>
        
                <label class="buyer-reg-label">Confirm Password: </label>
                <input type="password" placeholder="********" name="cPassword" class="buyer-reg-input"/><br><br><br>
				
                <input name="role" value="buyer" type="hidden">
                <br><br>

                <button type="submit" class="buyer-reg-button">Register</button>
                <button type="reset" class="buyer-reg-button">Cancel</button><br><br><br>
                
                Already have an account?
                <a href="login.jsp" class="buyer-reg-link">Login</a>
				<br><br>
		</form>
	</div>
</body>
</html>