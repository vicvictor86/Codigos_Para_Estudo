package HashTable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Questao5 {

    public static void main(String[] args) throws IOException {

    	Scanner sc = new Scanner(System.in); 
    	SeparateChainingHashST<Character, Integer> st = new SeparateChainingHashST<Character, Integer>(5);
    	for(int i = 0; i < 10; i++) {
    		Character letra = sc.next().toUpperCase().charAt(0);
    		st.put(letra, i);	
    	}
    	
    	System.out.println("\n\n");
    	for (Character s : st.keys()) {
        	System.out.println(s + " " + st.getPos(s));
        }
    	sc.close();

        System.out.println("\n\nEND OF PROGRAM");
    }
    
}