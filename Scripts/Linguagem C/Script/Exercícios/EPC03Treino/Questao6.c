#include <stdio.h>

void inverternumero(int numero)
{

    int inv = 0;

    while (numero > 0)
    {
        inv = 10 * inv + numero % 10;
        numero /= 10;
    }
    
    printf("O numero invertido e %d", inv);
}

int main()
{

    int numero;
    printf("Digite um numero: ");
    scanf("%d", &numero);

    inverternumero(numero);

    return 0;

}