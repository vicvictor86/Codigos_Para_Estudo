package br.com.bytebank.banco.teste;

import br.com.bytebank.banco.modelo.*;

public class TestaContas {

	public static void main(String[] args) throws SaldoInsuficienteException{
		
		System.out.println("Começo do TestaContas");
		ContaCorrente cc = new ContaCorrente(111, 111);
		cc.deposita(100.0);
		
		ContaPoupanca cp = new ContaPoupanca(222, 222);
		cp.deposita(200.0);
		
		cc.transfere(10.0, cp);
		System.out.println("Conta Corrente saldo: " + cc.getSaldo());
		System.out.println("Conta corrente pupança: " +  cp.getSaldo());
		
		System.out.println("Fim do TestaContas");
		
	}
	
}
