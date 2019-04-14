package UDP.Socket.Client;

import java.io.*;
import java.net.*;

public class UDPClient {

	public static void main(String[] args) {
		DatagramSocket aSocket = null;
		
		try{
			aSocket = new DatagramSocket();
			byte[] msg = "Teste de envio de mensagem!".getBytes();
			InetAddress aHost = InetAddress.getByName("localhost");
			int serverPort = 6789;
			DatagramPacket request = new DatagramPacket(msg, msg.length, aHost, serverPort);
			
			aSocket.send(request);
			
			byte[] buffer = new byte[1000];
			DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
			
			aSocket.receive(reply);
			
			System.out.println("Resposta do servidor: " + new String(reply.getData()).trim());
			
		}catch (SocketException e){
			System.out.println("Socket: " + e.getMessage());
		}catch (IOException e){
			System.out.println("IO: " + e.getMessage());
		}finally{
			if(aSocket != null)
				aSocket.close();
		}
		
	}

}
