#include <stdio.h>
#define OPERARIOS 10

int main(){

    int inferiora24 = 0, tempototal = 0, superiora600 = 0;
    float mediaservico = 0.0, porcentagemoperarios = 0.0;

    for (int i = 1; i <= OPERARIOS; i++)
    {
        
        float salario;
        int tempodeservico;
        printf("Digite o salario do %d funcionario: ", i);
        scanf("%f", &salario);
        printf("Digite o tempo de servico(em meses) do %d funcionario: ", i);
        scanf("%d", &tempodeservico);

        tempototal += tempodeservico;

        if(tempodeservico < 24)
        {
            inferiora24++;
        }

        if(salario > 600.0)
        {
            superiora600++;
        }

    }

    mediaservico = (float)tempototal / OPERARIOS;
    porcentagemoperarios = (superiora600 * 100.0) / OPERARIOS;

    printf("Operarios com servico inferior a 24 meses: %d\n", inferiora24);
    printf("Tempo medio de servico dos operarios: %.2f\n", mediaservico);
    printf("Porcentagem de operarios que recebem salario superior a 600: %.2f\n", porcentagemoperarios);
    
    return 0;

}