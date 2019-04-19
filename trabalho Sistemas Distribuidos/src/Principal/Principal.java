package Principal;

public class Principal extends javax.swing.JFrame {


	public static void main(String[] args) {
		
		TCPServer.executarServer();
		TCPClient.executarCliente(gerarInterface());
		TCPServer.executarServer();
	}
	  static String gerarInterface() {
	        return Interface.Mensagem("Insira a sua mensagem:\n");
	    }


}
