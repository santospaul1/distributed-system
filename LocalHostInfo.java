import java.util.*;
import java.net.*;

public class LocalHostInfo{
    public static void main(String [] args){

        try{ 
        
        InetAddress LocalHost = InetAddress.getLocalHost();
        System.out.println("Name is: " + LocalHost.getHostName());
        System.out.println("Host Address is: " + LocalHost.getHostAddress());
        System.out.println("Address is: " + LocalHost.getAddress());
        System.out.println("Hash code is: " + LocalHost.hashCode());
        }

        catch(UnknownHostException e){
            System.out.println("unable to retrieve local host information");
        }

    }
}