#include <stdio.h>
#include <stdlib.h>
#include <string.h>

//após isso pegar cada caractere e somar 4 no seu valor da tabela ascii
int main()
{
    FILE *fr, *fw;
    fr = fopen("codigocodificado.txt", "r");
    fw = fopen("textodecodificado.txt", "w");
    int ch, quantidadedeletras = 0;
    
    if(fr == NULL || fw == NULL)
    {
        printf("Erro ao abrir o arquivo");
        return 0;
    }

    while((ch = fgetc(fr)) != EOF)
    {
        ch -= 4;
        fputc(ch, fw);
    }

    printf("Frase decodificada com sucesso");

    fclose(fr);
    fclose(fw);

    return 0;
}