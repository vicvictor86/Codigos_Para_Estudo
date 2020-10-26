#include <stdio.h>//importa a biblioteca de input e output	
int main()//in�cio do bloco de comandos
{
	   int opcao;//declara��o da variavel opcao
	   float mudanca,saldo;//declara��o das vari�veis de tipo float
	   saldo = 400;//atribui��o do valor 400 a vari�vel saldo
	   printf("=====================Bem vindo a caixa registradora da loja Tabajara===================\n");//apresenta��es
	   printf("Selecione a opcao de sua preferencia:\n\n");
	   printf("1.Inserir dinheiro\n2.Verificar caixa\n3.Retirar dinheiro\n0.sair\n\n");//Menu com as op��es disponiveis para o usuario
	   printf("Selecione sua acao: ");//Pede ao usu�rio que ele selecione uma op��o
	   scanf("%i",&opcao);//input do usu�rio
	   printf("========================================================================================\n");
	   switch(opcao)//fun��o switch utilizando como argumento a vari�vel opcao
	   {
	     case 1://caso a vari�vel opcao seja igual a 1 executar� esse bloco de comandos
	     	
	     	printf("Informe a quantidade que deseja inserir: ");
	     	scanf("%f",&mudanca);//o usu�rio ir� inserir o quanto ele vai querer depositar na caixa
	     	printf("\n");
	     	if(mudanca <= 0)//se o usu�rio pedir a caixa registradora para inserir um valor menor ou igual a zero esse bloco de comandos ir� ser executado
			 {
				 printf("Impossivel de realizar a acao, insira apenas valores acima de 0\n");
				 printf("========================================================================================\n");
			 }
	     	else//caso o usu�rio digite uma quantidade positiva e maior que zero esse bloco de comandos ser� executado
			 {
				 saldo += mudanca;//incrementa��o no saldo da caixa
				 printf("O saldo total existente na caixa e de %.2f\n",saldo);//vai printar o saldo atual na caixa registradora ap�s o dep�sito do dinheiro
				 printf("========================================================================================\n");
			 }
		     break;//fim da leitura do compilador no bloco de comandos do switch
		 
		 case 2://caso a vari�vel opcao seja igual a 2 executar� esse bloco de comandos
		 	printf("O valor existente na caixa registradora atualmente e:%.2f reais\n",saldo);//vai printar o saldo atual na caixa registradora
		 	printf("========================================================================================\n");
		 	break;//fim da leitura do compilador no bloco de comandos do switch
		 
		 case 3://caso a vari�vel opcao seja igual a 3 executar� esse bloco de comandos3
		 	printf("Informe a quantidade que deseja retirar: ");
		 	scanf("%f",&mudanca);//o usu�rio ir� inserir o quanto ele vai querer retirar de dinheiro da caixa
		 	printf("\n");
		 	if(mudanca <= 0)//se o usu�rio pedir a caixa registradora para retirar um valor menor ou igual a zero esse bloco de comandos ir� ser executado
			 {
				 printf("Impossivel de realizar a acao, insira apenas valores acima de 0\n");
				 printf("========================================================================================\n");
			 }
			 else if(mudanca > saldo)//compara a vari�vel mudan�a com o saldo existente, caso a mudan�a seja maior que o saldo n ser� poss�vel retirar dinheiro dessa caixa
			 {
			 	printf("Impossivel retirar essa quantia pois o saldo atual da caixa e: %.2f\n",saldo);
			 	printf("========================================================================================\n");
			 }
			 else//todos os outros casos que est�o fora dos dois citados anterioremente ir�o gerar a execu��o desse bloco de comandos
			 {
			 	saldo -= mudanca;//decrementa��o no saldo da caixa
			 	printf("O saldo total existente na caixa e de %.2f\n",saldo);
			 	printf("========================================================================================\n");
			 }
		 	break;//fim da leitura do compilador no bloco de comandos do switch
		 
		 case 0://caso a vari�vel opcao seja igual a 0 executar� esse bloco de comandos
		 	printf("Encerrando a caixa registradora...\n");//vai printar o saldo atual na caixa registradora ap�s a retirada do dinheiro
		 	printf("========================================================================================\n");
		 	break;//fim da leitura do compilador no bloco de comandos do switch
		 
	     default://caso a vari�vel opcao n�o seja igual a nenhuma das op��es que foram apresentadas, esse bloco de comando ser� executado
	     	printf("Opcao escolhida invalida\n");
	     	printf("========================================================================================\n");
            break;//fim da leitura do compilador no bloco de comandos do switch
	   }
	   printf("Caixa Registradora encerrada\n");
	   
    return 0;
}