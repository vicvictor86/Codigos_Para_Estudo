package victorEmmanuelVieira.banco;

public class VetorDeContas implements EstruturaDeDadosDeContas {

	private Conta contas[] = new Conta[50];
	private int cont = 0;
	
	public void incluir(Conta c) {
		contas[cont++] = c;  
	}
	
	public int size() {
		return cont;
	}
	
	public Conta get(int i) throws ContaInexistente {
		if (i < cont) {
		  return contas[i];
		}
		throw new ContaInexistente();
	}
	
	public Conta pesquisar(int n) throws ContaInexistente {
		for (int i = 0; i < cont; i++) {
			if (n == contas[i].getNum()) {
				return contas[i];
			}
		}
		throw new ContaInexistente();
	}
}
