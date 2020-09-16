#include<stdio.h>

int main()
{
    int numero = 0;

    scanf("%d", &numero);

    if(eh_primo(numero))
    {
        printf("S");
    }
    else
    {
        printf("N");
    }

}

int eh_primo(int numero)
{
    if(numero == 1)
    {
        return 0;
    }
    
    for(int i = 2; i < numero; i++)
    {
        if(numero % i == 0)
        {
            return 0;
        }
    }

    return 1;
}