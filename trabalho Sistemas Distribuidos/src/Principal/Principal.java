package Principal;

public class Principal extends javax.swing.JFrame {


	public static void main(String[] args) {
		int chave=4;
		TCPServer.executarServer(chave);
		TCPClient.executarCliente(gerarInterface(),chave);

	}
	  static String gerarInterface() {
	        return Interface.Mensagem("Insira a sua mensagem:\n");
	    }


}
