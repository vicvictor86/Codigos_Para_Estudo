#include <stdio.h>

void troca(float *a, float *b)
{
    float aux = *a;
    *a = *b;
    *b = aux;
}

int main()
{

    float a, b;

    printf("Digite o valor de a: ");
    scanf("%f", &a);

    printf("Digite o valor de b: ");
    scanf("%f", &b);

    printf("Antes da troca: valor de a = %.2f, valor de b = %.2f\n", a, b);

    troca(&a, &b);

    printf("Depois da troca: valor de a = %.2f, valor de b = %.2f\n", a, b);

    return 0;

}