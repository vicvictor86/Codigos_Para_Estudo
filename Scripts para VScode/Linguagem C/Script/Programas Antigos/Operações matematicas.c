#include<stdio.h>

int main()
{
    int numero1,numero2,operacao,resultado;
    printf("Digite um numero:");
    scanf("%d",&numero1);
    printf("Digite outro numero:");
    scanf("%d",&numero2);
    printf("Qual operacao vc quer executar entre esses dois numeros?\n");
    printf("1-adicao\n");
    printf("2-multiplicacao\n");
    printf("3-subtracao\n");
    printf("4-divisao\n");
    scanf("%d",&operacao);
    switch(operacao)
    {
        case 1:
            resultado = numero1 + numero2;
            printf("%d + %d = %d",numero1,numero2,resultado);
            break;

        case 2:
            resultado = numero1 * numero2;
            printf("%d x %d = %d",numero1,numero2,resultado);
            break;

       case 3:
            resultado = numero1 - numero2;
            printf("%d - %d = %d",numero1,numero2,resultado);
            break;

       case 4:
            resultado = numero1 / numero2;
            printf("%d / %d = %d",numero1,numero2,resultado);
            break;

       default:
            printf("Nenhum resultado encontrado");
    }
    return 0;
 }
