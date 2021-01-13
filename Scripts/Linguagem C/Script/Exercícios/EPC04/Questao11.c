#include <stdio.h>
#include <string.h>

int main()
{
    char palavra[4][20];
    //Inicializar vazia pra tirar o possível lixo existente
    char juncao[80] = "";
    int i = 0;

    for (i = 0; i < 4; i++)
    {
        printf("Escreva a %d palavra: ", i + 1);
        gets(palavra[i]);
    }
    
    for ( i = 0; i < 4; i++)
    {
        strcat(juncao, palavra[i]);
        //Dar um espaço entre as palavras concatenadas
        strcat(juncao, " ");
    }
    
    printf("%s\n", juncao);

    return 0;
}