package br.com.bytebank.banco.teste.util;

import java.util.ArrayList;

public class TesteWrapperInteger {

	public static void main(String[] args) {
		
		Integer idadeRef = Integer.valueOf(29);
		int valor = idadeRef.intValue();
		System.out.println(idadeRef.doubleValue());
		System.out.println(idadeRef.floatValue());
		
		
		
		String s = args[0];
		
		Integer numero = Integer.valueOf(s);
		System.out.println(numero);
		
		ArrayList<Integer> numeros = new ArrayList<Integer>();
		numeros.add(29);
		
	}
	
}
