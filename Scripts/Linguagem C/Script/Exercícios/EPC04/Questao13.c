#include <stdio.h>
#include <string.h>

void esvaziarstring(char string[])
{
    char stringvazia[100] = "";
    strcpy(string, stringvazia);
} 

int main()
{
    char frase[100] = "e chega de disputar essa rua com a monica, eu poderei comprar ruas, bairros inteiros";
    char frasemudada[100] = "";
    int i = 0, cont = 0;

    for (i = 0; i < strlen(frase); i++)
    {
        frasemudada[cont] = frase[i];
        if(frasemudada[cont] == 'r' && frase[i + 1] == 'r')
        {
            frasemudada[cont] = 'l';
            i++;
        }
        else if(frasemudada[cont] == 'r' && frase[i + 1] == ' ')
        {
            cont++;
            continue;
        }
        else if(frasemudada[cont] == 'r')
        {
            frasemudada[cont] = 'l';
        }
        cont++;
    }
    
    printf("%s", frasemudada);

    return 0;
}
