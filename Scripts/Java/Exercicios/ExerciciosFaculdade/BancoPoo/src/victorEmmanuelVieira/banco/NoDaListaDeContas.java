package victorEmmanuelVieira.banco;

public class NoDaListaDeContas {

	private NoDaListaDeContas prox;
	private Conta conta;
	
	public void incluir(Conta c) {
		if (conta == null) {
		  conta = c;
		  prox = new NoDaListaDeContas();
		} else {			
			prox.incluir(c);
		}
	}

	public int size(){
		int cont = 0;
		NoDaListaDeContas atual = this;
		while(atual.conta != null) {
			cont++;
			atual = atual.prox;
		}
		return cont;
	}

	public Conta get(int n){
		NoDaListaDeContas aux = this;
		for(int i = 0; i < n; i++){
			if(aux == null) {
				return null;
			}
			aux = aux.prox;
		}
		return aux.conta;
	}

	public String listar() {
		if (conta == null) {
			return "";
		} else {
			return conta.getNum() +  " " + prox.listar();
		}
	}
	
	public Conta pesquisar(int num) {
		if (conta == null) {
			return null;
		}
		if (conta.getNum() == num) {
			return conta;
		} else {
			return prox.pesquisar(num);
		}	
	}
}
