package HashTable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Leitor {


    public ArrayList<String> reader(int n) throws IOException {

        ArrayList<String> palavras = new ArrayList<String>();

        InputStream is = getClass().getClassLoader().getResourceAsStream("taleModificado.txt");
        try (InputStreamReader streamReader = new InputStreamReader(is, StandardCharsets.UTF_8);
             BufferedReader in = new BufferedReader(streamReader)) {

            String linha;
            int i = 0;

            while ((linha = in.readLine()) != null && i < n) {

                linha = linha.replaceAll("\\.", "");
                linha = linha.replaceAll("\\,", "");
                linha = linha.replaceAll("!", "");
                linha = linha.replaceAll("\\?", "");
                linha = linha.replaceAll("\"", "");
                linha = linha.replaceAll("-", "");
                linha = linha.replaceAll("\\;", "");
                linha = linha.replaceAll("\\)", "");
                linha = linha.replaceAll("\\(", "");
                linha = linha.replaceAll("\\_", "");
                linha = linha.replaceAll("\\:", "");

                String[] aux = linha.split(" ");
                for(int j = 0; j<aux.length;j++) {

                    palavras.add(aux[j]);
                }
                i++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return palavras;
    }

}