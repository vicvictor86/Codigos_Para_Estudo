#include <stdio.h>
#define TAMANHOVETOR 9
#define TAMANHOVETORPAR 4

int main()
{

    int vetor[] = {9, 5, 2, 7, 3, 8, 1, 4, 6};
    int novovetor[TAMANHOVETORPAR], max = 0;

    //Pega o vetor e só atribui no novo vetor os números pares
    for (int i = 0, posicao = 0; i < TAMANHOVETOR; i++)
    {
        if(vetor[i] % 2 == 0)
        {   
            novovetor[posicao] = vetor[i];
            posicao++;
        }
    }

    //Ordenação decrescente com Selection Sort
    for (int i = 0; i < TAMANHOVETORPAR; i++)
    {

        max = i;
        for (int j = i + 1; j < TAMANHOVETORPAR; j++)
        {
            if (novovetor[j] > novovetor[max])
            {
                max = j;
            }
        }

        int aux = novovetor[i];
        novovetor[i] = novovetor[max];
        novovetor[max] = aux;
        
    }

    for (int i = 0; i < TAMANHOVETORPAR; i++)
    {
        printf("%d ", novovetor[i]);
    }

    return 0;

}