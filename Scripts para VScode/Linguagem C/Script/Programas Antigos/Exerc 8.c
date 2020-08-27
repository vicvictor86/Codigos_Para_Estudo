#include<stdio.h>
 main()
 {
   int num=0,vet[5];
   int maior, menor;
   int passagem = 0;
   printf("Digite 5 numeros e direi qual é o maior e qual e o menor\n");
   for(int i=0; i<5; i++)
   {
    printf("Numero[%d]: ", i + 1);
    scanf("\n %d",&vet[i]);
    if (passagem == 0)
    {
      maior = vet[i];
      menor = vet[i];
      passagem++;
    }
    
    if(vet[i] > maior)
    {
      maior = vet[i];
    }
    if (vet[i] < menor)
    {
      menor = vet[i];
    }
    
   }
   printf("O maior numero e: %d e o menor numero e %d\n",maior, menor);
   printf("Fim do programa");  
}
