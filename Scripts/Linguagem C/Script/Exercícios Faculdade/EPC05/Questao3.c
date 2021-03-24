#include <stdio.h>
#include <stdlib.h>

float* calcularaiz(float* raizes, float a, float b, float c) 
{
    float delta;
    delta = (b * b) - (4*a*c);

    if (delta == 0)
    {
        raizes = (float *) calloc(1, sizeof(float));
        raizes[0] = -b / (2*a);
    }
    else if(delta > 0)
    {
        raizes = (float *) calloc(2, sizeof(float));
        raizes[0] = (-b + sqrt(delta)) / (2 * a); 
        raizes[1] = (-b - sqrt(delta)) / (2 * a); 
    }
    else
    {
        //Delta menor que 0 não admite solução real
        raizes = NULL;
    }

    return raizes;
}

int main()
{
    float *raizes, a = 0, b = 0, c = 0, delta = 0;
    int i = 0;

    printf("Digite o coeficiente a: ");
    scanf("%f", &a);

    printf("Digite o coeficiente b: ");
    scanf("%f", &b);

    printf("Digite o coeficiente c: ");
    scanf("%f", &c);

    raizes = calcularaiz(raizes, a, b, c);
    if (raizes != NULL)
    {
        for (i = 0; i < 2; i++)
        {
            printf("%d Raiz: %.2f\n",i + 1, raizes[i]);
        }
    }
    else
    {
        printf("O delta deu menor que 0, logo nao existem raizes reias");
    }
    
    free(raizes);
    return 0;
}