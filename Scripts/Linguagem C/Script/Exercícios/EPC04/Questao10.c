#include <stdio.h>
#define QUANTIDADEELETRODOMESTICOS 5

struct Eletrodomesticos
{
    char nome[15];
    float potencia;
    int tempoativo;
};
typedef struct Eletrodomesticos Eletrodomesticos;

float consumo(Eletrodomesticos eletro)
{
    return eletro.potencia * eletro.tempoativo;
}

int main()
{
    Eletrodomesticos eletro[QUANTIDADEELETRODOMESTICOS];
    int i = 0, dias = 0;
    float consumototal = 0;
    
    for (i = 0; i < QUANTIDADEELETRODOMESTICOS; i++)
    {
        printf("Digite o nome do eletrodomestico: ");
        gets(eletro[i].nome);
        
        printf("Digite a potencia dele: ");
        scanf("%f", &eletro[i].potencia);
        fflush(stdin);

        printf("Digite o tempo que ele fica ligado em horas: ");
        scanf("%d", &eletro[i].tempoativo);
        fflush(stdin);
    }
    
    printf("Quantos dias eles estao em uso ?: ");
    scanf("%d", &dias);
    fflush(stdin);

    for (i = 0; i < QUANTIDADEELETRODOMESTICOS; i++)
    {
        consumototal += consumo(eletro[i]) * dias;
    }
    printf("\nConsumo total da casa: %.2f\n", consumototal);
    
    for ( i = 0; i < QUANTIDADEELETRODOMESTICOS; i++)
    {
        printf("Consumo relativo do %s: %.2f%%\n", eletro[i].nome, (consumo(eletro[i]) * dias / consumototal) * 100.0);
    }

    return 0;
}