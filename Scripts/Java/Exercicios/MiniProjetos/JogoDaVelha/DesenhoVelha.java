package JogoDaVelha;

public class DesenhoVelha {
    
    public void LimparMatriz(String[][] escolhas){
        
        for(int i = 0; i < 3; i++){

            for(int j = 0; j < 3; j++){
                escolhas[i][j] = " ";
            }

        }

    }

    public void DesenharNaTela(String[][] escolhas){
        System.out.println();
        System.out.printf(" %s | %s | %s \n", escolhas[0][0],escolhas[0][1],escolhas[0][2]);
        System.out.printf("-----------   \n");
        System.out.printf(" %s | %s | %s \n", escolhas[1][0],escolhas[1][1],escolhas[1][2]);
        System.out.printf("-----------   \n");
        System.out.printf(" %s | %s | %s \n\n", escolhas[2][0],escolhas[2][1],escolhas[2][2]);
    }

    public void VerificarQualJogador(int rodadaAtual){

        if(rodadaAtual % 2 == 0){
            System.out.println("É a vez do jogador 1.\n");
        }else{
            System.out.println("É a vez do jogador 2.\n");
        }

    }

    public Integer EscolhaDoPersonagem(String[][] escolhas, int x, int y, Integer rodadaAtual){
        
        if(x > 2 || x < 0 || y > 2 || y < 0){
            System.out.println("\nUm dos valores é inválido, digite apenas de 0 a 2.");
            return rodadaAtual;
        }

        if(rodadaAtual % 2 == 0 && escolhas[x][y] == " "){

            escolhas[x][y] = "X";
            rodadaAtual++;

            return rodadaAtual;

        }else if (rodadaAtual % 2 != 0 && escolhas[x][y] == " "){
            escolhas[x][y] = "O";
            rodadaAtual++;

            return rodadaAtual;
        }else{
            System.out.println("\nA posição digitada já foi escolhida, tente novamente outra posição.");
            return rodadaAtual;
        }

    }
    
    public Boolean VerificarSeGanhou(String[][] escolhas, int rodadaAtual){

        //Análise da diagonal
        if(escolhas[0][0] == escolhas[1][1] && escolhas[0][0] == escolhas[2][2] && escolhas[1][1] == escolhas[2][2] 
           && escolhas[0][0] != " " && escolhas[1][1] != " " && escolhas[2][2] != " "
           || escolhas[2][0] == escolhas[1][1] && escolhas[2][0] == escolhas[0][2] && escolhas[1][1] == escolhas[0][2]
           && escolhas[2][0] != " " && escolhas[1][1] != " " && escolhas[0][2] != " "){
            if((rodadaAtual - 1) % 2 == 0){
                System.out.println("O jogador 1 venceu. Parabéns");
                return true;
            }else{
                System.out.println("O jogado 2 venceu. Parabéns");
                return true;
            }
        }

        //Análise da linha
        for(int i = 0; i < 3; i++){
            if(escolhas[i][0] == escolhas[i][1] && escolhas[i][0] == escolhas[i][2] && escolhas[i][1] == escolhas[i][2]
               && escolhas[i][0] != " " && escolhas[i][1] != " " && escolhas[i][2] != " " ){
                if((rodadaAtual - 1) % 2 == 0){
                    System.out.println("O jogador 1 venceu. Parabéns");
                    return true;
                }else{
                    System.out.println("O jogador 2 venceu. Parabéns");
                    return true;
                }
            }
        }

        //Análise vertical
        for(int j = 0; j < 3; j++){
            if(escolhas[0][j] == escolhas[1][j] && escolhas[0][j] == escolhas[2][j] && escolhas[1][j] == escolhas[2][j]
                && escolhas[0][j] != " " && escolhas[1][j] != " " && escolhas[2][j] != " "){
                if((rodadaAtual - 1) % 2 == 0){
                    System.out.println("O jogador 1 venceu. Parabéns");
                    return true;
                }
                else{
                    System.out.println("O jogador 2 venceu. Parabéns");
                    return true;
                }
            }
        }

        if(rodadaAtual == 9){
            System.out.println("Deu velha, ninguém ganhou");
            return true;
        }

        return false;
    }
}
