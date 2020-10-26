import java.util.ArrayList;

public class EncontraConsoante {
    
    public static void main(String[] args) {
        
        Integer quantidadeDeConsoantes = 0;
        ArrayList<String> palavra = new ArrayList<String>();
        palavra.add("Dez caract");

        for (int i = 1; i < palavra.get(0).length(); i++) {

            String letra = palavra.get(0).substring((i-1), i);

            if( !(letra.equals("a")) && !(letra.equals("e")) && !(letra.equals("i")) && !(letra.equals("o")) && !(letra.equals("u")) && !(letra.equals(" ")) ){

                System.out.println("As consoantes são: " + letra);
                quantidadeDeConsoantes++;
                
            }
            
        }
        
        System.out.println("Totalizando: " + quantidadeDeConsoantes + " consoantes.");

    }

}