package victorEmmanuelVieira.banco;

public class VetorDeContas {

	private Conta contas[] = new Conta[50];
	private int cont = 0;
	
	public void incluir(Conta c) {
		contas[cont++] = c;  
	}

	public int size(){
		return cont;
	}

	public Conta get(int n){
		if(n < cont){
			return contas[n];
		}
		return null;
	}
	
	public Conta pesquisar(int n) {
		for (int i = 0; i < cont; i++) {
			if (n == contas[i].getNum()) {
				return contas[i];
			}
		}
		return null;
	}
}
