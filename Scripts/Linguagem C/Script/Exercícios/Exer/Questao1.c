#include <stdio.h>
#include <string.h>

int main()
{
    char palavra[50];
    int i = 0;

    printf("Escreva uma palavra: ");
    gets(palavra);

    for(i = 1; i < strlen(palavra); i += 2)
    {
        printf("%c", palavra[i]);
    }
    
    return 0;

}