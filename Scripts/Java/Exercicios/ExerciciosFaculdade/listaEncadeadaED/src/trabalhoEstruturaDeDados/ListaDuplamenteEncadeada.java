package trabalhoEstruturaDeDados;

public class ListaDuplamenteEncadeada {
	private class Node {
		public String nome;
		private Node prox = null;
		private Node anterior = null;
		public Node(String n) {
			this.nome = n;
		}
	}
	private Node inicio;
	public ListaDuplamenteEncadeada() {
		inicio = null;
	}
	public boolean buscar(String n) {
		Node aux = inicio;
		if(aux == null)
			return false;
		else {
			do {
				if(aux.nome.contentEquals(n)){
					return true;
				}
				aux = aux.prox;
			}while(aux != null);
		}
		return false;
	}
	public void inserirInicio(String n) {
		if(buscar(n) == true)
			return;
		if(inicio == null) {
			inicio = new Node(n);
			return;
		}
		Node aux = inicio;
		inicio = new Node(n);
		inicio.prox = aux;
		aux.anterior = inicio;
	}

	public void inserirFinal(String n) {
		if(inicio == null) {
			inicio = new Node(n);
			return;
		}
		Node aux = inicio;
		do {
			if(aux.nome.contentEquals(n)){
				System.out.println("Esse nome já existe");
				return;
			}
			if (aux.prox == null) {
				aux.prox = new Node(n);
				aux.prox.anterior = aux;
				return;
			}
			else
				aux = aux.prox;
		}while(aux != null);
	}
	public void excluir(String n) {
		if(inicio.nome.contentEquals(n)) {
			inicio = inicio.prox;
			System.out.println("Nome excluido da lista");
			return;
		}
		Node aux = inicio.prox;
		do {
			if (aux.nome.contentEquals(n)) {
				if(aux.prox == null) {
					aux.anterior.prox = null;
				}
				else {
					aux.prox.anterior = aux.anterior;
					aux.anterior.prox = aux.prox;
				}
				System.out.println("Nome excluido da lista");
				return;
			}
			else
				aux = aux.prox;
		}while(aux != null);
		System.out.println("Nome não encontrado!");
	}
	public void listarNomes() {
		if(inicio == null) {
			System.out.println("Sem nomes cadastrados!");
			return;
		}
		Node aux = inicio;
		do {
			System.out.println(aux.nome);
			aux = aux.prox;
		}while(aux!=null);
	}
}

