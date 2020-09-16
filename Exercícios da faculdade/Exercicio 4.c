#include<stdio.h>
#include<stdlib.h>
#include<locale.h>

int main(void) {

  /*Calcular e imprimir a quantia recebida por cada um dos ganhadores.*/

  //Declaração de variáveis e set do locale
  setlocale(LC_ALL, "Portuguese");
  float importancia = 780000.00;

  //Saída
  printf("O primeiro ganhador recebeu: %.2f\n", importancia * 0.46);
  printf("O segundo ganhador recebeu: %.2f\n", importancia * 0.32);
  printf("O terceiro ganhador recebeu: %.2f\n", importancia * 0.22);

  return 0;

}