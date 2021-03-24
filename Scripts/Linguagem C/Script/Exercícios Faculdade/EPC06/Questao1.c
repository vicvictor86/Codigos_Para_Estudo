#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void verificames(int mes, char mesextenso[])
{
    switch(mes)
    {
        case(1):
            strcpy(mesextenso,"Janeiro");
            break;
        case(2):
            strcpy(mesextenso,"Fevereiro");
            break;
        case(3):
            strcpy(mesextenso,"Março");
            break;
        case(4):
            strcpy(mesextenso,"Abril");
            break;
        case(5):
            strcpy(mesextenso,"Maio");
            break;
        case(6):
            strcpy(mesextenso,"Junho");
            break;
        case(7):
            strcpy(mesextenso,"Julho");
            break;
        case(8):
            strcpy(mesextenso,"Agosto");
            break;
        case(9):
            strcpy(mesextenso,"Setembro");
            break;
        case(10):
            strcpy(mesextenso,"Outubro");
            break;
        case(11):
            strcpy(mesextenso,"Novembro");
            break;
        case(12):
            strcpy(mesextenso,"Dezembro");
            break;
        default:
            printf("Mes nao existente");
            break;
    }
}

int verificaano(int ano)
{
    if(ano < 100 && ano > 0)
    {
        ano += 1900;
    }

    return ano;
}

int main(int argc, char *argv[])
{
    int dia = atoi(argv[1]);
    int mes = atoi(argv[2]);
    int ano = atoi(argv[3]);
    char mesextenso[30];

    verificames(mes, mesextenso);
    ano = verificaano(ano);

    printf("%d de %s de %d\n", dia, mesextenso, ano);

    system("pause");

    return 0;
}