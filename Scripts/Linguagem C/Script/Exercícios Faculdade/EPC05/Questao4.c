#include <stdio.h>
#include <stdlib.h>

void lerelementos(int* elementos, int n)
{
    int i = 0;
    for (i = 0; i < n; i++)
    {
        printf("Digite o %d elemento: ", i + 1);
        scanf("%d", &elementos[i]);
    }
} 

int main()
{
    int *elementos, n = 0, i = 0;

    printf("Digite um valor: ");
    scanf("%d", &n);

    elementos = (int *) calloc(n, sizeof(int));

    lerelementos(elementos, n);

    for (i = 0; i < n; i++)
    {
        printf("Pos %d: %d\n", i + 1, elementos[i]);
    }
    
    free(elementos);
    return 0;
}