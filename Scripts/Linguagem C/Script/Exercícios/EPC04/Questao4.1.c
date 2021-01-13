#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#define FUNCIONARIOS 10

struct Funcionario
{
    char nome[30];
    float salario;
    int horaspordia;
};
typedef struct Funcionario Funcionario;

int main()
{
    int i = 0;
    srand(time(NULL));
    Funcionario funcionarios[FUNCIONARIOS];

    for (i = 0; i < FUNCIONARIOS; i++)
    {
        printf("Digite o nome do %d funcionario: ", i+1);
        gets(funcionarios[i].nome);
        printf("Digite o salario do funcionario %s: ", funcionarios[i].nome);
        scanf("%f", &funcionarios[i].salario);
        fflush(stdin);
        printf("Digite quantas horas o funcionario %s trabalha: ", funcionarios[i].nome);
        scanf("%d", &funcionarios[i].horaspordia);
        fflush(stdin);
    }

    for (i = 0; i < FUNCIONARIOS; i++)
    {
        if (funcionarios[i].horaspordia < 10)
        {
            funcionarios[i].salario += 50.0;
        }
        else if(funcionarios[i].horaspordia < 12)
        {
            funcionarios[i].salario += 100.0;
        }
        else
        {
            funcionarios[i].salario += 150.0;
        }
    }
    
    for ( i = 0; i < FUNCIONARIOS; i++)
    {
        printf("\n");
        printf("Nome: %s\n", funcionarios[i].nome);
        printf("Horas por dia: %d\n", funcionarios[i].horaspordia);
        printf("Salario: %.2f\n", funcionarios[i].salario);
    }

    return 0;
}