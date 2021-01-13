#include <stdio.h>
int main()
{
    float numero1 = 0, numero2 = 0; 
    int operacao = 0;

    printf("1-soma\n2-subtracao\n3-multiplicacao\n4-divisao\n");
    scanf("%d", &operacao);

    printf("Numero 1:");
    scanf("%f", &numero1);

    printf("Numero 2:");
    scanf("%f", &numero2);

    switch(operacao)
    {
        case 1:
            printf("%.2f + %.2f = %.2f", numero1, numero2, numero1 + numero2);
            break;
        case 2:
            printf("%.2f - %.2f = %.2f", numero1, numero2, numero1 - numero2);
            break;
        case 3:
            printf("%.2f * %.2f = %.2f", numero1, numero2, numero1 * numero2);
            break;
        case 4:
            printf("%.2f / %.2f = %.2f", numero1, numero2, numero1 / numero2);
            break;
        default:
            printf("Operacao indisponivel");
            break;
    }

    return 0;
}