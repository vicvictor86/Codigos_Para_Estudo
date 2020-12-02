#include <stdio.h>
#define TAMANHOVETOR 10

int main()
{

    int vetor[TAMANHOVETOR] = {9, 5, 2, 7, 3, 8, 1, 4}, soma = 0;

    for (int i = 0; i < TAMANHOVETOR; i++)
    {

        if(vetor[i] % 2 != 0)
        {
            soma += vetor[i];
        }

    }
    
    printf("Soma dos numeros impares: %d\n", soma);

    return 0;

}