package Estruturas_De_Repeticao;
import java.util.Scanner;

public class DuasPopulacao {
    
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite a população A: ");
        Double populacaoA = teclado.nextDouble();
        System.out.println("Digite a popupação B: ");
        Double populacaoB = teclado.nextDouble();

        System.out.println("Digite a porcentagem de crescimento da população A: ");
        Double porcentagemA = teclado.nextDouble();
        System.out.println("Digite a porcentagem de crescimento da população B: ");
        Double porcentagemB = teclado.nextDouble();
        
        if(porcentagemA > porcentagemB && populacaoA > populacaoB){
            teclado.close();
            throw new MinhaExcessao("B nunca ultrapassará A");
        }

        else if(porcentagemB > porcentagemA && populacaoB > populacaoA){
            teclado.close();
            throw new MinhaExcessao("A nunca ultrapassará B");
        }

        int anos = 0;
        int comparacao = populacaoA.compareTo(populacaoB);
        
        if(comparacao < 0){

            while(populacaoA < populacaoB){

                populacaoA = populacaoA + populacaoA * porcentagemA;
                populacaoB = populacaoB + populacaoB * porcentagemB;
                anos++;
    
            }

        }
        
        else if (comparacao > 0){

            while(populacaoB < populacaoA){

                populacaoA = populacaoA + populacaoA * porcentagemA;
                populacaoB = populacaoB + populacaoB * porcentagemB;
                anos++;
    
            }

        }
        
        System.out.println("Demorou " + anos + " anos para a população A atingir " + populacaoA + " de pessoas e a B atingir " + populacaoB);
        teclado.close();

    }

    

}