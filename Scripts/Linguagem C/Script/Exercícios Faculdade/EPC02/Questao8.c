#include <stdio.h>
#include <math.h>

void calc_hexa(float l, float *area, float *perimetro)
{
    *area = (3 * pow(l, 2) * sqrt(3)) / 2.0;
    *perimetro = 6 * l;
}

void mostra_hexa(float *area, float *perimetro)
{
    printf("\nA area do hexagono e: %.2f\n", *area);
    printf("O perimetro do hexagono e: %.2f\n\n", *perimetro);
}

int main()
{   

    //Loop Infinito
    while (1)
    {
        float l, area, perimetro;

        printf("Digite o lado do hexagono[negativo para sair]: ");
        scanf("%f", &l);

        if(l < 0)
        {
            printf("\nSaindo do programa\n");
            break;
        }

        calc_hexa(l, &area, &perimetro);
        mostra_hexa(&area, &perimetro);

    }

    return 0;

}