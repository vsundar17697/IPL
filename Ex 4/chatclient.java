import java.util.*;
import java.net.*;
import java.io.*;

class chatclient
{
    public static void main(String[] args) throws Exception
    {
        Socket sock = new Socket("127.0.0.1" , 6969);
        
        BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));
        OutputStream ostream = sock.getOutputStream();
        PrintWriter pwrite = new PrintWriter(ostream , true);
        String str = "1";

        InputStream istream = sock.getInputStream();
        BufferedReader recvstr = new BufferedReader(new InputStreamReader(istream));

        while(str != "bye")
        {
            System.out.print("You :");
            str = keyRead.readLine();
            pwrite.println(str);
            pwrite.flush();
            str = recvstr.readLine();
            System.out.println("Server: " + str);
        }
    }
}