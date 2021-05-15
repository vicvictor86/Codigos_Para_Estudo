package bag;

import java.util.Scanner;

public class TestaLinkedBag {

    public static void main(String[] args) {

        LinkedBag<String> lista = new LinkedBag<String>();
        String nome;
        Scanner s = new Scanner(System.in);
        int op = -1;
        String menu = "\nMENU:\n1 - Inserir um nome\n"
                + "2 - Tamanho da bag\n3 - Listar todos os nomes\n4 - Sair";

        while (op != 0) {
            System.out.println(menu);
            op = Integer.parseInt(s.nextLine());
            switch (op) {
                case 1:
                    System.out.print("Digite o nome: ");
                    nome = s.nextLine();
                    lista.add(nome);
                    break;
                case 2:
                    System.out.println("Tamanho da bag: " + lista.size());
                    break;
                case 3:
                    for (String item : lista) {
                        System.out.println(item);
                    }
                    break;
                case 4:
                    System.out.println("\n\n---------------\nEND OF PROGRAM");
                    op = 0;
                default:
                    break;
            }
        }
        s.close();
    }
}
