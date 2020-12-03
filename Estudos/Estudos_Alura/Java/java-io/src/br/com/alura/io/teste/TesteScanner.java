package br.com.alura.io.teste;

import java.io.InputStream;
import java.util.Scanner;

public class TesteScanner {

	public static void main(String[] args) {
		
		InputStream is = System.in;
		Scanner scanner = new Scanner(is);
		String linha = scanner.nextLine();
		System.out.println(linha);
		
		scanner.close();

	}

}
