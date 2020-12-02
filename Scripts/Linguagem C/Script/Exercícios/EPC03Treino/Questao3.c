#include <stdio.h>

void exchange(int* astolfo, int* gostoso)
{
    int temp;
    temp = *astolfo;
    *astolfo = *gostoso;
    *gostoso = temp;
    printf("a = %d, b = %d\n", *astolfo, *gostoso);
} 

int main()
{
    int *a, *b;
    a = 5;
    b = 7;

    exchange(&a, &b);
    printf("a = %d, b = %d\n", a,b);

    return 0;
}