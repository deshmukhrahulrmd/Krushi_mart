<%@page import="krushi_mart.User"%>
<%@page import="krushi_mart.UserCurd"%>
<%@page import="java.util.Collections"%>
<%@page import="krushi_mart.Post"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<link rel="stylesheet" href="Style.css">
</head>
<body>

	<%
	List<Post> postList = (List) session.getAttribute("postList");
	Collections.reverse(postList);
	User userByLogIn = (User) session.getAttribute("userByLogIn");
	%>

	 <div class="home-page-container">
        <h1>Home Page</h1>

        <nav class="navbar">
            <a href="homePage.jsp" class="nav-btn">Home</a>
            <%
            // post button will be enabled when the user is a farmer
            if (userByLogIn.getRole().equals("farmer")) {
            %>
            <a href="NewPost.jsp" class="nav-btn">Post</a>
            <%
            }
            %>
            <a href="profile.jsp" class="nav-btn">Profile</a>
            <a href="about.jsp" class="nav-btn">About</a>
            <a href="contact.jsp" class="nav-btn">Contact</a>
        </nav>
    </div>
	<!--Post -->
	<%
	for (Post i : postList) {
		UserCurd curd = new UserCurd();
		User postUser = curd.getUserById(i.getFarmer_id());
	%>

	
		<h5 class="card-title">
				Name:<%=i.getProduct_name()%>
		</h5>
		<p class="card-text">
			Quantity:<%=i.getQuentity()%>
		</p>
		<p class="card-text">
			Price<%=i.getPrice()%>
		</p>
		<p class="card-text">
			PostBy:<%=postUser.getFirstName()%>
		</p>
		<p class="card-text">
			Phone:<%=postUser.getPhone()%>
		</p>
	<%
	}
	%>

</body>
</html>