package trabalhoPraticoAlgoritmoDeOrdenacao.comPrints;

import trabalhoPraticoAlgoritmoDeOrdenacao.MergeSort;

public class TestaMergeComPrints {

    public static void main(String[] args) {

        String[] array = {"M", "E", "R", "G", "E", "S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E",};

        MergeSort<String> lista = new MergeSort<>();

        lista.ordena(array, 0, array.length - 1);

        System.out.println();
        System.out.println("Array ordenado:");
        for (String letra :
                array) {
            System.out.print(letra);
        }

        System.out.println();



    }
}
