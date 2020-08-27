#include<stdio.h>

int main() 
{
    int aluno,i ;
    aluno = 0;
    char gabarito[5], respostas[5];
    printf("Digite o Gabarito Oficial\n");
    for (i = 0; i < 5 ; i++)
    {

        printf("Questao %d: ",i + 1);
        scanf(" %c",&gabarito[i]);

    }
    printf("\n");
    printf("Digite a sua resposta\n");
    for (i = 0; i < 5; i++)
    {

        printf("Questao %d ",i + 1);
        scanf(" %c",&respostas[i]);

    }
    printf("\n");

   for (i = 0; i < 5; i++)
   {
       if (gabarito[i] == respostas[i])
       {
           aluno += 1;
       }
   }

   printf("O aluno fez %d pontos",aluno);
   
    
    

    


}