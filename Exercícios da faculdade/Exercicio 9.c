#include<stdio.h>
#include<stdlib.h>
#include<locale.h>

int main(){
    
  //Declaração de variáveis e set do locale
  setlocale(LC_ALL, "Portuguese");
  int numero = 0, total = 0;

  //Entrada do usuário
  for(int i = 1; i <= 10; i++){

    printf("Digite o %d número: ", i);
    scanf("%d", &numero);
    total += numero;

  }

  //Saída
  printf("A média dos 10 números é: %.2f", (float)total / 10);
  
  return 0;

}