#include <stdio.h>
int main() 
{
    int anteriores[10], atual = 0, i = 0, ehigual = 0;
    int jadigitado(int[], int);
    
    for (int i = 0; i < 10; i++)
    {
        printf("Digite o %d numero ", i+1);
        scanf("%d", &anteriores[i]);
    }
    
    printf("Digite o numero que sera comparado: ");
    scanf("%d", &atual);

    ehigual = jadigitado(anteriores, atual);

    ehigual ? printf("Ja digitado anterioremente") : printf("Nao digitado antes");

    return 0;
}

int jadigitado(int anteriores[10], int atual)
{
    int i = 0;
    for(i = 0; i < 10; i++)
    {
        if(anteriores[i] == atual)
        {
            return 1;
        }
    }
    return 0;
}