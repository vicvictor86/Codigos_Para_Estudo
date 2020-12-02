#include <stdio.h>
#define NUMEROS 10

int main(){

    int quantidadepares = 0, somaimpares = 0;

    for (int i = 1; i <= NUMEROS; i++)
    {
        
        int numero;
        printf("Digite o %d numero ", i);
        scanf("%d", &numero);

        if(numero % 2 == 0)
        {
            quantidadepares++;
        }
        else if(numero != 0)
        {
            somaimpares += numero;
        }

    }

    printf("A soma dos numeros impares e %d\n", somaimpares);
    printf("A quantidade de numeros pares e %d\n", quantidadepares);
    
    return 0;

}