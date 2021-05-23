package trabalhoPraticoAlgoritmoDeOrdenacao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class InputMergeSort {

    public String[] lerNomes(int quantidade) throws IOException {

        if(quantidade > 1033680){
            throw new IOException("Arquivo com dados insuficiente");
        }

        String path = "listaEncadeadaED/src/trabalhoPraticoAlgoritmoDeOrdenacao/nomes.txt";
        String[] nomes = new String[quantidade];
        BufferedReader buffRead = new BufferedReader(new FileReader(path));

        String linha;
        for (int i = 0; i < quantidade; i++) {
            linha = buffRead.readLine();
            if (linha != null) {
                nomes[i] = linha.toLowerCase(Locale.ROOT);
            } else {
                throw new IOException("Arquivo com dados insuficiente");
            }
        }

        return nomes;
    }

    public void mostraOrdenado(String[] nomes, long tempoDecorrido) {
        for (String nome : nomes) {
            System.out.println(nome);
        }

        System.out.println("Tempo corrido: " + tempoDecorrido + " milissegundos");
        System.out.println();
    }

    public long ordenaValores(String[] nomes){
        MergeSort<String> ordenador = new MergeSort<>();

        long tempoInicial = System.currentTimeMillis();
        ordenador.ordena(nomes, 0, nomes.length - 1);
        long tempoFinal = System.currentTimeMillis();

        return (tempoFinal - tempoInicial);
    }

    public static void main(String[] args) throws IOException {

        InputMergeSort app = new InputMergeSort();

        long tempoDecorrido = 0;
        String[] nomes;
        Scanner s = new Scanner(System.in);

        int op = -1;
        String menu = "Escolha a quantidade de dados que você quer ordenar:\n1 - 10.000 dados\n2 - 100.000 dados\n" +
                "3 - 500.000 dados\n4 - 1.000.000 de dados\n5 - A sua escolha\n0 - Sair\n";

        while (op != 0) {
            System.out.print(menu);
            op = Integer.parseInt(s.nextLine());
            System.out.println();
            switch (op) {
                case 1:
                    nomes = app.lerNomes(10000);
                    tempoDecorrido = app.ordenaValores(nomes);
                    app.mostraOrdenado(nomes, tempoDecorrido);
                    break;
                case 2:
                    nomes = app.lerNomes(100000);
                    tempoDecorrido = app.ordenaValores(nomes);
                    app.mostraOrdenado(nomes, tempoDecorrido);
                    break;
                case 3:
                    nomes = app.lerNomes(500000);
                    tempoDecorrido = app.ordenaValores(nomes);
                    app.mostraOrdenado(nomes, tempoDecorrido);
                    break;
                case 4:
                    nomes = app.lerNomes(1000000);
                    tempoDecorrido = app.ordenaValores(nomes);
                    app.mostraOrdenado(nomes, tempoDecorrido);
                    break;
                case 5:
                    int quantidade = Integer.parseInt(s.nextLine());
                    nomes = app.lerNomes(quantidade);
                    tempoDecorrido = app.ordenaValores(nomes);
                    app.mostraOrdenado(nomes, tempoDecorrido);
                    break;
                case 0:
                    break;
            }
            //Com 10.000: 123 milissegundos
            //Com 100.000: 3909 milissegundos
            //Com 500.000: 86196 milissegundos
            //Com 1.000.000: 343096 milissegundos
        }

        System.out.println("End of Program");
        s.close();
    }
}
