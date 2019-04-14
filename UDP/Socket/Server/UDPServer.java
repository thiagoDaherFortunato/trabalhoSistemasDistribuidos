package UDP.Socket.Server;
import java.net.*;
import java.io.*;

public class UDPServer {

	public static void main(String[] args) {
		DatagramSocket aSocket = null;
		String msg;
		
		try {
			aSocket = new DatagramSocket(6789);
			byte[] buffer = new byte[1000];
			
			System.out.println("Servidor escutando na porta 6789...");
			
			while(true){
				DatagramPacket request = new DatagramPacket(buffer, buffer.length);
				aSocket.receive(request);
				msg = new String(request.getData()).trim();
				System.out.println("Mensagem recebida: " + msg);
				
				DatagramPacket reply = new DatagramPacket("Mensagem recebida com sucesso".getBytes(),
														  "Mensagem recebida com sucesso".length(),
														  request.getAddress(),
														  request.getPort());
				aSocket.send(reply);
			}
			
		} catch (SocketException e) {
			System.out.println("Socket: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("IO: " + e.getMessage());
		} finally {
			if(aSocket != null){
				aSocket.close();
			}
		}
	}

}
