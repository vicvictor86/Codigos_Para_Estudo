#include <stdio.h>
#define TAMANHOVETOR 9

//Usar selection sort
int main()
{

    int vetor[] = {9, 5, 2, 7, 3, 8, 1, 4, 6};
    int quant = 0, min;

    //Ordenação crescente com Selection sort 
    for (int i = 0; i < TAMANHOVETOR; i++)
    {

        min = i;
        for (int j = i + 1; j < TAMANHOVETOR; j++)
        {
            if (vetor[j] < vetor[min])
            {
                min = j;
            }
        }

        int aux = vetor[i];
        vetor[i] = vetor[min];
        vetor[min] = aux;
        
    }
    
    for (int i = 0; i < TAMANHOVETOR; i++)
    {
        printf("%d ", vetor[i]);
    }

    return 0;

}