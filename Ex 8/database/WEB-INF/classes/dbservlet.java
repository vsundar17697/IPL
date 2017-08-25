import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*; 
import java.sql.*;

public class dbservlet extends HttpServlet { 
public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
 { 
	final String JDBC_DRIVER="com.mysql.jdbc.Driver";
	final String DB_URL="jdbc:mysql://localhost:3306/siddharth";
 	final String USER="root";
	final String PASS="";
	
    Connection conn=null;
	Statement stmt=null;

    response.setContentType("text/html");
	PrintWriter out=response.getWriter();
	String title="Database Result";
	
    
    try{
	Class.forName("com.mysql.jdbc.Driver");
	conn=DriverManager.getConnection(DB_URL,USER,PASS);
	     
	    String user = request.getParameter("user");
        String pwd = request.getParameter("pwd");
        PreparedStatement pst = conn.prepareStatement("select uname,password from users where uname=? and password=?");    
	        pst.setString(1, user);
            pst.setString(2, pwd);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                out.println("Authenticated "+user + "<br/>"); 
            }  
            else {
		            out.println("Authentication failed.Sorry" + "<br/>");	
                    pst=conn.prepareStatement("Select uname from users where uname=?");
                    pst.setString(1,user);
                    rs=pst.executeQuery();
           if(rs.next())
		{
                out.println("Password not matched.Sorry!" + "<br/>");
		}
		else
			out.println("Username not matched" + "<br/>");
        }
         rs.close();
         stmt.close();
         conn.close();
      } 
	catch(SQLException se) {
         //Handle errors for JDBC
         se.printStackTrace();
      } catch(Exception e) {
         //Handle errors for Class.forName
         e.printStackTrace();
      } finally {
         //finally block used to close resources
         try {
            if(stmt!=null)
               stmt.close();
             }
         catch(SQLException se2)
          {
           } // nothing we can do
         try {
            if(conn!=null)
            conn.close();
             }
         catch(SQLException se) {
            se.printStackTrace();
         } //end finally try
      } //end try
   }
} 


