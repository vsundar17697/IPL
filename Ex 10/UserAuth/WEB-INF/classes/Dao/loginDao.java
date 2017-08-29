package Dao;

import Bean.*;
import java.io.*; 
import java.sql.*;

public class loginDao{
	public int authen(user u){
		String un = u.getn();
		String p = u.getp();

		final String JDBC_DRIVER="com.mysql.jdbc.Driver";
		final String DB_URL="jdbc:mysql://localhost:3306/siddharth";
 		final String USER="root";
		final String PASS="";
		Connection conn=null;

		try{
		Class.forName("com.mysql.jdbc.Driver");
		conn=DriverManager.getConnection(DB_URL,USER,PASS);

		PreparedStatement pst = conn.prepareStatement("Select uname,password from users where uname=? and password=?");    
		pst.setString(1, un);
        pst.setString(2, p);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            return 1;
        }  
        else {
			return 0;
		}
	}
		catch(Exception e){
			System.out.println(e);
			return 0;
		}
}
}