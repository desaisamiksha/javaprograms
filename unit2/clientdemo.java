import java.io.*;
import java.net.*;

public class clientdemo {
    public static void main(String args[]) {
        try {
            Socket soc = new Socket("localhost", 5217); 
            BufferedReader br = new BufferedReader(new InputStreamReader(soc.getInputStream()));
            String serverDate = br.readLine(); 
            System.out.println(serverDate); 
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage()); 
        }
    }
}
