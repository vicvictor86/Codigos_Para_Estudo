#include<stdio.h>
   int main()
{
   int b=10, i, vet[4], a;
    a=0;
    printf("Digite alguns numeros e direi quantos numeros sao maior que 18");

      for(i=0; i<5; i++)
    {
      scanf("\n %d" ,&vet[i]);
     }
      for(i=0; i<5; i++)
      {
         if(vet[i]>18)
         a++;
      }
    printf("\n Os numeros maiores que 18 sao: %d",a);

}
