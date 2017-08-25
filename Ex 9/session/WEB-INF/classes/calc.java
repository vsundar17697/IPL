import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class calc extends HttpServlet
{
    public void doPost (HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
     {
      response.setContentType("text/html");
      PrintWriter out = response.getWriter();
      HttpSession ob = request.getSession();
      Integer count = 0;
      if(ob.isNew()){
        count = 1;
        out.println("<fieldset>" + "Count : " + count + "<br/>" + "</fieldset>");
        ob.setAttribute("Count",count);
      }
      else{
       count = (Integer) ob.getAttribute("Count");
       count++;
       out.println("<fieldset>" + "Count : " + count + "<br/>" + "</fieldset>");
       ob.setAttribute("Count",count);
      }

     }
}