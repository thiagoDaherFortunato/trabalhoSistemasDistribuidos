package Principal;

import java.net.*;
import java.io.*;

public class TCPServer {

	public static void main(String[] args) {
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

class Connection extends Thread{
	DataInputStream in;
	DataOutputStream out;
	Socket clientSocket;
	
	public Connection(Socket aClientSocket){
		try{
			clientSocket = aClientSocket;
			in = new DataInputStream(clientSocket.getInputStream());
			out = new DataOutputStream(clientSocket.getOutputStream());
			this.start();
		}catch(IOException e){
			System.out.println("Connection: " + e.getMessage());
		}
	}
	
	public void run(){
		try{
			String data = in.readUTF();
			System.out.println("Mensagem recebida: " + data);
			out.writeUTF("TCPServer: teste de envio de mensagem.");
		}catch(EOFException e){
			System.out.println("EOF: " + e.getMessage());
		}catch(IOException e){
			System.out.println("IO: " + e.getMessage());
		}finally{
			try{
				clientSocket.close();
			}catch(IOException e){
				System.out.println("Falha ao fechar o clientSocket: " + e.getMessage());
			}
		}
	}
	
}
