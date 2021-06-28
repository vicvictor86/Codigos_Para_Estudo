package tabelaDeSimbolo;

import java.util.Scanner;

public class TestaBinarySearch {
    public static void main(String[] args) {
        BinarySearchST<String, Integer> st = new BinarySearchST<String, Integer>();
        String[] letras = {"b", "e", "f", "g", "j", "m"};
        for (int i = 0; i < letras.length; i++) {
            st.put(letras[i], i);
        }
        for (String s : st.keys())
            System.out.println(s + " " + st.get(s));

        int op = -1;
        Scanner sc = new Scanner(System.in);
        String menu = "1 - piso (floor) de uma chave menor que a chave mínima\n2 - teto (ceiling) de uma chave maior que a chave máxima\n" +
                "3 - keys(min, max) considera um intervalo aberto ou fechado\n4 - valores das chaves de um determinado intervalo\n" +
                "5 - valor retornado pelo método rank(), ao passar uma chave não existente  como argumento";

        while (op != 0) {
            System.out.print(menu);
            op = Integer.parseInt(sc.nextLine());
            System.out.println();
            switch (op) {
                case 1:
                    System.out.println(st.floor("a"));
                    break;
                case 2:
                    System.out.println(st.ceiling("n"));
                    break;
                case 3:
                    System.out.println(st.keys("e", "j"));
                    break;
                case 4:
                    for (String s : st.keys("e", "j"))
                        System.out.println(s + " " + st.get(s));
                    break;
                case 5:
                    System.out.print("Chave inexistente menor: ");
                    System.out.println(st.rank("a"));

                    System.out.print("Chave inexistente maior: ");
                    System.out.println(st.rank("z"));
                    break;
                case 0:
                    break;
            }
        }
    }
}
