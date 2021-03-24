#include <stdio.h>
#include <stdlib.h>

int main()
{
    int **matriz, *vetor, i = 0, j = 0;

    //Criação da matriz
    matriz = (int **) calloc(3, sizeof(int *));
    for (i = 0; i < 3; i++)
    {
        matriz[i] = (int *) calloc(6, sizeof(int));
    }
    
    //Leitura da matriz
    for (i = 0; i < 3; i++)
    {
        for (j = 0; j < 6; j++)
        {
            printf("Digite a posicao [%d][%d]: ", i, j);
            scanf("%d", &matriz[i][j]);  
        }
    }

    //Preenchendo o vetor
    vetor = (int *) calloc(6, sizeof(int)); 
    for (j = 0; j < 6; j++)
    {
        for (i = 0; i < 3; i++)
        {
            vetor[j] += matriz[i][j];   
        }
        printf("%d ", vetor[j]);
    }

    for(i = 0; i < 3; i++)
    {
        free(matriz[i]);
    }
    free(vetor);
    free(matriz);
    return 0;
}