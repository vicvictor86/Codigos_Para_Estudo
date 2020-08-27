package Estruturas_De_Repeticao;
import java.util.Scanner;

public class EntreNumeros {
    
    public static void main(String[] args) {

        int soma = 0;
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("Digite o primeiro número:");
        int primeiroNumero = teclado.nextInt();

        System.out.println("Digite o segundo número:");
        int segundoNumero = teclado.nextInt();
        System.out.println("==============================");
        for(int i = primeiroNumero + 1; i < segundoNumero; i++){

            
            System.out.println(i);
            soma += i;

        }
        System.out.println("==============================");
        System.out.println("A soma dos números é: " + soma);
        teclado.close();

    }

}