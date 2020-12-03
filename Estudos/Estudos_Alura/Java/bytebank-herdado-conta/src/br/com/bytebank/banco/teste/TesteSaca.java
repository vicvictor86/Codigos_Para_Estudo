package br.com.bytebank.banco.teste;

import br.com.bytebank.banco.modelo.*;


public class TesteSaca {

	public static void main(String[] args) {
		System.out.println("Inicio do TestaSaca");
		
		Conta conta = new ContaCorrente(123,321);
		conta.deposita(200.0);
		
		try {
			conta.saca(100.0);
		} catch(SaldoInsuficienteException ex) {
			System.out.println(ex.getMessage());
		}
		
		System.out.println("Saldo ContaCorrente2: " + conta.getSaldo());
		
		System.out.println("Fim do TestaSaca");
		
	}
    
	
}
