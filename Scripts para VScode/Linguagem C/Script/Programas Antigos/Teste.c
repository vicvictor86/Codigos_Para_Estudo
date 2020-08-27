#include<stdio.h>
 main()
 {
     int idade[4], i, soma = 0;
     for (i = 0; i<4; i++)
     {
         printf("digite a idade da pessoa %d: ",i);
         scanf("%d", idade[i]);

     }
     for(i = 0; i<4; i++)
      soma += idade[i];
    printf("Idade media : %d\n", soma / 4);

 }
