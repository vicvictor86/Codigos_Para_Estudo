package trabalhoPraticoEstruturadeDados;

public class TestaFilaCP {
    public static void main(String[] args) {

        FilaCP<String> fila = new FilaCP<String>();

        fila.adicionar("Ana", false);
        fila.adicionar("Beto", false);
        fila.adicionar("Arnaldo Timoteo", true);
        fila.adicionar("Bartolomeu Carlos", true);
        fila.adicionar("Carlitu", false);

        fila.exibir();

        fila.atender();
        fila.atender();

        fila.exibir();

        System.out.println(fila.tamanhoP());
        fila.atender();

        fila.exibir();
    }
}
