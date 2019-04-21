package Principal;
import java.net.*;
import java.io.*;
import Principal.Citala;
public class TCPClient {


	
	public static void executarCliente(String mensagem, int chave) {
		
		Socket socket = null;
		try{
			int serverPort = 5678;
			socket = new Socket("localhost", serverPort);
			DataInputStream in = new DataInputStream(socket.getInputStream());
			DataOutputStream out = new DataOutputStream(socket.getOutputStream());
			System.out.println("executarCliente"+mensagem);
			
			
			String mensagemCriptografada= Citala.CripitografarMensagem(mensagem,4);
			System.out.printf("mensagem envida original:"+mensagem);
			
			out.writeUTF(mensagemCriptografada);
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

