#include<stdio.h>
  main()
{
    int numero, c, quant;
    quant = 0;
    printf("Digite um número: ");
    scanf("%d",&numero);
    for(c = 2;c <= numero - 1; c++)
    {
        if (numero % c = 0){
            printf("Esse numero e primo");
            quant = quant + 1;
        }
        }
    if (quant == 0){
        printf("Esse numero e par");
        }
}
