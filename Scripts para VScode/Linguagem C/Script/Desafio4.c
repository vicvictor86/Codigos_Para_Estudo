#include <stdio.h>//importa uma biblioteca de input e output
#include <locale.h>//importa uma biblioteca para caracteres especiais
int main()//inicio do bloco de comandos
{
	setlocale(LC_ALL, "Portuguese");//fun��o que permite a utiliza��o de caracteres da lingua portuguesa
	float numero;//declara��o da vari�vel numero
	int vencer = 0;//declara��o da vari�ve que ser� respons�vel pela efetiva��o do la�o
	int quantidade = 0;//declara��o da vari�vel que ir� contar quantas vezes o usu�rio digitou um n�mero
	
	printf("======================================\n");	
    printf("Bem vindo ao nosso DESAFIO DO DIA\n");//apresenta��es
    printf("======================================\n");
    
	while(vencer == 0)//la�o que ser� usado para manter o programa em looping
	{
	
       printf("Digite uma nota de 0 a 10: ");//direcionamento ao usu�rio do que se deve fazer
	   scanf("%f",&numero);//input do usu�rio
	   if(numero >= 0 && numero <= 10)//vai verificar se o numero � maior ou igual a 0 e menor ou igual a 10
	  {
		  printf("NOTA V�LIDA = %.1f\n",numero);//caso o n�mero esteja dentro das condi��es essa mensagem ser� printada
		  vencer = 1;//com a mudan�a da vari�vel vencer para 1, o la�o ser� rompido e o programa sair� do looping
	  }
	   else if(numero < 0 || numero > 10)//vai verificar se o n�mero � menor que 0 ou maior que 10
      {
		  quantidade += 1;//incremento da vari�vel quantidade
		  
          if(quantidade == 3 || quantidade == 6 || quantidade == 9)//vai verificar se quantidade � igual a 3 ou a 6 ou a 9
		  {
		  	printf("NOTA INV�LIDA ! %d tentativas! Pare de brincadeira!\n\n",quantidade);//caso esteja nas condi��es essa menssagem ser� printada
		  }
		  else if(quantidade == 10)//vai verificar se a quantiade � igual a 10
		  {
		  	printf("Ok, veremos quem se cansa primeiro hehe;)\n\n");//caso esteja nas condi��es essa menssagem ser� printada
		  }
		  else//caso a quantidade n�o atender a nenhuma das condi��es anteriores o bloco de comandos dentro desse else ser� executado
		  {
			  printf("NOTA INV�LIDA! TENTE NOVAMENTE.\n\n");//caso esteja nas condi��es essa menssagem ser� printada
		  }
	  }
	
	
	}
	
	return 0;
}