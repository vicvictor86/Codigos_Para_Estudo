package JogoDaVelha;

import java.util.Scanner;

public class JogoDaVelha {
    
    //Jogador1 joga nas rodadas Pares enquanto Jogador2 rodadas Impares
    public static void main(String[] args){

        Scanner teclado = new Scanner(System.in);
        DesenhoVelha desenhoVelha = new DesenhoVelha();

        String[][] escolhas = new String[3][3];
        desenhoVelha.LimparMatriz(escolhas);

        Integer rodadaAtual = 0;
        Boolean ganhou = false;
        
        while(rodadaAtual < 9 && !ganhou){

            desenhoVelha.VerificarQualJogador(rodadaAtual);

            System.out.println("Digite a posição X:");
            Integer escolhaX = teclado.nextInt();

            System.out.println("Digite a posição Y:");
            Integer escolhaY = teclado.nextInt();

            rodadaAtual = desenhoVelha.EscolhaDoPersonagem(escolhas, escolhaX, escolhaY, rodadaAtual);
            desenhoVelha.DesenharNaTela(escolhas);

            ganhou = desenhoVelha.VerificarSeGanhou(escolhas, rodadaAtual);

        }
        
        teclado.close();
        
    }

}
