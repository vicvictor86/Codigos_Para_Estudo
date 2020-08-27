#include <stdio.h>//importa uma biblioteca de input e output
#include <locale.h>//importa uma biblioteca para caracteres especiais
int main()//inicio do bloco de comandos
{
	setlocale(LC_ALL, "Portuguese");//função que permite a utilização de caracteres da lingua portuguesa
	float numero;//declaração da variável numero
	int vencer = 0;//declaração da variáve que será responsável pela efetivação do laço
	int quantidade = 0;//declaração da variável que irá contar quantas vezes o usuário digitou um número
	
	printf("======================================\n");	
    printf("Bem vindo ao nosso DESAFIO DO DIA\n");//apresentações
    printf("======================================\n");
    
	while(vencer == 0)//laço que será usado para manter o programa em looping
	{
	
       printf("Digite uma nota de 0 a 10: ");//direcionamento ao usuário do que se deve fazer
	   scanf("%f",&numero);//input do usuário
	   if(numero >= 0 && numero <= 10)//vai verificar se o numero é maior ou igual a 0 e menor ou igual a 10
	  {
		  printf("NOTA VÁLIDA = %.1f\n",numero);//caso o número esteja dentro das condições essa mensagem será printada
		  vencer = 1;//com a mudança da variável vencer para 1, o laço será rompido e o programa sairá do looping
	  }
	   else if(numero < 0 || numero > 10)//vai verificar se o número é menor que 0 ou maior que 10
      {
		  quantidade += 1;//incremento da variável quantidade
		  
          if(quantidade == 3 || quantidade == 6 || quantidade == 9)//vai verificar se quantidade é igual a 3 ou a 6 ou a 9
		  {
		  	printf("NOTA INVÁLIDA ! %d tentativas! Pare de brincadeira!\n\n",quantidade);//caso esteja nas condições essa menssagem será printada
		  }
		  else if(quantidade == 10)//vai verificar se a quantiade é igual a 10
		  {
		  	printf("Ok, veremos quem se cansa primeiro hehe;)\n\n");//caso esteja nas condições essa menssagem será printada
		  }
		  else//caso a quantidade não atender a nenhuma das condições anteriores o bloco de comandos dentro desse else será executado
		  {
			  printf("NOTA INVÁLIDA! TENTE NOVAMENTE.\n\n");//caso esteja nas condições essa menssagem será printada
		  }
	  }
	
	
	}
	
	return 0;
}