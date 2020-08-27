package Estruturas_De_Repeticao;
import java.util.Scanner;

class Teste0a10 {

    public static void main(String[] args) {
        
        while(true){

            System.out.print("Digite um número de 0 a 10: ");
            Scanner teclado = new Scanner(System.in);
            Integer numero = teclado.nextInt();
            if(0 <= numero && numero <= 10){

                System.out.println("Número válido.");
                teclado.close();
                break;

            }
            System.out.println("Número invalido.");

            teclado.close();
        }
          

    }


}