import java.io.*;
import java.net.*;
import java.util.*;

public class Client {
    private static InetAddress host;
    private static final int PORT = 1234;

    public static void main(String[] args) {
        try {
            
            host = InetAddress.getLocalHost();
        } catch (UnknownHostException unEx) {
            System.out.println("Host id not found");
            System.exit(1);
        }
        accessServer();
    }

    private static void accessServer() {
        Socket link = null;
        try {
            //Step 1: Establish a connection to the server
            link = new Socket(host, PORT);
            //Step 2: Setup Input and output Strean
            Scanner input = new Scanner(link.getInputStream());
            PrintWriter output = new PrintWriter(link.getOutputStream(), true);

            Scanner userEntry = new Scanner(System.in);
            String message, response;

            do {
                
                System.out.println("Enter a message");
                message = userEntry.nextLine();
                //Step 3: Send and receive data
                output.println(message);
                response = input.nextLine();
                
                System.out.println("\nSERVER> " + response);
            } while (!message.equals("***CLOSE***"));
        } catch (IOException ioEx) {
            ioEx.printStackTrace();
        } finally {
            try {
                //Step 4: Close the connection
                System.out.println("\nClosing connection");
                link.close();
            } catch (IOException ioEx) {
                System.out.println("Unable to disconnect!");
                System.exit(1);
            }
        }
    }
}
