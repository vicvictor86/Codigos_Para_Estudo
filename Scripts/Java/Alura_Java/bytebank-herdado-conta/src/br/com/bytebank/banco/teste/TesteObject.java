package br.com.bytebank.banco.teste;

import br.com.bytebank.banco.modelo.Cliente;
import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.ContaPoupanca;

public class TesteObject {

	public static void main(String[] args) {
		
		ContaCorrente cc = new ContaCorrente(22, 33);
		ContaPoupanca cp = new ContaPoupanca(33, 22);
		Cliente cliente = new Cliente();
		
		System.out.println(cc);
		System.out.println(cp);
		
		
	}
	
	
	//Para que o println consiga usar como parametros,referencias do tipo cc e cp
	//Sem saber da existência prévia dessas classes o Java se utiliza de uma classe mais
	//generalizada o object
	//Então para criar um método gera-la assim faz-se dessa forma
	
	static void println(Object referencia) {
		
		//Implementação
		
	}
	
	
}
