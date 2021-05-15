package listaEncadeadaDupla;

public class ListaEncadeadaDupla {

    private Node inicio = null;
    private Node ultimo = null;
    private int totalDeElementos = 0;

    public void adicionaNoInicio(String elemento){
        Node novoNode = new Node(elemento, inicio, null);
        //Evitar NullPointerException
        if(totalDeElementos > 0){
            this.inicio.setAnterior(novoNode);
        }
        this.inicio = novoNode;

        //Primeira inserção o primeiro e ultimo são o mesmo nó
        if(totalDeElementos == 0){
            this.ultimo = novoNode;
        }
        totalDeElementos++;
    }

    public void adicionaNoFinal(String elemento){
        //Se a lista estiver vazia o método adicionarNoFinal do jeito que está implementado
        //Daria NullPointerException pois this.ultimo seria null
        if(totalDeElementos == 0){
            adicionaNoInicio(elemento);
            return;
        }
        Node novoNode = new Node(elemento, null, ultimo);
        this.ultimo.setProximo(novoNode);
        this.ultimo = novoNode;
        this.totalDeElementos++;
    }

    private boolean podeProcurar(int posicao){
        return posicao >= 0 && posicao < totalDeElementos; 
    }
    
    public Node procuraElemento(int posicao){
        Node atual = inicio;
        if(podeProcurar(posicao)){
            for(int i = 0; i < posicao; i++){
                atual = atual.getProximo();
            }
        }else{ 
            throw new IllegalArgumentException("Posição inválida");
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
