#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define TAMANHO 8

//Ordenação crescente
int estaordenado(int *vetor, int tamanho)
{
	//A decrementação antes da variável foi colocada a fim de não utilizarmos o valor máximo do tamanho
    //Pois dessa forma ao entrarmos no if iriamos comparar uma posição no vetor que não existe
    while (tamanho > 1)
    {
        tamanho--;
        if (vetor[tamanho] < vetor[tamanho - 1])
        {
        	//Retorna zero se algum elemento posterior for maior que um anterior
            return 0;
        }
    }
	//Retorna um se os elementos estiverem ordenados
    return 1;

}

float embaralhar(int *vetor, int tamanho)
{
    int i = 0, auxiliar = 0, posicaorandomica = 0;
    float quantidadedeloopings = 0;
    
	//Troca os elementos do vetor de posição (quantidade de loopings contabilizada)
    for(i = 0; i < tamanho; i++)
    {
        
        auxiliar = vetor[i];
        //Limita os números que posicaorandomica recebe de 0 a tamanho - 1 
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
	
	//Repete o algoritmo se o vetor não estiver ordenado
    while (!estaordenado(vetor, tamanho))
    {
        quantidadedeloopings += embaralhar(vetor, tamanho);
    }

    return quantidadedeloopings;

}

int main()
{

    int i, numeros[] = { 1, 10, 9,  7, 3, 0, 2, 4 };
    float quantidadedeloopings = 0;
	clock_t inicio, fim;
	
    //Marca o início da quantidade de ticks da cpu
	inicio = clock();
	
    quantidadedeloopings = bogosort(numeros, TAMANHO);
    
    //Marca o fim da quantidade de ticks da cpu
    fim = clock();
    
    for (i=0; i < TAMANHO; i++)
    {
        printf("%d ", numeros[i]);
    }
    
    printf("\nQuantidade de loopings feitos: %.f, tempo de execucao: %.3lf)",
	quantidadedeloopings, (double)(fim - inicio) / CLOCKS_PER_SEC);
    //Diferenças da quantidade de ticks após o fim da execução da função
    //dividido pela quantidade de ticks da cpu por segundo do windows

    printf("\n");

    return 0;

}