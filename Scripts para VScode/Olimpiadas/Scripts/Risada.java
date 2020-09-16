import java.util.Scanner;

class Risada{

    public static void main(String[] args) {
    
        Scanner teclado = new Scanner(System.in);
        String risada = teclado.nextLine();
        String vogais = "";
        
        for(int i = 0; i < risada.length(); i++){

            char letra = risada.charAt(i);
            if(letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u'){
                vogais += letra;
            }

        }
        
        String palindromo = new StringBuilder(vogais).reverse().toString();
        
        if(palindromo.equals(vogais)){
            System.out.println("S");
        }
        else{
            System.out.println("N");
        }

        teclado.close();

    }

}