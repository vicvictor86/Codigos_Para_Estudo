#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main()
{
    FILE *fr, *fw;
    fr = fopen("arquivo.html", "r");
    fw = fopen("arquivosemhtml.txt", "w");
    int ch = 0, ehtag = 0;

    if(fr == NULL || fw == NULL)
    {
        printf("Erro ao abrir o arquivo");
        return 0;
    }

    while ((ch = fgetc(fr)) != EOF)
    {
        if(ch == '<')
        {
            ehtag = 1;
        }
        else if(ch == '>')
        {
            ehtag = 0;
            continue;
        }

        if (ehtag == 0)
        {
            fputc(ch, fw);
        }
    }
    printf("Tags retiradas com sucesso");
    fclose(fr);
    fclose(fw);

    return 0;
}