package listaEncadeadaDupla;

class Node {

    //Um nó só funciona se tiver um elemento e o próximo
    //Logo cria-se um construtor pra facilitar a inicialização
    public Node(String elemento, Node proximo, Node anterior){
        this.elemento = elemento;
        this.proximo = proximo;
        this.anterior = anterior;
    }

    private String elemento;
    private Node proximo;
    private Node anterior;

    public String getElemento() {
        return elemento;
    }

    public Node getProximo() {
        return proximo;
    }

    public void setProximo(Node proximo) {
        this.proximo = proximo;
    }

    public Node getAnterior() {
        return anterior;
    }

    public void setAnterior(Node anterior) {
        this.anterior = anterior;
    }
}
