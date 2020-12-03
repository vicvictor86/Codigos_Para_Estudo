package br.com.bytebank.banco.teste;

public class TesteString {
	
	public static void main(String[] args) {
		
		String nome = "ALURA";
		StringBuilder cs = new StringBuilder("al");
		
		nome = nome.replace("AL", cs);
		
		System.out.println(nome);
		
		
		
		
	}
	
}
