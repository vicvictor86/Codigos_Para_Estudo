package br.com.bytebank.banco.teste.util;

import java.util.ArrayList;

import br.com.bytebank.banco.modelo.Cliente;
import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.ContaPoupanca;

public class TesteArrayList {

	public static void main(String[] args) {
		
		ArrayList<Conta> lista = new ArrayList<Conta>();
		
		Conta cc1 = new ContaCorrente(22,11);
		Conta cc2 = new ContaCorrente(15, 12);
		
		lista.add(cc1);
		lista.add(cc2);
		
		System.out.println("Tamanho: " + lista.size());
		
		Conta ref = lista.get(0);
		
		Conta cc3 = new ContaCorrente(222,111);
		Conta cc4 = new ContaCorrente(115,112);
		
		lista.add(cc3);
		lista.add(cc4);
		
		System.out.println("Tamnho: " + lista.size());
		
		for(int i = 0; i < lista.size(); i++) {
			Conta contas = lista.get(i);
			System.out.println(contas);
		}
		
		
	}

}
