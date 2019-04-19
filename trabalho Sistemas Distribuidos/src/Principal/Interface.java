package Principal;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Interface {

static JFrame frame;
    public static String LerTexto(String leitura) {
        String retorno;
        retorno = JOptionPane.showInputDialog(null, leitura, "Janela Principal", JOptionPane.QUESTION_MESSAGE);  
        return retorno;
    }

    public static void Erro(String cima, String texto) {

        JOptionPane.showMessageDialog(null, texto, cima, JOptionPane.ERROR_MESSAGE);
    }

    public static void Aviso(String cima, String texto) {
    	System.out.println("Aviso\t"+cima);
        JOptionPane.showMessageDialog(null, texto, cima, JOptionPane.INFORMATION_MESSAGE);
    }
    public static String Mensagem(String frase) {
        String Entrada;
       // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Entrada = JOptionPane.showInputDialog(null, frase, "Escrever Mensagem", JOptionPane.QUESTION_MESSAGE);
        Aviso("mensagem envida original:", Entrada);
        return Entrada;
    }
    public static String Pesquisa (String frase){
       String Entrada;
       // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Entrada = JOptionPane.showInputDialog(null, frase, "Resultado", JOptionPane.INFORMATION_MESSAGE);
        return Entrada;
      
    }

    

}
