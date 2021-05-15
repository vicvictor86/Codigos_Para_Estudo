package exercicios;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Questao2 {

	public static void main(String[] args) throws IOException {
		
		String path = "src/exercicios/nomes.txt";
		String[] nomes = new String[10000];
		String nome = "";
		
		BufferedReader buffRead = new BufferedReader(new FileReader(path));
		Scanner read = new Scanner(System.in);
		String linha = "";
		int i = 0;
		
		System.out.println("Digite um nome: ");
		nome = read.next();
		
		long tempoInicial = System.currentTimeMillis();
		while(i < 10000) {
			
			linha = buffRead.readLine();
			if(linha != null) {			
				nomes[i] = linha;
			}else {
				break;
			}
			i++;
		}
		
		
		
		for (int j = 0; j < nomes.length; j++) {
			if(nome.equalsIgnoreCase(nomes[j])) {
				System.out.println("O nome " + nome + " existe na lista");
				break;
			}
			else if(j == nomes.length - 1) {
				System.out.println("O nome " + nome + " não existe na lista");
			}
		}
		long tempoFinal = System.currentTimeMillis();
		System.out.println("Tempo corrido: " + (tempoFinal - tempoInicial) + " milissegundos");
		
		read.close();
		buffRead.close();		
	}
	//Tempo de processamento entre 11 e 12 milissegundos

}

