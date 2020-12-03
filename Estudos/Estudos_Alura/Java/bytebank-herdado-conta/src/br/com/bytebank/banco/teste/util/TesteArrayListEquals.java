package br.com.bytebank.banco.teste.util;

import java.util.ArrayList;

import br.com.bytebank.banco.modelo.Cliente;
import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.ContaPoupanca;

public class TesteArrayListEquals extends Object {

	public static void main(String[] args) {
		
		ArrayList<Conta> lista = new ArrayList<Conta>();
		
		Conta cc1 = new ContaCorrente(22,11);
		Conta cc2 = new ContaCorrente(15, 12);
		
		lista.add(cc1);
		lista.add(cc2);
		
		Conta cc3 = new ContaCorrente(15, 12); 
		boolean existe = lista.contains(cc3);
		
		System.out.println("Já existe ? " + existe);
	
		for(Conta conta : lista) {
			System.out.println(lista);
		}
		
		
	}

}
