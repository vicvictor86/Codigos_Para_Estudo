package Estrutura_Sequencial;

import java.util.Scanner;

public class RaioDoCirculo {
    
    public static void main(String[] args) {
        
        System.out.println("Digite um número");
        Scanner teclado = new Scanner(System.in);
        Double raio = teclado.nextDouble();
        Double area = 3.14 * raio * raio; 
        System.out.println(area);
        teclado.close();

    }

}