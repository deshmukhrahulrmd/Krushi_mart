package krushi_mart;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/delete")
public class DeletePostController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int postId=Integer.parseInt(req.getParameter("postId"));
		
		UserCurd curd=new UserCurd();
		
		int count;
		try {
			count = curd.deletePostById(postId);
			if(count!=0)
			{
				RequestDispatcher dispatcher=req.getRequestDispatcher("profile.jsp");
				dispatcher.forward(req, resp);
			}
			else
			{
				System.out.println("data is not deleted");
			}
		}
		
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
