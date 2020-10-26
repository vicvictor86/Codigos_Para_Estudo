import java.util.ArrayList;
import java.util.Scanner;

public class SomaMedia {
    
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        ArrayList<Integer> numeros = new ArrayList<Integer>();
        int soma = 0;
        
        for(int i = 0; i <=2; i++){

            System.out.println("Digite o número " + (i + 1) + ": " );
            numeros.add(teclado.nextInt());

            soma += numeros.get(i);

        }
        
        teclado.close();
        System.out.println("A soma dos números é: " + soma + " e a média: " + ((double)soma / 3));

    }

}