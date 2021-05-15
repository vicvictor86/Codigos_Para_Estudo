package conjunto;

import java.util.HashSet;
import java.util.Set;

public class TesteConjunto {

    public static void main(String[] args) {
        Conjunto conjunto = new Conjunto();
        conjunto.adicionar("Mauricio");
        System.out.println(conjunto);

        conjunto.adicionar("Mauricio");
        System.out.println(conjunto);

        conjunto.adicionar("Marcelo");
        conjunto.adicionar("Guilherme");
        System.out.println(conjunto);

        conjunto.remove("Mauricio");
        System.out.println(conjunto);

        Set<String> conjuntoDoJava = new HashSet<String>();

        String x = "Guilherme";
        System.out.println(x.hashCode());
    }
}
