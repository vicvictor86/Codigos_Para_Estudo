#include <stdio.h>//importa a biblioteca de input e output	
int main()//iniciar o bloco de comandos
{
	int opcao;//declara��o da vari�vel op��o
	float saldo = 100,mudanca;//declara��o da vari�vel saldo e mudan�a
	
	
	printf("============== BANCO CAPIVARA ================\n");
	printf("Seja bem vindo Adobisvaldo ao nosso caixa eletronico V2.0\n\n");
	printf("O que deseja fazer ?\n\n");
	printf("1-Sacar\n2-Depositar\n\n");
	printf("Digite a opcao de sua preferencia: ");
	scanf("%i",&opcao);//pede ao usu�rio que ele der um input da op��o que ele quer
	printf("==============================================\n");
	if(opcao == 1)//condicional que s� ser� executada caso o usu�rio escolha a op��o 1
	{
		
		printf("Seu saldo: %.2f\n",saldo);//printe do saldo
		printf("Digite o valor a ser sacado: ");
		scanf("%f",&mudanca);//Input de qual valor o usu�rio quer sacar
		if(mudanca > saldo)//condicional que ir� analisar se � poss�vel fazer o saque, verificando se a vari�vel mudan�a � menor que o saldo 
		{
			printf("=======================================");
			printf("\nSaldo insuficiente\n"); //aviso de que o saque � imposs�vel
		}
		else//condicional que ser� executada caso seja poss�vel efetuar o saque
		{
			saldo -= mudanca;//decremento da vari�vel saldo, efetuando o saque
			printf("\nSaldo atual:%.2f\n",saldo);//print do saldo ap�s o saque
			printf("==============================================\n");
			printf("Obrigado por utilizar nosso sistema, volte sempre\n");//Despedida
		}
		
		
	}
	else if(opcao == 2)//condicional que ser� executada caso o usu�rio escolha a op��o 2 que � depositar
	{
		
		printf("Seu saldo: %.2f\n",saldo);//printe do saldo
		printf("Digite o valor a ser depositado: ");
		scanf("%f",&mudanca);//Input de qual valor o usu�rio quer sacar
		if(mudanca < 0)//Verifica se a vari�vel mudanca � negativa
		{
			printf("==============================================\n");
			printf("\nValor negativo, impossivel de efetuar o deposito\n");
		}
		else
		{
			saldo += mudanca;//incremento do saldo
			printf("\nSaldo atual:%.2f\n",saldo);//print do saldo ap�s o dep�sito 
			printf("==============================================\n");
			printf("Obrigado por utilizar nosso sistema, volte sempre\n");
		}
		
	}
	else//condicional que ser� executda caso o usu�rio n�o coloque nenhuma das escolhas antes citadas. 
	{
		printf("A opcao escolhida nao existe\n");
	}
	
	return 0;
}