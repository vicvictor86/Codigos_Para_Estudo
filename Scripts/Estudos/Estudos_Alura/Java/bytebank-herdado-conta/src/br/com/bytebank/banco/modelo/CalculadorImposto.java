package br.com.bytebank.banco.modelo; 

//br.com.bytebank.banco.modelo => FQN
public class CalculadorImposto {

	private double totalImposto;
	
	public void registra(Tributavel t) {
		
		double tributo = t.getValorImposto();
		this.totalImposto += tributo;
		
	}
	
	public double getTotalImposto() {
		return totalImposto;
	}
	
}
