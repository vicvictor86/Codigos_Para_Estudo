#include<stdio.h>
#include<stdlib.h>
#include<locale.h>

int main(){
  
  //Protótipo da função
  void soma(int, int); 

  //Declaração de variáveis e set do locale
  setlocale(LC_ALL, "Portuguese");
  int numero1 = 0, numero2 = 0;

  //Entrada do usuário
  printf("Digite o primeiro número: ");
  scanf("%d", &numero1);

  printf("Digite o segundo número: ");
  scanf("%d", &numero2);

  //Chamada da função
  soma(numero1, numero2);

  return 0;

}

//Função que vai fazer a soma
void soma(int numero1, int numero2){

  printf("%d + %d = %d", numero1, numero2, numero1 + numero2);

}