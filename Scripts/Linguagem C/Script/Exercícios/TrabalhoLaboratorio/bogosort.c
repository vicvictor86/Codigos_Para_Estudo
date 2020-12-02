#include <stdio.h>
#include <stdlib.h>
#include <time.h>

//Ordenação crescente
int estaordenado(int *vetor, int tamanho)
{
    
    //A decrementação antes da variável foi colocada a fim de não utilizarmos o valor máximo do tamanho
    //Pois dessa forma ao entrarmos no if iriamos comparar uma posição no vetor que não existe
    while (--tamanho >= 1) 
    {
        //Se o número da direita for menor que o da esquerda
        if (vetor[tamanho] < vetor[tamanho-1]) 
        {
            //Não está ordenado
            return 0;
        }
    }

    return 1;

}
 
float embaralhar(int *vetor, int tamanho)
{

    int i = 0, auxiliar = 0, posicaorandomica = 0;
    float quantidadedeloopings = 0;

    for(i = 0; i < tamanho; i++)
    {
        
        auxiliar = vetor[i];
        //Vai fazer com que a variável posicaorandomica só possa receber numeros de 0 a tamanho - 1 
        posicaorandomica = rand() % tamanho;

        vetor[i] = vetor[posicaorandomica];
        vetor[posicaorandomica] = auxiliar;

        quantidadedeloopings++;

    }

    return quantidadedeloopings;

}
 
float bogosort(int *vetor, int tamanho)
{

    float quantidadedeloopings = 0;
    srand(time(NULL));

    while (!estaordenado(vetor, tamanho)) 
    {
        quantidadedeloopings += embaralhar(vetor, tamanho);
    }

    return quantidadedeloopings;

}
 
int main()
{

    int numeros[] = {1, 10, 9, 7, 3, 0};

    int i = 0;
    float quantidadedeloopings = 0;
    
    quantidadedeloopings = bogosort(numeros, 6);
    
    for (i=0; i < 6; i++) 
    {
        printf("%d ", numeros[i]);
    }

    printf("\nQuantidade de loopings feitos: %.f", quantidadedeloopings);
    
    return 0;

}