import java.util.*;
import java.net.*; 

public class HostIP{
    public static void main(String[]args) throws UnknownHostException{
        String hostname;
        Scanner stdin = new Scanner(System.in);
        InetAddress address;
        System.out.print("\n\n Enter the host name: ");
        hostname = stdin.nextLine();
        address = InetAddress.getByName(hostname);
        System.out.println("The IP address for the host " +hostname+ "is: " +address.toString());
    }
}