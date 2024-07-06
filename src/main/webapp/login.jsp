<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
    <form action="login" method="post"> 
        <fieldset height="50px" width="50px">
            <label for="">UserName</label>
            <br>
            <input type="text" placeholder="Email@.com" name="email" >
            <br>
            <label for="password">Password</label>
            <br>
            <input type="password" placeholder="********" name="password">
            <br>
            <br>
            <button type="submit">LOGIN</button>
            <button type="reset">CANCLE</button>
            <br><br>
            <a href="ChangePassord.jsp"><button>Forgot PassWord</button></a>
            
            <a href="CreatePassord.jsp"><button>CreatePassord</button></a>
        </fieldset>
    </form>
</body>
</html>