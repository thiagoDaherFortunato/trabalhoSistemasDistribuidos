package Principal;

import java.net.*;
import java.io.*;

public class TCPServer {
	


	public static void executarServer() {
		// TODO Auto-generated method stub
		try{
			int serverPort = 5678;
			ServerSocket listenSocket = new ServerSocket(serverPort);
			System.out.println("Servidor escutando a porta: " + serverPort);
			while(true){
				Socket clientSocket = listenSocket.accept();
				Connection connection = new Connection(clientSocket);
			}
		}catch(IOException e){
			System.out.println("Listen: " + e.getMessage());
		}
		
	}

}

