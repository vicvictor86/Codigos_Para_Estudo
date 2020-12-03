package br.com.bytebank.banco.modelo;

import java.io.Serializable;

/**
 * 
 * Classe que representa o conceito de conta
 * 
 * @author Victor
 *
 */

public abstract class Conta extends Object implements Serializable{
	
	protected double saldo;
    private int agencia;
    private int numero;
	private Cliente titular;
	private static int total;
		
	/**
	 * Construtor que exige a definição do número da agência 
	 * @param agencia
	 */
	public Conta(int agencia) {
		
		this(agencia,221);
	}
	
	public Conta(int agencia, int numero) {
		
		Conta.total++;
		//System.out.println("O total de contas é: " + total);
		this.agencia = agencia;
		this.numero = numero;
	}
	
	public void deposita(double valor) {
		this.saldo += valor;
	}
	
	public void saca(double valor) throws SaldoInsuficienteException {
		
		if(this.saldo < valor) {
			throw new SaldoInsuficienteException("Saldo: " + this.saldo + ", valor: " + valor);
		}
		
		this.saldo -= valor;
	}
	
	public void transfere(double valor, Conta destino) throws SaldoInsuficienteException{
		
		this.saca(valor); 
		destino.deposita(valor);		
		
	}
	
	public double getSaldo() {
		return this.saldo;
	}
	
	public int getNumero() {
		return this.numero;
	}
	
	public void setNumero(int numero) {
		if(numero <= 0) {
			System.out.println("Não pode valor <=0");
			return;
		}
		this.numero = numero;
	}
	
	public int getAgencia() {
		return agencia;
	}
	
	public void setAgencia(int agencia) {
		if(agencia <= 0) {
			System.out.println("Não pode valor menor ou igual a 0");
			return;
		}
		this.agencia = agencia;
	}
    
	public Cliente getTitular() {
		return titular;
	}
	
	public void setTitular(Cliente titular) {
		this.titular = titular;
	}
	
	public static int getTotal() {
		return total;
	}
	
	@Override
	public boolean equals(Object outra) {
		
		Conta ref = (Conta) outra;
		
		if(this.numero == ref.numero && this.agencia == ref.agencia) {
			return true;
		}
		
		return false;
	}
	
	@Override
	public String toString() {
		
		return "Numero: " + this.getNumero() + ", Agência: " + this.agencia;
	}

	
	
	
	
}