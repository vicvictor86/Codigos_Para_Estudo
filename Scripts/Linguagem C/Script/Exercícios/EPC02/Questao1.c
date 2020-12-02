#include <stdio.h>
#define LINHAS 5
#define COLUNAS 2
#define TAMANHOVETOR 10

int main()
{

    int matriz[5][2] ={{0, 1}, {2, 3}, {4, 5}, {6, 7}, {8, 9}}, posicao = 0, vetor[TAMANHOVETOR];

    //Passagem dos valores da matriz pro vetor
    for (int i = 0; i < LINHAS; i++)
    {

        for (int j = 0; j < COLUNAS; j++)
        {   
            vetor[posicao] = matriz[i][j];
            posicao++;
        }
        
    }
    
    for (int i = 0; i < TAMANHOVETOR; i++)
    {   
        printf("%d ", vetor[i]);
    }

    return 0;

}