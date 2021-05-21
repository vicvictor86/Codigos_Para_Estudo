package victorEmmanuelVieira.banco;

public class NoDaListaDeContas implements EstruturaDeDadosDeContas {

	private NoDaListaDeContas prox = null;
	private Conta conta = null;

		
	public void incluir(Conta c) {
		if (conta == null) {
		  conta = c;
		  prox = new NoDaListaDeContas();
		} else {
			prox.incluir(c);
		}
	}
	
	public Conta getConta() {
		return conta;
	}
	
//	public int size() {
//		int tam = 0;
//		NoDaListaDeContas atual = this;
//		
//		while (atual.conta != null) {
//			tam++;
//			atual = atual.prox;
//		}
//		return tam;
//	}
	
	public int size() {
		if (conta == null) {
			return 0;
		} else {
			return prox.size() + 1;
		}
	}
	   
	public Conta get(int i) throws ContaInexistente {
		int indice = 0;
		NoDaListaDeContas atual = this;
		
		while (atual.conta != null) {
			if (indice == i) {
				return atual.conta;
			}
			indice++;
			atual = atual.prox;
		}
		throw new ContaInexistente();
	}
	
	public String listar() {
		if (conta == null) {
			return "";
		} else {
			return conta.getNum() +  " " + prox.listar();
		}
	}
	
	public Conta pesquisar(int num) throws ContaInexistente {
		if (conta == null) {
			throw new ContaInexistente();
		}
		if (conta.getNum() == num) {
			return conta;
		} else {
			return prox.pesquisar(num);
		}	
	}
}
