#include <stdio.h>
#include <stdlib.h>

//após isso pegar cada caractere e somar 4 no seu valor da tabela ascii
int main()
{
    FILE *fr, *fw;
    fr = fopen("texto.txt", "r");
    fw = fopen("codigocodificado.txt", "w");
    int ch, quantidadedeletras = 0;
    
    if(fr == NULL || fw == NULL)
    {
        printf("Erro ao abrir o arquivo");
        return 0;
    }

    //A cada laço vai pegar a letra no fr e armazenar na variável ch e somando mais um 
    //na tabela ASCII e colocando no outro arquivo
    while((ch = fgetc(fr)) != EOF)
    {
        ch += 4;
        fputc(ch, fw);
    }

    printf("Frase codificada com sucesso");

    fclose(fr);
    fclose(fw);

    return 0;
}