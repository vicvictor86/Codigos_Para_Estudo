package listaEncadeadeSimplesCircular;

public class ListaEncadeadaSimplesCircular {

    private Node inicio = null;
    private Node ultimo = null;
    private int totalDeElementos = 0;

    public void adicionaNoInicio(String elemento){
        Node novoNode = new Node(elemento, inicio);
        this.inicio = novoNode;

        //Primeira inserção o primeiro e ultimo são o mesmo nó
        if(totalDeElementos == 0){
            this.ultimo = novoNode;
        }

        //Precisa atualizar as informações do último nó após a inserção de um novo nó inicial
        this.ultimo.setProximo(inicio);
        totalDeElementos++;
    }

    public void adicionaNoFinal(String elemento){
        //Se a lista estiver vazia o método adicionarNoFinal do jeito que está implementado
        //Daria NullPointerException pois this.ultimo seria null
        if(totalDeElementos == 0){
            adicionaNoInicio(elemento);
            return;
        }
        Node novoNode = new Node(elemento, inicio);

        this.ultimo.setProximo(novoNode);
        this.ultimo = novoNode;
        totalDeElementos++;
    }

    public Node procuraElemento(int posicao){
        Node atual = inicio;
        for(int i = 0; i < posicao; i++){
            atual = atual.getProximo();
        }
        return atual;
    }

    public void mostraElementos(){
        Node atual = inicio;
        System.out.print("[");

        for(int i = 0; i < totalDeElementos; i++){
            System.out.print(atual.getElemento());
            if(i != totalDeElementos - 1){
                System.out.print(",");
            }
            atual = atual.getProximo();
        }

        System.out.print("]");
        System.out.println();
    }
}
