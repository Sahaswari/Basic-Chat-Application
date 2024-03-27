package ServerClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	static int port = 6600;
	
	public static void main(String[] args) throws IOException {
		
		System.out.println("\t\t Simple Client");
		System.out.println("\t\t================\n\n");
		
		InetAddress ipAddress = InetAddress.getLocalHost(); 
		
		Socket socket = new Socket(ipAddress, port);  //creating client socket
		
		System.out.println("Server is connected....\n\n");
		
		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String input = in.readLine();
		
		System.out.println("Server Says:" + input);
		
		System.out.println("Closing Connection.....");
		
		socket.close();
		in.close();
		
		System.exit(0);
	
	}

}








