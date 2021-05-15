package trabalhoEstruturaDeDados;

import java.io.IOException;

public class TestaLista {
    public static void main(String[] args) throws IOException {
        ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada();

        lista.inserirInicio("Carlos");
        lista.inserirInicio("Victor");
        //lista.listarNomes();
        lista.inserirInicio("Diego");
        //lista.listarNomes();
        lista.inserirFinal("Rebeca");
        lista.inserirInicio("Irelia");
        lista.inserirFinal("Santiago");
        lista.inserirFinal("Rebeca");
        lista.inserirFinal("Irelia");
        lista.listarNomes();
        //lista.excluir("Santiago");
        System.out.println();

        //lista.listarNomes();
    }
}
