import java.util.Scanner;

public class PedeNumero {
    
    public static void main(String[] args) {
        
        System.out.print("Digite um número: ");
        Scanner numero = new Scanner(System.in);
        
        Integer armazena = numero.nextInt();
        System.out.println("O numero escolhido foi " + armazena);
        numero.close();
        
    }

}