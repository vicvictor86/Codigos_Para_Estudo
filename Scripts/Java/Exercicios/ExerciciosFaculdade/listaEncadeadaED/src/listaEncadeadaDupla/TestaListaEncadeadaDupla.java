package listaEncadeadaDupla;

public class TestaListaEncadeadaDupla {

    public static void main(String[] args) {
        ListaEncadeadaDupla lista = new ListaEncadeadaDupla();

        lista.adicionaNoInicio("Carlos");
        lista.adicionaNoInicio("Victor");
        lista.adicionaNoInicio("Diego");
        lista.adicionaNoFinal("Rebeca");

        lista.mostraElementos();
        //Teste para ver se está pegando o anterior
        System.out.println(lista.procuraElemento(2).getAnterior().getElemento());
        System.out.println(lista.procuraElemento(2).getProximo().getElemento());
    }
}
