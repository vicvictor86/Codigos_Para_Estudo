#include <stdio.h>

struct data 
{
    int dia;
    int mes;
    int ano;
};
typedef struct data data;

int main()
{

    data data1, data2;

    printf("Digite a primeira data[Dia Mes Ano]:\n");
    scanf("%d", &data1.dia);
    scanf("%d", &data1.mes);
    scanf("%d", &data1.ano);

    printf("Digite a Segunda data: [Dia Mes Ano]");
    scanf("%d", &data2.dia);
    scanf("%d", &data2.mes);
    scanf("%d", &data2.ano);

    if(data1.dia == data2.dia && data1.mes == data2.mes && data1.ano == data2.ano)
    {
        printf("As datas sao iguais");
    }
    else
    {
        printf("As datas nao sao iguais");
    }

    return 0;
    
}