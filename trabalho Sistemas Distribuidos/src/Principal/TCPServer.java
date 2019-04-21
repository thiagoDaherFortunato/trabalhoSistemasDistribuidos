package Principal;

import java.net.*;
import java.io.*;

/*
 * Dupla Thiago e Matheus
 * 
*/
public class TCPServer {
	


	public static void executarServer(int chave) {
		// TODO Auto-generated method stub
		try{
			int serverPort = 5678;
			ServerSocket listenSocket = new ServerSocket(serverPort);
			System.out.println("Servidor escutando a porta: " + serverPort);
			while(true){
				Socket clientSocket = listenSocket.accept();
				Connection connection = new Connection(clientSocket, chave);
			}
		}catch(IOException e){
			System.out.println("Listen: " + e.getMessage());
		}
		
	}

}

