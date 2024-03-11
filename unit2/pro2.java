import java.io.*;
import java.net.*;
public class u2p2
{
public static void main(String args[])throws Exception
{
try
{
System.out.println("Enter website address(for eg:www.google.com):");
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
String str=br.readLine();
InetAddress ip=InetAddress.getByName(str);

System.out.println("Host Name :"+ip.getHostName());
System.out.println("IP Address :"+ip.getHostAddress());
}
catch(UnknownHostException ex)
{
System.out.println("Error :"+ex);
}
catch(Exception e)
{
System.out.println("Error :"+e);
}
}
}
