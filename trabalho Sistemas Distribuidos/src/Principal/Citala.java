package Principal;

public class Citala {
	//public static void main(String[] args) {
		// System.out.println(CripitografarMensagem("o ataque será realizado amanhã",4));
		
	//}
	public static String CripitografarMensagem(String mensagem,int chave) {

		String mensagemSemEpaco = mensagem.replaceAll(" ", "");
		int tamanhoMatriz=0;
		if(mensagemSemEpaco.length() % chave > 0) {
			tamanhoMatriz = (mensagemSemEpaco.length() / chave)+1;
		}else {
			tamanhoMatriz = (mensagemSemEpaco.length() / chave);
		}
		
		char[][] matriz = new char[chave][tamanhoMatriz];
		String mensagem2=Criptografia(preencherMatriz(matriz,mensagemSemEpaco),chave,tamanhoMatriz);
		return mensagem2;
	}
	
	public static char[][] preencherMatriz(char[][] matriz,String mensagemSemEpaco) {
		int contador=0;
		for (int i =0;i<matriz.length;i++) {
			for (int j =0;j<matriz[i].length;j++) {
				if(contador<mensagemSemEpaco.length()) {
					char letra = mensagemSemEpaco.charAt(contador);
					matriz [i][j]=letra;
				}else {
					matriz [i][j]='1';
				}
				System.out.print(matriz [i][j]);
				contador++;
			}
			System.out.println();
		}
		return matriz;
	}
	
	public static String Criptografia(char[][] matriz,int chave, int tamanhoMatriz) {
		String mensagemCriptografada= "";
		
		for (int i =0;i<tamanhoMatriz;i++) {
			for (int j =0;j<chave;j++) {
				if(j<chave) {
					System.out.printf("i"+i);
					System.out.print(matriz[j][i]);
					mensagemCriptografada+=matriz[j][i];
				}
			}
			System.out.println();
		}
		
		return mensagemCriptografada;
		
	}
	
	public  static String DesCripitografar(String mensagemCriptografada) {
	
		String mensagemOriginal= "";
		
		return mensagemOriginal;
	}
	
	
}
