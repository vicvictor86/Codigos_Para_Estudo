package listaligada;

public class ListaLigada {

    private Celula primeira = null;
    private Celula ultima = null;
    private int totalDeElementos = 0;

    public void adicionaNoComeco(Object elemento){

        if(totalDeElementos == 0){
            Celula nova = new Celula(elemento);
            this.primeira = nova;
            this.ultima = nova;
        }else{
            Celula novaCelula = new Celula(elemento, this.primeira);
            this.primeira.setAnterior(novaCelula);
            this.primeira = novaCelula;
        }

        this.totalDeElementos++;
    }

    //Adiciona no final
    public void adiciona(Object elemento){
        if(totalDeElementos == 0){
            adicionaNoComeco(elemento);
        } else {
            Celula nova = new Celula(elemento);
            this.ultima.setProximo(nova);
            nova.setAnterior(ultima);
            this.ultima = nova;
            totalDeElementos++;
        }
    }

    private boolean posicaoOcupada(int posicao){
        return posicao >= 0 && posicao < totalDeElementos;
    }
    private Celula pegaCelula(int posicao){
        if(!posicaoOcupada(posicao)){
            throw new IllegalArgumentException("Posição inválida");
        }

        Celula atual = primeira;
        for(int i = 0; i < posicao; i++){
            atual = atual.getProximo();
        }

        return atual;
    }

    public void adiciona(int posicao, Object elemento){

        if(posicao == 0){
            adicionaNoComeco(elemento);
        }else if(posicao == totalDeElementos){
            adiciona(elemento);
        }else{
            Celula anterior = pegaCelula(posicao - 1);
            Celula proxima = anterior.getProximo();

            Celula nova = new Celula(elemento, proxima);
            anterior.setProximo(nova);
            nova.setAnterior(anterior);
            proxima.setAnterior(nova);
            totalDeElementos++;
        }
    }
    public Object pega(int posicao){
        return this.pegaCelula(posicao).getElemento();
    }
    public void removeDoComeco(){
        if(totalDeElementos == 0){
            throw new IllegalArgumentException("Lista vazia");
        }

        this.primeira = primeira.getProximo();
        totalDeElementos--;

        if(totalDeElementos == 0){
            this.ultima = null;
        }
    }

    public void remove(int posicao){

        if(posicao == 0){
            removeDoComeco();
        }else if(posicao == totalDeElementos - 1){
            removeDoFim();
        }else{
            Celula anterior = pegaCelula(posicao - 1);
            Celula atual = anterior.getProximo();
            Celula proxima = atual.getProximo();

            anterior.setProximo(proxima);
            proxima.setAnterior(anterior);

            totalDeElementos--;
        }
    }

    public void removeDoFim(){
        if(totalDeElementos == 1){
            this.removeDoComeco();
        }else{
            Celula penultima = this.ultima.getAnterior();
            penultima.setProximo(null);
            ultima = penultima;
            this.totalDeElementos--;
        }
    }

    public int tamanho(){
        return this.totalDeElementos;
    }
    public boolean contem(Object elemento){

        Celula atual = this.primeira;

        while(atual != null){
            if(atual.getElemento().equals(elemento)){
                return true;
            }

            atual = atual.getProximo();
        }

        return false;
    }

    @Override
    public String toString() {
       if(this.totalDeElementos == 0){
           return "[]";
       }

       Celula atual = primeira;
       StringBuilder builder = new StringBuilder("[");

       for (int i = 0; i < totalDeElementos; i++){
           builder.append(atual.getElemento());
           builder.append(",");

           atual = atual.getProximo();
       }

       builder.append("]");

       return  builder.toString();
    }

}
