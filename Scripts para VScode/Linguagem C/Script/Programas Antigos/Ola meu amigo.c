  #include<stdio.h>
   main()
	{
		int Digito1;

		printf("Digite 1) Elogio \n");
		printf ("Digite 2) Ofensa \n");
		printf("Digite 3) Sair \n\n");

		printf("Escolha uma op��o: ");
		scanf("%do",Digito1);

           switch
		  {
            if(Digito1 = 1)
		 		printf ("Voce � lindo(a)!");
		 		break;   // Impede que as instru��es do caso 2 sejam executadas
          if else (Digito1 = 2)
		 		printf ("Voce � um monstro!");
		 		break;   // Impede que as instru��es do caso 2 sejam executadas
          if else (Digito1 = 3)
		 		printf ("Tchau!");
		 		break;
		 	if else // Ser� executado para qualquer op��o diferente de 1, 2 ou 3
		 		printf ("Op��o Inv�lida !");

           }

		printf("\n");
	}

