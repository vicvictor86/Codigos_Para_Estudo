package listaEncadeadeSimplesCircular;

public class TestaListaEncadeadaSimplesCircular {

    public static void main(String[] args) {
        ListaEncadeadaSimplesCircular lista = new ListaEncadeadaSimplesCircular();

        lista.adicionaNoInicio("Carlos");
        lista.adicionaNoInicio("Victor");
        lista.adicionaNoInicio("Diego");
        lista.adicionaNoFinal("Rebeca");
        lista.adicionaNoInicio("Kassandra");

        lista.mostraElementos();
        System.out.println(lista.procuraElemento(4).getProximo().getElemento());
    }
}
