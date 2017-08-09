import java.lang.Object;
import java.net.*;
import java.io.*;

class GetExample{
	public static void main(String args[]){
	try{

		// Creating URL object with URL encoded params, opening connection and saving to con
		URL u= new URL("http://localhost:8080/hello/hello?uname=vishal");
		HttpURLConnection con=(HttpURLConnection) u.openConnection();
		
		// Setting request method
		con.setRequestMethod("GET");
		
		// Print request code
		int x= con.getResponseCode();
		System.out.println("x:  " +x);
		InputStream in = con.getInputStream();
		
		// Print request body
		int i;
		while((i=in.read())!=-1){
			System.out.print((char)i);  
		} 
	}
	catch(Exception e){
		System.out.println(e);
	}  
    }  
}