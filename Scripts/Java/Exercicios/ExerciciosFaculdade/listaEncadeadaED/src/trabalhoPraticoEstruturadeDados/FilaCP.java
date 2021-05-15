package trabalhoPraticoEstruturadeDados;

public class FilaCP<Item>{

    private Node<Item> inicio;
    private Node<Item> fim;
    private Node<Item> inicioP;
    private Node<Item> fimP;

    private int num;
    private int numP;

    private static class Node<Item>{
        private Item pessoa;
        private Node<Item> prox;

        private Node(Item pessoa) {
            this.pessoa = pessoa;
            this.prox = null;
        }
    }

    public FilaCP() {
        this.inicio = null;
        this.fim = null;
        this.inicioP = null;
        this.fimP = null;
        this.num = 0;
        this.numP = 0;
    }

    public int tamanho() {
        return num;
    }
    public int tamanhoP() {
        return numP;
    }

    public boolean estaVazia(boolean prioridade) {
        if(prioridade) return numP == 0;
        else return num == 0;
    }

	/*public Item primeiroDaFila(boolean prioridade) { // função que "espia" qual o primeiro Item(pessoa) da fila
		if(prioridade) {
			if(estaVazia(true)) throw new NoSuchElementException("A Fila Esta Vazia.");
			return inicioP.pessoa;
		}
		else {
			if(estaVazia(false)) throw new NoSuchElementException("A Fila Esta Vazia.");
			return inicio.pessoa;
		}

	}*/

    public void adicionar(Item pessoa, boolean prioridade) {

        if(prioridade) {
            Node<Item> antigofimP = fimP;
            fimP = new Node<Item>(pessoa);

            if(estaVazia(true)) {
                inicioP =fimP;
            }else {
                antigofimP.prox = fimP;
            }
            numP++;
        }
        else {
            Node<Item> antigofim = fim;
            fim = new Node<Item>(pessoa);

            if(estaVazia(false)) {
                inicio = fim;
            }
            else {
                antigofim.prox = fim;
            }
            num++;
        }
    }

    public Item atender() {  //corresponde a opção de remover da fila(dequeue)

        if(!estaVazia(true)) {

            Item pessoa = inicioP.pessoa;
            inicioP = inicioP.prox;
            if(estaVazia(true)) fimP = null;
            numP--;
            return pessoa;

        }else {
            Item pessoa = inicio.pessoa;
            inicio = inicio.prox;
            if(estaVazia(false)) fim = null;
            num--;
            return pessoa;
        }

    }

    public void exibir() {

        Node<Item> aux;

        System.out.print("\nFILA PRIORITARIA: ");
        aux = inicioP;
        while(aux!=null) {
            System.out.print(aux.pessoa);
            if(aux.prox != null) System.out.print(", ");
            aux = aux.prox;
        }
        System.out.println();
        System.out.print("FILA COMUM: ");
        aux = inicio;
        while(aux!=null) {
            System.out.print(aux.pessoa);
            if(aux.prox != null) System.out.print(", ");
            aux = aux.prox;
        }
        System.out.println("\n");
    }

}