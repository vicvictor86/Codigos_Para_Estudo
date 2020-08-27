#include<stdio.h>
  main()
{
    int i,num1,resultado;
    printf("Digite um numero e farei a tabuada dele");
    scanf("%d",&num1);
    for(i=0;i<11;i++)
    {
        resultado = num1 * i;
        printf("%d x %d = %d\n\a",num1,i,resultado);

    }


}
