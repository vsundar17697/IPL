import java.util.*;
import java.net.*;
import java.io.*;

class chatserver
{
    public static void main(String[] args)  throws Exception
    {
        ServerSocket sersock = new ServerSocket(6969);
        Socket sock = sersock.accept();

        InputStream istream = sock.getInputStream();
        BufferedReader recvstr = new BufferedReader(new InputStreamReader(istream));

        BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));
        OutputStream ostream = sock.getOutputStream();
        PrintWriter pwrite = new PrintWriter(ostream , true);

        String str;
        String str2 = "hi";
        while(str2 != "bye")
        {
            str = recvstr.readLine();
            System.out.println("Client: " + str);
            str2 = str;
            System.out.print("You :");
            str = keyRead.readLine();
            pwrite.println(str);
            pwrite.flush();
        }
    }
}