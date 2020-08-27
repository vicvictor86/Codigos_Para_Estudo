#include <stdio.h>
#include <stdlib.h>
  main()
 {
   int numeroescolhido, numerorandom, tentativa, ganhar, false, true;
   printf("Bem vindo ao minijogo, tente advinhar qual numero sera gerado automaticamente pelo computador.Caso vc ultrapasse 10 tentativas vc ira perder\n");
   printf("Escolha seu numero:");
   numerorandom = rand() % 100 + 1;
   scanf("%d",&numeroescolhido);
   tentativa = 0;
   ganhar = false;

      while((tentativa < 11) && (ganhar == false))
    {
        if (numerorandom > numeroescolhido)
           {
            tentativa = tentativa + 1;
            printf("O numero e maior:");
            scanf("%d", &numeroescolhido);
                                          }
        else if (numerorandom < numeroescolhido)
        {
            tentativa = tentativa + 1;
            printf("O numero e menor:");
            scanf("%d",&numeroescolhido);
                                          }
        else if (numerorandom = numeroescolhido)
            {
              ganhar == true;
              printf("O numero escolhido e correto");
              break;
                    }

    }


 }
