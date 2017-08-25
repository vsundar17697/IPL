import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class servlet1 extends HttpServlet{
    public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
     {
		Random r = new Random();
		int ob = 0;
		response.setContentType("text/html");  
        PrintWriter out = response.getWriter();
		String uid = request.getParameter("uid");
		if(uid == null){
			ob=1;
			out.print("<html>");
			out.print("<body>");
			out.print("<form action='session1' method='get'>");  
			out.print("<input type='hidden' name='uid' value='"+(r.nextInt(100)+1)+"'>");
			out.print("<input type='text' name='count' value='" + ob + "'>");
			out.print("<input type='submit' value='go'>");
			out.print("</form>");
			out.print("</body>");
			out.print("</html>");
		}
		else{
			ob = Integer.parseInt(request.getParameter("count"));
			ob++;
			out.print("<html>");
			out.print("<body>");
			out.print("<form action='session1' method='get'>");  
			out.print("<input type='hidden' name='uid' value='"+uid+"'>");  
			out.print("<input type='text' name='count' value='" + ob + "'>");
			out.print("<input type='submit' value='go'>");
			out.print("</form>");
			out.print("</body>");
			out.print("</html>");
		}
        out.print("Welcome");   
        out.close(); 
    }
}