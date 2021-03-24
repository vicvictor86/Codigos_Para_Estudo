#include <stdio.h>
#include <string.h>

int main()
{
    char palavra[30];
    int i, j;

    printf("Digite uma palavra: ");
    gets(palavra);

    for (i = 1; i <= strlen(palavra); i++)
    {
        //Executa uma quantidade de vezes que inicia em 1 e dps vai crescendo até o tamanho da palavra
        for (j = 0; j < i; j++)
        {
            printf("%s ", palavra);
        }
        printf("\n");
    }
    return 0;
}
