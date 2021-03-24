#include <stdio.h>

int main(){

    int dividendo, divisor, n;
    float a = 0;

    printf("Digite o valor de n: ");
    scanf("%d", &n);

    dividendo = n;
    //Ao divisor sempre soma-se 1 e ao dividendo substrai-se 1
    for (divisor = 1; divisor <= n; divisor++)
    {
        divisor == n ? printf("%d/%d", dividendo, divisor) : printf("%d/%d + ", dividendo, divisor);
        a += (float)dividendo / divisor;
        dividendo--;
    }
    
    printf("\nO resultado dessas operacoes e: %.2f\n", a);

    return 0;

}