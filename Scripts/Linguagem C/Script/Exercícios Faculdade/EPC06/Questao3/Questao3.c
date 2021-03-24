#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main()
{
    FILE *fw, *fr;
    fw = fopen("numerosdigitados.txt", "w");
    int numero = 1;
    char numerostr[30];
    
    while(1)
    {
        printf("Digite um numero: ");
        scanf("%d", &numero);
        if(numero == 0)
        {
            break;
        }
        //Transforma inteiro para string
        sprintf(numerostr, "%d\n", numero);
        fputs(numerostr,fw);
    }
    //Precisa ser fechdo antes do fr ser aberto para que as alterações
    //sejam feitas no txt
    fclose(fw);

    fr = fopen("numerosdigitados.txt", "r");
    while (fgets(numerostr, 30, fr) != NULL)
    {
        printf("%s", numerostr);
    }
    fclose(fr);
    
    return 0;
}