import Bean.*;
import Dao.*;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class loginController extends HttpServlet{ 
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		String un = req.getParameter("uname");
		String p = req.getParameter("pass");

		user u = new user();
		u.setn(un);
		u.setp(p);

		loginDao d = new loginDao();
		int x = d.authen(u);

		if(x==1){
			try{
			req.getRequestDispatcher("succ.jsp").forward(req,res);
			}
			catch(ServletException e){	
			}
		}
		else{
			try{
			req.getRequestDispatcher("fail.jsp").forward(req,res);
			}
			catch(ServletException e){

			}
		}
	}
}