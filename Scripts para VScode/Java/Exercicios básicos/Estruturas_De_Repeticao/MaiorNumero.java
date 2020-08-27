package Estruturas_De_Repeticao;

import java.util.ArrayList;
import java.util.Scanner;

public class MaiorNumero {
    
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        ArrayList<Integer> numeros = new ArrayList<Integer>();
        boolean primeiro = true;

        int maior = 0;
        int menor = 0;

        for(int i = 0; i <= 3; i++){

            System.out.println("Escolha o número " + (i + 1) + ": " );
            numeros.add(teclado.nextInt());
            
            if(primeiro){
                maior = numeros.get(0);
                menor = numeros.get(0);
                primeiro = false; 
            }
            else if(numeros.get(i) > maior){
                maior = numeros.get(i);
            }
            else if(numeros.get(i) < menor){
                menor = numeros.get(i);
            }

        }

        teclado.close();
        System.out.println("O maior número é: " + maior + " e o menor número é: " + menor);

    }
}