#include <stdio.h>
#define QUANTIDADENUMEROS 10

int main(){

    int positivos = 0, negativos = 0, nulos = 0;
    float totalpositivos = 0.0, totalnegativos = 0.0, medianegativos = 0.0;

    for (int i = 1; i <= QUANTIDADENUMEROS; i++)
    {
        
        float numero;
        printf("Digite o %d numero: ", i);
        scanf("%f", &numero);

        if(numero > 0)
        {
            positivos++;
            totalpositivos += numero;
        }
        else if(numero < 0)
        {
            negativos++;
            totalnegativos += numero;
        }
        else
        {
            nulos++;
        }

    }

    if(negativos != 0)
    {
        medianegativos = totalnegativos / negativos;
    }
    
    printf("Total positivos: %d\n", positivos);
    printf("Total negativos: %d\n", negativos);
    printf("Total nulos: %d\n", nulos);
    printf("Media dos negativos: %.2f\n", medianegativos);
    printf("Soma dos positivos: %.2f\n", totalpositivos);
    
    return 0;

}