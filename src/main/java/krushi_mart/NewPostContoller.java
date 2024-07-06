
package krushi_mart;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/post")
public class NewPostContoller extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String product_name=req.getParameter("product_name");
		double price=Double.parseDouble(req.getParameter("price"));
		int quentity=Integer.parseInt(req.getParameter("quentity"));
		int  farmer_id=Integer.parseInt(req.getParameter("farmer_id"));
		
		Post post =new Post();
		post.setProduct_name(product_name);
		post.setFarmer_id(farmer_id);
		post.setPrice(price);
		post.setQuentity(quentity);
		
		UserCurd curd=new UserCurd();
		try {
			int count =curd.addNewPost(post);
			HttpSession httpSession=req.getSession();
			RequestDispatcher dispatcher = null;
			List<Post> postList;
			
			if(count!=0)
			{
//				List<Post> postList=curd.getAllPost();
//				System.out.println(postList);
//				HttpSession httpSession=req.getSession();
				postList=curd.getAllPost();
				httpSession.setAttribute("postList", postList);
//				httpSession.setAttribute("userByLogIn",curd.getUserById(farmer_id));				
			    dispatcher=req.getRequestDispatcher("homePage.jsp");
				dispatcher.forward(req, resp);
			}
			else
			{
				postList=curd.getAllPost();
				httpSession.setAttribute("postList", postList);
//				httpSession.setAttribute("userByLogIn",curd.getUserById(farmer_id));				
				dispatcher=req.getRequestDispatcher("homePage.jsp");
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

}
