#include<stdio.h>
#include<stdlib.h>
#include<locale.h>

int main(void) {
  
  //Declaração de variáveis e set do locale
  setlocale(LC_ALL, "Portuguese");
  float numero = 0.00;
  
  //Entrada do usuário
  printf("Digite um número: ");
  scanf("%f", &numero);
  
  //Saída
  printf("A quinta parte desse número é: %.2f", numero / 5);

  return 0;

}