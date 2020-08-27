package Estruturas_De_Repeticao;
import java.util.Scanner;

public class Potencia{

    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);

        System.out.println("Digite a base do número: ");
        int base = teclado.nextInt();

        System.out.println("Digite o expoente do número: ");
        int expoente = teclado.nextInt();

        int potencia = base;

        for(int i = 1; i < expoente; i++){

            potencia *= base;

        }
        System.out.printf("%d elevado a %d é igual a %d", base, expoente, potencia);
        teclado.close();
    }

}