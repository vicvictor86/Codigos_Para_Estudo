#include <stdio.h>
#include <math.h>

int main(){

    int n;

    printf("Digite quantos resultados voce quer: ");
    scanf("%d", &n);

    while (n > 0)
    {

        float x, y;
        printf("Digite o valor do x: ");
        scanf("%f", &x);

        //Calculo da função   
        y = sqrt((pow(x, 2) + 3) / 2);
        printf("O resultado e: %.2f\n", y);

        n--;
        
    }
    

    return 0;

}