#include<stdio.h>
  main()
 {
      int i,vet[50];
      printf("Os numeros pares de 1 a 50 sao:\n");
      for(i=0;i<=50;i++)
     {
        vet[i]=i++;
        if(vet[i]%2 != 0)
           printf("%d\n",vet[i]);
     }
 }
