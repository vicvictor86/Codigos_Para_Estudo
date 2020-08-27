#include <stdio.h>//importa a biblioteca de input e output	
int main()//início do bloco de comandos
{
	   int opcao;//declaração da variavel opcao
	   float mudanca,saldo;//declaração das variáveis de tipo float
	   saldo = 400;//atribuição do valor 400 a variável saldo
	   printf("=====================Bem vindo a caixa registradora da loja Tabajara===================\n");//apresentações
	   printf("Selecione a opcao de sua preferencia:\n\n");
	   printf("1.Inserir dinheiro\n2.Verificar caixa\n3.Retirar dinheiro\n0.sair\n\n");//Menu com as opções disponiveis para o usuario
	   printf("Selecione sua acao: ");//Pede ao usuário que ele selecione uma opção
	   scanf("%i",&opcao);//input do usuário
	   printf("========================================================================================\n");
	   switch(opcao)//função switch utilizando como argumento a variável opcao
	   {
	     case 1://caso a variável opcao seja igual a 1 executará esse bloco de comandos
	     	
	     	printf("Informe a quantidade que deseja inserir: ");
	     	scanf("%f",&mudanca);//o usuário irá inserir o quanto ele vai querer depositar na caixa
	     	printf("\n");
	     	if(mudanca <= 0)//se o usuário pedir a caixa registradora para inserir um valor menor ou igual a zero esse bloco de comandos irá ser executado
			 {
				 printf("Impossivel de realizar a acao, insira apenas valores acima de 0\n");
				 printf("========================================================================================\n");
			 }
	     	else//caso o usuário digite uma quantidade positiva e maior que zero esse bloco de comandos será executado
			 {
				 saldo += mudanca;//incrementação no saldo da caixa
				 printf("O saldo total existente na caixa e de %.2f\n",saldo);//vai printar o saldo atual na caixa registradora após o depósito do dinheiro
				 printf("========================================================================================\n");
			 }
		     break;//fim da leitura do compilador no bloco de comandos do switch
		 
		 case 2://caso a variável opcao seja igual a 2 executará esse bloco de comandos
		 	printf("O valor existente na caixa registradora atualmente e:%.2f reais\n",saldo);//vai printar o saldo atual na caixa registradora
		 	printf("========================================================================================\n");
		 	break;//fim da leitura do compilador no bloco de comandos do switch
		 
		 case 3://caso a variável opcao seja igual a 3 executará esse bloco de comandos3
		 	printf("Informe a quantidade que deseja retirar: ");
		 	scanf("%f",&mudanca);//o usuário irá inserir o quanto ele vai querer retirar de dinheiro da caixa
		 	printf("\n");
		 	if(mudanca <= 0)//se o usuário pedir a caixa registradora para retirar um valor menor ou igual a zero esse bloco de comandos irá ser executado
			 {
				 printf("Impossivel de realizar a acao, insira apenas valores acima de 0\n");
				 printf("========================================================================================\n");
			 }
			 else if(mudanca > saldo)//compara a variável mudança com o saldo existente, caso a mudança seja maior que o saldo n será possível retirar dinheiro dessa caixa
			 {
			 	printf("Impossivel retirar essa quantia pois o saldo atual da caixa e: %.2f\n",saldo);
			 	printf("========================================================================================\n");
			 }
			 else//todos os outros casos que estão fora dos dois citados anterioremente irão gerar a execução desse bloco de comandos
			 {
			 	saldo -= mudanca;//decrementação no saldo da caixa
			 	printf("O saldo total existente na caixa e de %.2f\n",saldo);
			 	printf("========================================================================================\n");
			 }
		 	break;//fim da leitura do compilador no bloco de comandos do switch
		 
		 case 0://caso a variável opcao seja igual a 0 executará esse bloco de comandos
		 	printf("Encerrando a caixa registradora...\n");//vai printar o saldo atual na caixa registradora após a retirada do dinheiro
		 	printf("========================================================================================\n");
		 	break;//fim da leitura do compilador no bloco de comandos do switch
		 
	     default://caso a variável opcao não seja igual a nenhuma das opções que foram apresentadas, esse bloco de comando será executado
	     	printf("Opcao escolhida invalida\n");
	     	printf("========================================================================================\n");
            break;//fim da leitura do compilador no bloco de comandos do switch
	   }
	   printf("Caixa Registradora encerrada\n");
	   
    return 0;
}