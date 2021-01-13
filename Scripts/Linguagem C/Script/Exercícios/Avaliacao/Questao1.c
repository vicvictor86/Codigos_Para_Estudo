#include <stdio.h>
int main()
{
    int continuar = 1, numero = 0;

    while (continuar != 0) 
    {
        printf("Digite um numero: ");
        scanf("%d", &numero);

        if(numero % 2 == 0)
        {
            printf("Numero par\n");
        }
        else
        {
            printf("Numero impar\n");
        }

        printf("Quer digitar outro numero ?[0 para nao]");
        scanf("%d", &continuar);
        
    }

    return 0;
}