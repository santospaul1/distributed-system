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
        datagramSocket = new DatagramSocket();

        Scanner userEntry = new Scanner(System.in);
        String message = "", response = "";
        do {
            System.out.println("Enter a message: ");
            message = userEntry.nextLine();

            if (!message.equals("***CLOSE***")) {
                outpacket = new DatagramPacket(message.getBytes(), message.length(), host, PORT);
                datagramSocket.send(outpacket);

                buffer = new byte[256];
                inpacket = new DatagramPacket(buffer, buffer.length);
                datagramSocket.receive(inpacket);

                response = new String(inpacket.getData(), 0, inpacket.getLength());

                System.out.println("\n SERVER> " + response);
            }
        } while (!message.equals("***CLOSE***"));

        datagramSocket.close();
    }
}
