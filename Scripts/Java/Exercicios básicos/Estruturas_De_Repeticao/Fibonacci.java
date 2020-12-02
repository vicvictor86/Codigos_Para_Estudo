import java.util.Scanner;

public class Fibonacci {
    
    public static void main(String[] args) {
        
        System.out.println("Digite quantos números vc quer da sequência de fibonacci");
        Scanner teclado = new Scanner(System.in);
        int quantidade = teclado.nextInt();
        System.out.print("0,");
        int anterior = 0;
        int atual = 1;
        for(int i = 1; i <= quantidade; i++){

            int posterior = anterior + atual;
            anterior = atual;
            System.out.print(atual + ",");
            atual = posterior; 

        }

        teclado.close();

    }

}