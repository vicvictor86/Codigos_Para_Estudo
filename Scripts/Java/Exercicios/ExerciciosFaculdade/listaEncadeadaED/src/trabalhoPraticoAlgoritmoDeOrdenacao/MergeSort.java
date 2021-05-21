package trabalhoPraticoAlgoritmoDeOrdenacao;

public class MergeSort<Tipo extends Comparable<Tipo>> {

    public void ordena(Tipo[] array, int indiceInicio, int indiceFim) {

        if (array != null && indiceInicio < indiceFim && indiceInicio >= 0 && indiceFim < array.length && array.length != 0) {
            int meio = ((indiceFim + indiceInicio) / 2);

            ordena(array, indiceInicio, meio);
            ordena(array, meio + 1, indiceFim);

            merge(array, indiceInicio, meio, indiceFim);
        }
    }

    public void merge(Tipo[] array, int indiceInicio, int meio, int indiceFim) {

        Tipo[] auxiliar = (Tipo[]) new Comparable[array.length];
        for (int i = indiceInicio; i <= indiceFim; i++) {
            auxiliar[i] = array[i];
        }

        int i = indiceInicio;
        int j = meio + 1;
        int k = indiceInicio;

        while (i <= meio && j <= indiceFim) {
            if (auxiliar[i].compareTo(auxiliar[j]) < 0) {
                array[k] = auxiliar[i];
                i++;
            } else {
                array[k] = auxiliar[j];
                j++;
            }
            k++;
        }

        while (i <= meio) {
            array[k] = auxiliar[i];
            i++;
            k++;
        }

        while (j <= indiceFim) {
            array[k] = auxiliar[j];
            j++;
            k++;
        }
    }
}
