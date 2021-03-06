package Principal;

/*
 * Dupla Thiago e Matheus
 * 
*/
public class Citala {
	
	public static String CripitografarMensagem(String mensagem,int chave) {
		// O "1" marca onde tem um espaço e preenche a tabela quando precisa.
		String mensagemSemEpaco = mensagem.replaceAll(" ", "1");
		System.out.println(chave);
		int tamanhoMatriz=0;
		if(mensagemSemEpaco.length() % chave > 0) {
			tamanhoMatriz = (mensagemSemEpaco.length() / chave)+1;
		}else {
			tamanhoMatriz = (mensagemSemEpaco.length() / chave);
		}
		
		char[][] matriz = new char[chave][tamanhoMatriz];
		String mensagemCriptografada=Criptografia(preencherMatriz(matriz,mensagemSemEpaco),chave,tamanhoMatriz);
		return mensagemCriptografada;
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
				contador++;
			}
		
		}
		return matriz;
	}
	
	public static String Criptografia(char[][] matriz,int chave, int tamanhoMatriz) {
		String mensagemCriptografada= "";
		
		for (int i =0;i<tamanhoMatriz;i++) {
			for (int j =0;j<chave;j++) {
				if(j<chave) {
					mensagemCriptografada+=matriz[j][i];
				}
			}
		}
		
		return mensagemCriptografada;
		
	}
	
	public  static String DesCripitografar(String mensagemCriptografada,int chave) {
	
		
		String mensagemSemEpaco = mensagemCriptografada.replaceAll("1", " ");
		int tamanhoMatriz=0;
		if(mensagemSemEpaco.length() % chave > 0) {
			tamanhoMatriz = (mensagemSemEpaco.length() / chave)+1;
		}else {
			tamanhoMatriz = (mensagemSemEpaco.length() / chave);
		}
		
		char[][] matriz = new char[tamanhoMatriz][chave];
		String mensagemOriginal= Desciptografia(preencherMatriz(matriz,mensagemSemEpaco),chave,tamanhoMatriz);
		
		return mensagemOriginal;
	}
	

	public static String Desciptografia(char[][] matriz,int chave, int tamanhoMatriz) {
		String mensagemCriptografada= "";
		for (int i =0;i<chave;i++) {
			for (int j =0;j<tamanhoMatriz;j++) {
					mensagemCriptografada+=matriz[j][i];
			}
		}

		return mensagemCriptografada;
		
	}
	

	
	
}
