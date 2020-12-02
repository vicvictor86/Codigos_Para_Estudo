import java.util.Scanner;

public class AreaQuadrado {
    public static void main(String[] args) {
    
    System.out.println("Digite um lado do quadrado");
    Scanner teclado = new Scanner(System.in);
    Double lado = teclado.nextDouble();

    Double area = lado * lado;
    System.out.println("O dobro da area é: " + area * 2);
    
    teclado.close();
    }
    

}