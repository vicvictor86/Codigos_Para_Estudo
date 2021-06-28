package HashTable;

import java.io.IOException;
import java.util.ArrayList;

public class Questao5 {

    public static void main(String[] args) throws IOException {

        SeparateChainingHashST<String, Integer> st = new SeparateChainingHashST<String, Integer>(97);
        Leitor l = new Leitor();
        int[] keyFrequency = new int[97];
        ArrayList<String> palavras = new ArrayList<String>();
        palavras = l.reader(16580);
        int i = 0;

        for (String s : palavras) {
            st.put(s, i);
            i++;
        }

        // print keys
        for (String s : st.keys()) {
            System.out.println(s + " " + st.getPos(s));
            keyFrequency[st.getPos(s)]++;
        }

        System.out.println("\n\n");
        for(i=0;i<keyFrequency.length;i++) {
            System.out.println("Posicao " + i +": \n"+ keyFrequency[i]);
        }


        System.out.println("\n\nEND OF PROGRAM");
    }
}