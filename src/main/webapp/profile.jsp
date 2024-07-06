<%@page import="krushi_mart.Post"%>
<%@page import="java.util.List"%>
<%@page import="krushi_mart.UserCurd"%>
<%@page import="krushi_mart.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profile Page</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
</head>
</head>
<body>
	<%
	User userByLogIn = (User) session.getAttribute("userByLogIn");
	UserCurd curd = new UserCurd();
	List<Post> postListUser = curd.getPostById(userByLogIn.getId());
	%>
	<div class="main">
		<div class="head">
			<nav class="navbar navbar-expand-lg bg-body-tertiary">
				<div class="container-fluid">
					<!-- <a class="navbar-brand" href="#">Navbar</a> -->
					<button class="navbar-toggler" type="button"
						data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup"
						aria-controls="navbarNavAltMarkup" aria-expanded="false"
						aria-label="Toggle navigation">
						<span class="navbar-toggler-icon"></span>
					</button>

					<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
						<div class="navbar-nav">
							<a class="nav-link active" aria-current="page" href="homePage.jsp">Home</a>
							<%
							//post button will be enabled when user is farmer 
							if (userByLogIn.getRole().equals("farmer")) {
							%>

							<a class="nav-link" href="NewPost.jsp">Post</a>
							<%
							}
							%>

							<a class="nav-link" href="profile.jsp">Profile</a> <a class="nav-link"
								href="#">About</a> <a class="nav-link" href="contact.jsp">Contact</a>
						</div>
					</div>

				</div>
			</nav>

			<h1 id="hed">FARMER PROFILE</h1>
			<div>
				<div>
					<img alt="User Image" src="#">
					<h3>Name:<%=userByLogIn.getFirstName()+" "+userByLogIn.getLastName() %></h3>
					<h4>Email:<%=userByLogIn.getEmail() %></h4>
					<h4>Phone:<%=userByLogIn.getPhone() %></h4>
					<h4>Address:<%=userByLogIn.getAddress() %></h4>
				</div>


				<a href="EditProfile.html">
					<button id="edit" class="button">Edit Profile</button>
				</a> <a href="changePassword.jsp">
					<button id="chng" class="button">Change Password</button>
				</a>  
			</div>
			<%if(userByLogIn.getRole().equals("farmer")){%>
			<div>
				<a href="NewPost.jsp">
					<button id="add" class="button">Add Post</button>
				</a>
				<%
				for (Post i : postListUser) {
				%>
				<div class="card mb-3" style="max-width: 540px;">
					<div class="row g-0">
						<div class="col-md-4">
							<img src="..." class="img-fluid rounded-start" alt="...">
						</div>
						<div class="col-md-8">
							<div class="card-body">
								<h5 class="card-title">
									Name:<%=i.getProduct_name()%></h5>
								<p class="card-text">
									Quantity:<%=i.getQuentity()%></p>
								<p class="card-text">
									Price
									<%=i.getPrice()%></p>
								<p class="card-text">
									PostBy: You</p>
								<p class="card-text">
									phone:<%=userByLogIn.getPhone()%></p>

								<a href="delete?postId=<%=i.getId()%>"><button id="del" class="button">Delete Post</button></a>
							</div>
						</div>
					</div>
				</div>
				<%
				}
				%>

			</div>
			<%} %>
		</div>


	</div>

</body>
</html>