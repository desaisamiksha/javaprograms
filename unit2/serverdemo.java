import java.net.*;
import java.io.*;
import java.util.*;

public class serverdemo {
    public static void main(String args[]) {
        try {
            ServerSocket s = new ServerSocket(5217);
            while (true) {
                System.out.println("Waiting for Connection......");
                Socket soc = s.accept();
                DataOutputStream out = new DataOutputStream(soc.getOutputStream());
                out.writeBytes("server date :" + (new Date()).toString());
                out.flush(); 
                out.close();
                soc.close();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage()); 
        }
    }
}
