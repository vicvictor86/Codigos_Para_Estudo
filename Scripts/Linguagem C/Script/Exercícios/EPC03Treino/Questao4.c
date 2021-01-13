#include <stdio.h>

void verificaprimo(int numero)
{

    int i = 2;
    while (i < numero)
    {
        if(numero % i == 0)
        {
            printf("O numero %d nao e primo, pois ele e divisivel por %d", numero, i);
            return;
        }
        i++;
    }
    
    printf("O numero %d e primo", numero);

}

int main()
{

    int numero = 0;

    printf("Digite um numero: ");
    scanf("%d", &numero);

    verificaprimo(numero);

    return 0;

}