package br.com.bytebank.banco.teste;

import br.com.bytebank.banco.modelo.Cliente;
import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.ContaPoupanca;
import br.com.bytebank.banco.modelo.GuardadorDeContas;

public class Teste {

	public static void main(String[] args) {
		
		GuardadorDeContas guardador = new GuardadorDeContas();
		Conta cc = new ContaCorrente(22,11);
		Conta cp = new ContaPoupanca(15, 12);
		
		Cliente cliente = new Cliente();
		cliente.setNome("Dorateu");
		
		guardador.adiciona(cc);
		guardador.adiciona(cp);
		guardador.adiciona(cliente);
		
		int tamanho = guardador.getQuantidadeDeElementos();
		System.out.println(tamanho);
		
		Conta ref = (Conta) guardador.getReferencias(2);
		
		System.out.println(ref);
		
	}
	
}
