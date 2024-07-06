package krushi_mart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/login")
public class LogInController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		UserCurd curd = new UserCurd();
		RequestDispatcher dispatcher=null; 
		try {
			User user = curd.logIn(email);

			if (user != null) {
//				System.out.println(user);
				//taking the all the list of the post
				List<Post> postList=curd.getAllPost();
				
				if (password.equals(user.getPassword())) {
//					if(user.getRole().equals("farmer"))
//					{
						//if user is farmer then redirect to farmer home page 
						
						 
						 HttpSession httpSession=req.getSession();
						 httpSession.setAttribute("userByLogIn",user);
						 httpSession.setAttribute("postList", postList);						 
						 dispatcher=req.getRequestDispatcher("homePage.jsp");
						 dispatcher.forward(req, res);
						
//					}
//					else
//					{
//						//else user is buyer then redirect to buyer home page
//						req.setAttribute("userByLogIn", user);
//						 req.setAttribute("postList", postList);
//						dispatcher=req.getRequestDispatcher("homePage.jsp");
//						dispatcher.forward(req, res);
//					}
					
				} 
				else
				{
					dispatcher=req.getRequestDispatcher("login.jsp");
					req.setAttribute("mesege","Wrong Password!");
					dispatcher.forward(req, res);
					
				}
			}
			else
			{
				//if user is not present then redirect to signUp page   
				dispatcher=req.getRequestDispatcher("signUp.jsp");
				req.setAttribute("mesege", "user not found plese register");
				dispatcher.forward(req, res);
				
				
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
//		finally
//		{
//			dispatcher.forward(req, res);
//		}
	}

}
