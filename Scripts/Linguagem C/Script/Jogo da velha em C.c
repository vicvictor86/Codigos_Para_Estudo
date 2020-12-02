#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

int main(void) {

	//Declara��o de vari�veis, setando o locale e colocando prot�tipos
  	int jogadas = 1, posix = 0, posiy = 0;
  	char xeo[3][3] = {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
	void desenho();
	int vaiganhar();
	setlocale(LC_ALL, "Portuguese");

  printf("-------*Bem vindo ao jogo da velha em C*---------\n");

  while(jogadas <= 10){
		
		if(jogadas == 10){
			printf("O jogo deu velha, ningu�m ganhou!!!!\n");
			break;
		}

		//Rodada do jogador 2
    	if(jogadas % 2 == 0){
      		printf("Rodada do jogador 2\n");
			printf("Digite a posicao: X e Y:\n");

			printf("X: ");
  			scanf("%d", &posix);

			printf("Y: ");
			scanf("%d", &posiy);

			//Testa se a posi��o � menor que 3 e se o elemento do vetor � menor que 3
			if(posix < 3 && posiy < 3 && xeo[posix][posiy] == ' '){

				xeo[posix][posiy] = 'O';
				desenho(xeo);

			if(vaiganhar(xeo)){
				printf("O jogador 2 ganhou Parab�ns!!!!!\n");
				printf("========================================\n");
				break;
			}
			jogadas++;

		}
		else{
			printf("A posi��o digitada � inv�lida, tente novamente.\n");
			printf("=================================================\n");
		}
			
    }
		//Rodada do jogador 1
		else{

			printf("Rodada do jogador 1\n");
			printf("Digite a posi��o: X e Y:\n");

			printf("X: ");
  			scanf("%d", &posix);

			printf("Y: ");
			scanf("%d", &posiy);
			
			//Testa se a posi��o � menor que 3 e se o elemento do vetor � menor que 3
			if(posix < 3 && posiy < 3 && xeo[posix][posiy] == ' '){

				xeo[posix][posiy] = 'X';
				desenho(xeo);

				if(vaiganhar(xeo)){
					printf("O jogador 1 ganhou Parab�ns!!!!!\n");
					printf("========================================\n");
					break;
				}

				jogadas++;

			}
			else{
				printf("A posi��o digitada � inv�lida, tente novamente.\n");
				printf("=================================================\n");
			}
			
		}

  }

	printf("Fim do jogo.");
    return 0;
}

//Desenho do tabuleiro
void desenho(char lista[3][3]){
	printf("===================\n");
	printf("   0      1      2\n\n");
	printf("   %c  |   %c   |  %c  \n", lista[0][0], lista[0][1], lista[0][2]);
	printf("0     |       |      \n");
	printf(" -----|-------|-----\n");
	printf("1  %c  |   %c   |  %c   \n", lista[1][0], lista[1][1], lista[1][2]);
	printf("      |       |      \n");
	printf(" -----|-------|-----\n");
	printf("2  %c  |   %c   |  %c \n", lista[2][0], lista[2][1], lista[2][2]);
	printf("      |       |      \n");
	printf("===================\n");
}

//Teste se o jogador vai ganhar a partida
int vaiganhar(char lista[3][3]){

	int k = 0, j = 0;

	//An�lises das horizontais
	for(k = 0; k < 3; k++){
		if(lista[k][j] == lista[k][j+1] && lista[k][j] == lista[k][j+2] && lista[k][j+1] == lista[k][j+2] && lista[k][j] != ' ' && lista[k][j+1] != ' ' && lista[k][j+2] != ' '){
			return 1;
		}
	}

	//An�lises das verticais
	k = 0;
	for(j = 0; j < 3; j++){
	if(lista[k][j] == lista[k+1][j] && lista[k][j] == lista[k+2][j] && lista[k+1][j] == lista[k+2][j] && lista[k][j] != ' ' && lista[k+1][j] != ' ' && lista[k+2][j] != ' '){
			return 1;
		}
	}

	//An�lise das diagonais
	if(lista[0][0] == lista[1][1] & lista[1][1] == lista[2][2] && lista[0][0] == lista[2][2] && lista[0][0] != ' ' && lista[1][1] != ' ' && lista[2][2] != ' '){
		return 1;
	}
	else if(lista[2][0] == lista[1][1] & lista[2][0] == lista[0][2] && lista[1][1] == lista[0][2] && lista[2][0] != ' ' && lista[1][1] != ' ' && lista[0][2] != ' '){
		return 1;
	}

	//Caso nenhum game seja feito
	else{
		return 0;
	}

}