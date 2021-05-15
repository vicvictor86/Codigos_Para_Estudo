package listaEncadeadaSimples;

class Node {

    //Um nó só funciona se tiver um elemento e o próximo
    //Logo cria-se um construtor pra facilitar a inicialização
    public Node(String elemento, Node proximo){
        this.elemento = elemento;
        this.proximo = proximo;
    }

    private String elemento;
    private Node proximo;

    public String getElemento() {
        return elemento;
    }

    public Node getProximo() {
        return proximo;
    }

    public void setProximo(Node proximo) {
        this.proximo = proximo;
    }
}
