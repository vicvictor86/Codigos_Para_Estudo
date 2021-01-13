package br.com.bytebank.banco.teste;

import br.com.bytebank.banco.modelo.*;

public class TesteTributaveis {

	public static void main(String[] args) {
		
		ContaCorrente cc = new ContaCorrente(222, 333);
		cc.deposita(100.0);
		
		SeguroDeVida seguro = new SeguroDeVida();
		
		CalculadorImposto calculador = new CalculadorImposto();
		
		calculador.registra(cc);
		calculador.registra(seguro);
		
		System.out.println(calculador.getTotalImposto());
		
	}
	
}
