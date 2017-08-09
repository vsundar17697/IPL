import java.lang.Object;
import java.net.*;
import java.io.*;

class PostExample{
	public static void main(String args[]){
	try{
		
		// Creating URL object, opening connection and saving to con
		URL u= new URL("http://localhost:8080/hello/hello");
		HttpURLConnection con=(HttpURLConnection) u.openConnection();
		
		// Setting request method and params
		con.setRequestMethod("POST");
		String urlParameters = "uname=Rico";

		// Enabled to send a request body (Not needed for GET)
		con.setDoOutput(true);
		// Writing params to request body
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();
	
		// Printing response code
		int x= con.getResponseCode();
		System.out.println("x:  " +x);
		InputStream in = con.getInputStream();
	
		// Printing response body
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