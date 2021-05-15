package Fila;

public class TesteFila {

    public static void main(String[] args) {

        Fila fila = new Fila();

        fila.adicionar("Mauricio");
        fila.adicionar("Guilherme");

        System.out.println(fila);

        fila.remove();

        System.out.println(fila);

    }
}
