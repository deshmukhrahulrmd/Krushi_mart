package krushi_mart;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/changePassword")
public class changePasswordController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nPassword =req.getParameter("nPassword");
		String cPassword=req.getParameter("cPassword");
		System.out.println(nPassword);
		System.out.println(cPassword);
		int userID = Integer.parseInt(req.getParameter("userId"));
		System.out.println(req.getParameter("userId"));
		
		
		if (nPassword.equals(cPassword)) {
			UserCurd curd =new UserCurd();
					try {
						int result = curd.changePassword(cPassword, userID);
						if (result!=0) {
							req.setAttribute("message", "Password change successfully , Please Login Again");
							RequestDispatcher dispatcher=req.getRequestDispatcher("login.jsp");
							dispatcher.forward(req, resp);
						} 
					} catch (Exception e) {
						e.printStackTrace();
					}
		} else {
			req.setAttribute("message", "Please check new password & comfirm password");
			RequestDispatcher dispatcher=req.getRequestDispatcher("changePassword.jsp");
			dispatcher.forward(req, resp);
		}
	}

}
