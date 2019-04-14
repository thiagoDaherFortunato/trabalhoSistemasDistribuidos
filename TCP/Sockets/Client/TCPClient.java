package TCP.Sockets.Client;

import java.net.*;
import java.io.*;

public class TCPClient {

	public static void main(String[] args) {
		//
		Socket socket = null;
		try{
			int serverPort = 5678;
			socket = new Socket("localhost", serverPort);
			DataInputStream in = new DataInputStream(socket.getInputStream());
			DataOutputStream out = new DataOutputStream(socket.getOutputStream());
			
			out.writeUTF("Mensagem do cliente TCP...");
			String dataReceived = in.readUTF();
			System.out.println("Dados recebidos: " + dataReceived);
			
		}catch(EOFException e){
			System.out.println("EOF: " + e.getMessage());
		}catch(IOException e){
			System.out.println("IO: " + e.getMessage());
		}finally{
			if(socket != null)
				try{
					socket.close();
				}catch(IOException e){
					System.out.println("Falha ao fechar a conexão: " + e.getMessage());
				}
		}

	}
}
