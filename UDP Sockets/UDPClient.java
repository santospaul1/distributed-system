import java.io.*;
import java.net.*;

public class UDPServer {
    private static final int PORT = 1234;
    private static DatagramSocket datagramSocket;
    private static DatagramPacket inpacket, outpacket;
    private static byte[] buffer;

    public static void main(String[] args) {
        try {
            // Step 1: create a datagram socket object
            datagramSocket = new DatagramSocket(PORT);
            System.out.println("Opening port");

        } catch (SocketException sockEx) {
            System.out.println("Unable to open port");
            System.exit(1);
        }
        handleClient();
    }

    private static void handleClient() {
        String messageIn, messageOut;
        int numMessages = 0;
        InetAddress clientAddress = null;
        int clientPort;
        try {
            do {
                // Step 2: Create a buffer for incoming datagram
                buffer = new byte[256];

                // Step 3: Create a datagram packet object for the incoming datagram
                inpacket = new DatagramPacket(buffer, buffer.length);

                // Step 4: Accept the incoming datagram
                datagramSocket.receive(inpacket);

                // Step 5: Accept the sender's address and port from the packet
                clientAddress = inpacket.getAddress();
                clientPort = inpacket.getPort();

                // Step 6: Retrieve the data from the buffer
                messageIn = new String(inpacket.getData(), 0, inpacket.getLength());
                System.out.println("Message Received");
                System.out.println(messageIn);
                numMessages++;
                messageOut = "Message " + numMessages + ": " + messageIn;

                // Step 7: Create the response Datagram
                outpacket = new DatagramPacket(messageOut.getBytes(), messageOut.length(), clientAddress, clientPort);

                // Step 8: Send the response datagram
                datagramSocket.send(outpacket);

            } while (true);

        } catch (IOException ioEx) {
            ioEx.printStackTrace();
        } finally {

            // Step 9: Close the connection
            System.out.println("Closing the connection");
            datagramSocket.close();
        }
    }
}
