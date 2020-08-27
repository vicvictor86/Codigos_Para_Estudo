package Estruturas_De_Repeticao;
import java.util.ArrayList;
import java.util.Scanner;

public class NotasBimestrais {
    public static void main(String[] args) {

        int quantNotas = 0;
        double total = 0.0;
        Scanner notas = new Scanner(System.in);
        ArrayList<Integer> notaAlone = new ArrayList<Integer>();
        while(quantNotas < 4){

            quantNotas++;
            notaAlone.add(notas.nextInt());

        }

        for(Integer numero : notaAlone){

            total += numero;
        
        }
        System.out.println("A média é: " + total / 4);

        notas.close();
    }
}