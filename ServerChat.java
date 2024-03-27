package ServerClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerChat {

	static int port = 7777;

	public static void main(String[] args) throws IOException {
		System.out.println("\t\t Simple Socker Server");
		System.out.println("\t\t=====================\n\n");

		ServerSocket serversocket = new ServerSocket(port);
		Scanner ScannerInput = new Scanner(System.in);
		String input, output;
		
		try {
			while (true) {
			Socket socket = serversocket.accept();
			System.out.println("Client is connected.....\n\n");
			
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));   
			
			try {
				out.println("Welcome to Chat Application");
				while(true) {
					input = in.readLine();
					System.out.println("Client Says: "+ input);
					
					System.out.println("Server: ");
					output = ScannerInput.nextLine();
					out.println(output);
				}
			
			} finally {
				socket.close();
				out.close();
				in.close();
			}
		}
		}finally {
			serversocket.close();
		}
	}

}





