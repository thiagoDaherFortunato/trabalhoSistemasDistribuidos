package Principal;

public class Principal extends javax.swing.JFrame {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TCPServer.executarServer();
		//TCPServer.executarServer();
		TCPClient.executarCliente(gerarInterface());
		//TCPServer.executarServer();
		
		
		
	
		

	}
	  static String gerarInterface() {
	        return Interface.Mensagem("Insira a sua mensagem:\n");
	    }


}
