#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define QUANTIDADEALUNOS 10

int main()
{
    FILE *fw;
    fw = fopen("dadosalunos.txt", "w");
    int i = 0;
    float nota1 = 0, nota2 = 0, media = 0;
    char nomealuno[30], nota1str[4], nota2str[4], mediastr[4];
    
    for(i = 0; i < QUANTIDADEALUNOS; i++)
    {
        printf("Digite o nome do aluno: ");
        gets(nomealuno);
        printf("Digite a nota1: ");
        scanf("%f", &nota1);
        printf("Digite a nota2: ");
        scanf("%f", &nota2);
        fflush(stdin);
        
        media = (nota1 + nota2) / 2;
        
        fputs(nomealuno,fw);

        sprintf(nota1str, "\n%.2f\n", nota1);
        fputs(nota1str,fw);

        sprintf(nota2str, "%.2f\n", nota2);
        fputs(nota2str,fw);

        sprintf(mediastr, "%.2f\n", media);
        fputs(mediastr,fw);
    }
    fclose(fw);

    return 0;
}