import java.io.*;
import java.net.*;
import java.util.*;

public class UDPClient {
    private static InetAddress host;
    private static final int PORT = 1234;
    private static DatagramSocket datagramSocket;
    private static DatagramPacket inpacket, outpacket;
    private static byte[] buffer;

    public static void main(String[] args) throws IOException {
        try {
            
            host = InetAddress.getLocalHost();
        } catch (UnknownHostException unEx) {
            System.out.println("Host id not found");
            System.exit(1);
        }
        accessServer();
    }

    private static void accessServer() throws IOException {
        //Step 1: Create a datagram object
        datagramSocket = new DatagramSocket();

        Scanner userEntry = new Scanner(System.in);
        String message = "", response = "";
        do {
            System.out.println("Enter a message: ");
            message = userEntry.nextLine();

            if (!message.equals("***CLOSE***")) {
                //Step 2: Create an outgoing datagram
                outpacket = new DatagramPacket(message.getBytes(), message.length(), host, PORT);
                //Step 3: Send datagram message
                datagramSocket.send(outpacket);

                //Step 4: create a buffer for incoming messages
                buffer = new byte[256];
                
                //Step 5: Create a datagram packet for incoming messages
                inpacket = new DatagramPacket(buffer, buffer.length);

                //Step 6: Accept an incoming datagram
                datagramSocket.receive(inpacket);

                //Step 7: Retrive the data from the buffer
                response = new String(inpacket.getData(), 0, inpacket.getLength());

                System.out.println("\n SERVER> " + response);
            }
        } while (!message.equals("***CLOSE***"));
         // Step 8: Close the connection
        datagramSocket.close();
    }
}
