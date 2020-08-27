  #include<stdio.h>
   main()
	{
		int Digito1;

		printf("Digite 1) Elogio \n");
		printf ("Digite 2) Ofensa \n");
		printf("Digite 3) Sair \n\n");

		printf("Escolha uma opção: ");
		scanf("%do",Digito1);

           switch
		  {
            if(Digito1 = 1)
		 		printf ("Voce é lindo(a)!");
		 		break;   // Impede que as instruções do caso 2 sejam executadas
          if else (Digito1 = 2)
		 		printf ("Voce é um monstro!");
		 		break;   // Impede que as instruções do caso 2 sejam executadas
          if else (Digito1 = 3)
		 		printf ("Tchau!");
		 		break;
		 	if else // Será executado para qualquer opção diferente de 1, 2 ou 3
		 		printf ("Opção Inválida !");

           }

		printf("\n");
	}

