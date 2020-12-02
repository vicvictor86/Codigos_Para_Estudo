#include <stdio.h>
#include <stdlib.h>
#define TAMANHO 3

int maxnumero(int num[])
{
    //Recebe o primeiro valor
    int nummax = num[0];
    int i;

    //Só chega até 2 posições a menos que o vetor
    for (i = 0; i < TAMANHO - 1; i++)
    {
        //Compara até a posição máxima do vetor
        if (num[i + 1] > nummax)
        {
            nummax = num[i + 1];
        }
    }
    
    return nummax;

}

int main()
{

    int num[TAMANHO], maiornumero = 0, i;

    for(i = 0; i < TAMANHO; i++)
    {
        printf("Digite o numero %d: ", i + 1);
        scanf("%d", &num[i]);
    }
    
    maiornumero = maxnumero(num);

    printf("O maior numero e: %d\n", maiornumero);

    system("PAUSE");

    return 0;

}