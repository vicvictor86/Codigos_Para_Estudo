import java.util.Scanner;

public class NumerosParesImpares{

    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        int par = 0;
        int impar = 0;
        for(int i = 1; i <= 3; i++){

            System.out.println("Digite o número "+ i + ":");
            int numero = teclado.nextInt();
            if(numero % 2 == 0){
                par++;
            }
            else if(numero % 2 != 0){
                impar++;
            }

        }

        teclado.close();
        System.out.println("Dos 3 numeros que vc pediu: " + par + " são pares e " + impar + " ímpares");
        
    }

}