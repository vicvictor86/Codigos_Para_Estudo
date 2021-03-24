#include <stdio.h>
#include <stdlib.h>

int main()
{
    int v[10] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, i, *maior, *menor;

    for (i = 0; i < 10; i++)
    {
        if (i == 0)
        {
            maior = &v[0]; 
            menor = &v[0]; 
        }
        else
        {
            if (v[i] > *maior)
            {
                maior = &v[i];
            }
            else if (v[i] < *menor)
            {
                menor = &v[i];
            }
        }
    }
    printf("A soma do maior com o menor e: %d\n", *maior + *menor);

    return 0;
}