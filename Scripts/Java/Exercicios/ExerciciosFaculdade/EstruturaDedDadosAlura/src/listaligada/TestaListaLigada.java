package listaligada;

public class TestaListaLigada {

    public static void main(String[] args) {
        ListaLigada lista = new ListaLigada();

        lista.adicionaNoComeco("Mauricio");
        System.out.println(lista);

        lista.adicionaNoComeco("Guilherme");
        System.out.println(lista);

        lista.adiciona("Paulo");
        System.out.println(lista);

        lista.adiciona(2, "Cecília");
        System.out.println(lista);

        lista.contem("Paulo");
        lista.contem("Carlos");
    }
}
