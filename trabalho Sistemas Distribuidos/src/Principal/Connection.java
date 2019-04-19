package Principal;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;

class Connection extends Thread{
	DataInputStream in;
	DataOutputStream out;
	Socket clientSocket;
	
	
	public Connection(Socket aClientSocket) {
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
			System.out.println("Mensagem recebida servidor: " +Citala.DesCripitografar(data,4) );
			Interface.Aviso("Mensagem recebida servidor:", Citala.DesCripitografar(data,4));
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
