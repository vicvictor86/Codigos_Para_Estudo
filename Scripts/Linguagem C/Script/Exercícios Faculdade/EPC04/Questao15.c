#include <stdio.h>
#include <string.h>

int ehconsoante(char letra)
{
    if (letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u' || letra == 'A' || letra == 'E' || letra == 'I' || letra == 'O' || letra == 'U')
    {
        return 0;
    }
    else
    {
        return 1;
    }
}

int main()
{
    char frase[100];
    char novafrase[100] = "";
    int i = 0, cont = 0;

    printf("Digite uma frase: ");
    gets(frase);

    for (i = 0; i < strlen(frase) / 2; i++)    
    {
        if (ehconsoante(frase[i]))
        {
            //Só recebera os caracteres que são consoantes
            novafrase[cont] = frase[i];
            cont++;
        }   
    }
    printf("%s\n", novafrase);

    return 0;
}
