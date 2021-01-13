#include <stdio.h>
#include <string.h>

void deixarmaiusculo(char palavra[])
{
    int i = 0;
    for (i = 0; palavra[i] != '\0'; i++)
    {
        if (palavra[i] >= 97 && palavra[i] <= 122)
        {
            palavra[i] -= 32;
        }
    }
}

//Precisa tirar os espaços para que a comparação seja exclusivamente das letras
void tirarespaco(char palavra[])
{
    char novapalavra[30] = {""};
    int i = 0, cont = 0;
    for (i = 0; i < strlen(palavra); i++ )
    {
        if (palavra[i] != ' ')
        {
            novapalavra[cont] = palavra[i];
            cont++;
        }   
    }
    strcpy(palavra, novapalavra);
}

//Deixar as letras em maiusculo para n ter diferença na comparação se ta maiusculo ou minusculo
void tratamentodapalavra(char palavra[])
{
    tirarespaco(palavra);
    deixarmaiusculo(palavra);
}

int main()
{
    char palavra[30];
    char palavrainvertida[30] = "";
    int i = 0, cont = 0;

    printf("Digite uma palavra: ");
    gets(palavra);

    tratamentodapalavra(palavra);
    for (i = strlen(palavra) - 1; i >= 0; i--)
    {
        palavrainvertida[cont] = palavra[i];
        cont++;
    }

    strcmp(palavra, palavrainvertida) == 0 ? printf("Essa palavra e um palindromo") : printf("Essa palavra nao e um palindromo");
    
    return 0;
}
