#include<stdio.h>
#include<stdlib.h>
#include<locale.h>

int main(void) {

  //Declaração de variáveis e set do locale
  setlocale(LC_ALL, "Portuguese");
  float valor = 0.00, desconto = 0.00;

  //Entrada do usuário
  printf("Digite o valor do produto: ");
  scanf("%f", &valor);

  //Saída
  printf("O valor com desconto é: %.2f", 0.88 * valor);

  return 0;

}