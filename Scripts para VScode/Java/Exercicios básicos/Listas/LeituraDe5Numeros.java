package Listas;

import java.util.ArrayList;
import java.util.Collections;

public class LeituraDe5Numeros{

    public static void main(String[] args) {
        
        ArrayList<Integer> numeros = new ArrayList<Integer>();

        numeros.add(5);
        numeros.add(10);
        numeros.add(2);
        numeros.add(15);
        numeros.add(78);
        numeros.sort(Collections.reverseOrder());
        
        for(int i = 0; i < 5; i++){

            System.out.println("Numero " + (i + 1) + ": " + numeros.get(i));

        }

    }

}