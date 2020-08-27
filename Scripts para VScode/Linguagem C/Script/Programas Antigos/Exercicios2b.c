#include<stdio.h>
int main()
{

    float celsius,farhe;
    printf("Digite uma temperatura em Fahrenheit: ");
    scanf(" %f", &farhe);
    celsius =(farhe - 32) * 5/9;
    printf("A temperatura %.2f F equivale a %.2f C", farhe , celsius);
    return 0;
}