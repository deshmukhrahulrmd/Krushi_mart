package krushi_mart;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/registr")
public class RegistrationCantoller extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String firstName=req.getParameter("firstName");
	String lastName=req.getParameter("lastName");
	String email=req.getParameter("email");
	long phone=Long.parseLong(req.getParameter("phone"));
	String address=req.getParameter("address");
	String nPassword=req.getParameter("nPassword");
	String cPassword=req.getParameter("cPassword");
	String role=req.getParameter("role");
	
	//checking the new password and confirm password is correct or not
		if(nPassword.equals(cPassword))
		{
			User user=new User();
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setEmail(email);
			user.setAddress(address);
			user.setPhone(phone);
			user.setPassword(cPassword);
			user.setRole(role);
			
			UserCurd curd=new UserCurd();
			try {
				int count=curd.register(user);
				if(count!=0)
				{
					req.setAttribute("message", "Registation Successful!");
					RequestDispatcher requestDispatcher=req.getRequestDispatcher("login.jsp");
					requestDispatcher.forward(req, resp);
				}
				else
				{
					req.setAttribute("message", "Registation fail !!");
					RequestDispatcher requestDispatcher=req.getRequestDispatcher("buyerRegistration.jsp");
					requestDispatcher.forward(req, resp);			
				}
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}
		else
		{
			req.setAttribute("message", "passwored is not matching !!");
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("signUp.jsp");
			requestDispatcher.forward(req, resp);
		}
	
	}
}




