#include<stdio.h>
#include<stdlib.h>
#include<locale.h>

int main(void) {

  //Declaração de variáveis e set do locale
  setlocale(LC_ALL, "Portuguese");
  float celsius = 0.00, kelvin = 0.00;

  //Entrada do usuário
  printf("Digite a temperatura em Kelvin: ");
  scanf("%f", &kelvin);

  celsius = kelvin - 273.15;

  //Saída
  printf("%.2f K equivale a %.2f em celsius", kelvin, celsius);

  return 0;

}