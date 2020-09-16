#include<stdio.h>
#include<stdlib.h>
#include<locale.h>

int main(void) {

  //Declaração de variáveis e set do locale
  setlocale(LC_ALL, "Portuguese");
  float salario = 0.00, prestacao = 0.00;

  //Entrada
  printf("Digite seu salário: ");
  scanf("%f", &salario);

  printf("Digite a prestação: ");
  scanf("%f", &prestacao);

  //Saída
  if(prestacao > 0.20 * salario){

    printf("Empréstimo não concedido");

  }
  else{

    printf("Empréstimo concedido");
  
  }

  return 0;
}