package listaEncadeadaSimples;

public class TestaListaEncadeadaSimples {

    public static void main(String[] args) {
        ListaEncadeadaSimples lista = new ListaEncadeadaSimples();

        lista.adicionaNoInicio("Carlos");
        lista.adicionaNoInicio("Victor");
        lista.adicionaNoInicio("Diego");
        lista.adicionaNoFinal("Rebeca");

        lista.mostraElementos();
        System.out.println(lista.procuraElemento(0).getElemento());
    }
}
