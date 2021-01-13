#include <stdio.h>
#include <string.h>

int main()
{
    char frase[60];
    char palavra[30];

    printf("Digite a primeira frase: ");
    gets(frase);
    printf("Digite a segunda: ");
    gets(palavra);

    //Função que verifica se o segundo arguemento está contido no primeiro argumento
    strstr(frase, palavra) != NULL ? printf("SUBSTRING") : printf("NAO SUBSTRING");   

    return 0;
}
