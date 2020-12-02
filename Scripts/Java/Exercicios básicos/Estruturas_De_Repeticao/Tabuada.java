import java.util.Scanner;

public class Tabuada {

    public static void main(String[] args) {
        
        int produto = 0;
        Scanner teclado = new Scanner(System.in);
        System.out.println("Você quer a tabuada de que número: ");
        int numero = teclado.nextInt();
        System.out.println("A tabuada do número " + numero + " é: ");
        
        for(int i = 1; i <=10; i++){

            produto = numero * i;
            System.out.printf("%d * %d = %d", numero, i, produto);
            System.out.println();
        }
        teclado.close();
    }
    
}