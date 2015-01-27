package quoteServer;

import java.io.*;
import java.net.*;

public class quote_server_connect{

        static Socket kkSocket = null;
        static PrintWriter out = null;
        static BufferedReader in = null;
        
	public static String getQuote(String fromUser) throws IOException{
        try {
			// change the socket number to match that of your group
            kkSocket = new Socket("quoteserve.seng.uvic.ca", 4444);
            out = new PrintWriter(kkSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(kkSocket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: quoteserve.seng.uvic.ca");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection Project Quote Server likely down");
            System.exit(1);
        }

        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        String fromServer;

        //System.out.println("Enter: StockSYM, userid\n");
        //System.out.println("  Invalid entry will return 'NA' for userid.\n");
        //System.out.println("  Returns: quote,sym,userid,timestamp,cryptokey\n");
        //fromUser = stdIn.readLine();
        //System.out.println("\nClient: " + fromUser + "\n");

        out.println(fromUser);

        fromServer = in.readLine();
        //System.out.println("Server: " + fromServer + "\n");
		    
        out.close();
        in.close();
        stdIn.close();
        kkSocket.close();
        
        return fromServer;
	}
}