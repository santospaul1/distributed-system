import java.io.*;
import java.net.*;
import java.util.*;

public class TCP {
    private static ServerSocket serverSocket;
    private static final int PORT = 1234;

    public static void main(String[] args) {
        System.out.println("Opening port... \n");
        try {
            //Step 1: Create a serverSocket object
            serverSocket = new ServerSocket(PORT);
        } catch (IOException ioEx) {
            System.out.println("Unable to attach to the port");
            System.exit(1);
        }

        do {
            handleClient();
        } while (true);
    }

    private static void handleClient() {
        Socket link = null;
        try {
            //Step 2: Put server into waiting state
            link = serverSocket.accept();
            //Step 3: Setup input and output stream
            Scanner input = new Scanner(link.getInputStream());
            PrintWriter output = new PrintWriter(link.getOutputStream(), true);

            int numMessages = 0;
            //Step 4: Send and Receive data
            String message = input.nextLine();
            
            while (!message.equals("***CLOSE***")) {
                System.out.println("Message received.");
                numMessages++;
                output.println("Message " + numMessages + ": " + message);
                message = input.nextLine();
            }

            output.println(numMessages + " message(s) received");
        } catch (IOException ioEx) {
            ioEx.printStackTrace();
        } finally {
            try {
                //Step 5: Close the connection
                System.out.println("\n* Closing connection");
                link.close();
            } catch (IOException ioEx) {
                System.out.println("Unable to disconnect");
                System.exit(1);
            }
        }
    }
}
