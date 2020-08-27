#include<stdio.h>
  main()
 {
     int i,vet[5];
     printf("Escolha 5 numeros e direi quais sao impares");
     for(i=0;i<5;i++)
   {
     scanf("\%d",&vet[i]);
   }
     for(i=0;i<5;i++)
   {
     if(vet[i]%2!=0)
     printf("\nOs numeros impares sao %d",vet[i]);
   }

 }
