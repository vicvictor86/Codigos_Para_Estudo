package listaEncadeadaDuplaCircular;

public class TestaListaEncadeadaDuplaCircular {

    public static void main(String[] args) {
        ListaEncadeadaDuplaCircular lista = new ListaEncadeadaDuplaCircular();

        lista.adicionaNoInicio("Carlos");
        lista.adicionaNoInicio("Victor");
        lista.adicionaNoInicio("Diego");
        lista.adicionaNoFinal("Rebeca");
        lista.adicionaNoInicio("Kassandra");
        lista.adicionaNoFinal("Alessia");

        lista.mostraElementos();

        //Testa posição do primeiro e ultimo elemento
        System.out.println(lista.procuraElementoPosicao(0).getAnterior().getElemento());
        System.out.println(lista.procuraElementoPosicao(5).getProximo().getElemento());

        System.out.println(lista.procuraElemento("DAd"));
    }
}
