#include <stdio.h>
#include <stdlib.h>

int main()
{
    int **numeros, i, j, ehquadradomagico = 0, somadiagonal1 = 0, somadiagonal2 = 0, somacoluna = 0, somalinha = 0;

    //O calloc diferente do malloc aloca um espaço de memória com todos os elementos já zerados
    numeros = (int **) calloc(3,  sizeof(int *));
    for (i = 0; i < 3; i++)
    {
        numeros[i] = (int *) calloc(3, sizeof(int));
        for (j = 0; j < 3; j++)
        {
            printf("Digite o numero na posicao[%d][%d]: ", i, j);
            scanf("%d", &numeros[i][j]);
        }   
    }

    for  (i = 0; i < 3; i++)
    {
        for (j = 0; j < 3; j++)
        {
            printf("%d ", numeros[i][j]);    
        }
        printf("\n");
    }

    somadiagonal1 = numeros[0][0] + numeros[1][1] + numeros[2][2];
    somadiagonal2 = numeros[0][2] + numeros[1][1] + numeros[2][0];
    for (i = 0; i < 3; i++)
    {   
        for (j = 0; j < 3; j++)
        {
            somalinha += numeros[i][j];
            somacoluna += numeros[j][i];
        }
        
        if (somalinha != 15 || somacoluna != 15 || somadiagonal1 != 15 || somadiagonal2 != 15)
        {
            printf("O quadrado acima nao e magico\n");
            ehquadradomagico = 0;
            break;
        }
        else
        {
            ehquadradomagico = 1;
        }
        somalinha = 0;
        somacoluna = 0;
    }

    if(ehquadradomagico)
    {
        printf("O quadrado acima e magico");
    }

    return 0;
}