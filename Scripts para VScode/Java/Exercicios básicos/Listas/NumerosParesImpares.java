package Listas;

import java.util.ArrayList;
//import java.util.Scanner;

public class NumerosParesImpares {
    
    public static void main(String[] args) {
        
        ArrayList<Integer> numeros = new ArrayList<Integer>();
        //ArrayList<Integer> pares = new ArrayList<Integer>();
       // ArrayList<Integer> impares = new ArrayList<Integer>();
        //Scanner teclado = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {

            //Integer numero = teclado.nextInt();
            //numeros.add(numero);

            //if(numero % 2 == 0){

              //  pares.add(numero);

            //}
            //else{
              //  impares.add(numero);
            //}

        }

        System.out.println("==========================");
        for (Integer integer : numeros) {

            System.out.println(integer);
            
        }
        System.out.println("==========================");

        
    }

}