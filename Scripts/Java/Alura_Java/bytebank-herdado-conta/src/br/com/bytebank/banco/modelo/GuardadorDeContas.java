package br.com.bytebank.banco.modelo;

public class GuardadorDeContas {

	private Object[] referencias;
	private int posicaolivre;
	
	public GuardadorDeContas() {
		this.referencias = new Object[10];
		this.posicaolivre = 0;
	}
	
	public void adiciona(Object c) {
		
		this.referencias[this.posicaolivre] = c;
		this.posicaolivre++;
		
	}
	
	public Object getReferencias(int i) {
		return referencias[i];
	}
	
	public int getQuantidadeDeElementos(){
		return this.posicaolivre;
	}
	
	
}
