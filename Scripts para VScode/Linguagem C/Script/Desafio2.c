#include <stdio.h>//importa a biblioteca de input e output	
int main()//iniciar o bloco de comandos
{
	int opcao;//declaração da variável opção
	float saldo = 100,mudanca;//declaração da variável saldo e mudança
	
	
	printf("============== BANCO CAPIVARA ================\n");
	printf("Seja bem vindo Adobisvaldo ao nosso caixa eletronico V2.0\n\n");
	printf("O que deseja fazer ?\n\n");
	printf("1-Sacar\n2-Depositar\n\n");
	printf("Digite a opcao de sua preferencia: ");
	scanf("%i",&opcao);//pede ao usuário que ele der um input da opção que ele quer
	printf("==============================================\n");
	if(opcao == 1)//condicional que só será executada caso o usuário escolha a opção 1
	{
		
		printf("Seu saldo: %.2f\n",saldo);//printe do saldo
		printf("Digite o valor a ser sacado: ");
		scanf("%f",&mudanca);//Input de qual valor o usuário quer sacar
		if(mudanca > saldo)//condicional que irá analisar se é possível fazer o saque, verificando se a variável mudança é menor que o saldo 
		{
			printf("=======================================");
			printf("\nSaldo insuficiente\n"); //aviso de que o saque é impossível
		}
		else//condicional que será executada caso seja possível efetuar o saque
		{
			saldo -= mudanca;//decremento da variável saldo, efetuando o saque
			printf("\nSaldo atual:%.2f\n",saldo);//print do saldo após o saque
			printf("==============================================\n");
			printf("Obrigado por utilizar nosso sistema, volte sempre\n");//Despedida
		}
		
		
	}
	else if(opcao == 2)//condicional que será executada caso o usuário escolha a opção 2 que é depositar
	{
		
		printf("Seu saldo: %.2f\n",saldo);//printe do saldo
		printf("Digite o valor a ser depositado: ");
		scanf("%f",&mudanca);//Input de qual valor o usuário quer sacar
		if(mudanca < 0)//Verifica se a variável mudanca é negativa
		{
			printf("==============================================\n");
			printf("\nValor negativo, impossivel de efetuar o deposito\n");
		}
		else
		{
			saldo += mudanca;//incremento do saldo
			printf("\nSaldo atual:%.2f\n",saldo);//print do saldo após o depósito 
			printf("==============================================\n");
			printf("Obrigado por utilizar nosso sistema, volte sempre\n");
		}
		
	}
	else//condicional que será executda caso o usuário não coloque nenhuma das escolhas antes citadas. 
	{
		printf("A opcao escolhida nao existe\n");
	}
	
	return 0;
}