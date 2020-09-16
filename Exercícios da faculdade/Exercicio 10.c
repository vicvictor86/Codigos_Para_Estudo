#include<stdio.h>
#include<stdlib.h>
#include<locale.h>
#include<time.h>

int main(){
    
  /*lance o dado 1 milhão de vezes. Conte quantas vezes cada número saiu*/ 
  //Declaração de variáveis e set do locale
  setlocale(LC_ALL, "Portuguese");
  int numero1 = 0, numero2 = 0, numero3 = 0, numero4 = 0, numero5 = 0, numero6 = 0, numeroDado = 0;

  //Declarando a semente do rand para que a cada execução o resultado seja diferente
  //time null retorna os segundos de 1 de janeiro de 1970 até agora
  srand(time(NULL));

  for(int i = 1; i <= 1000000; i++){

    //Armazenando o valor que apareceu no dado de forma randômica
    numeroDado = 1 + rand() % 6;
    
    //A cada vez que o numero dado aparece ele acrescenta na variável
    switch(numeroDado){
      case 1:
        numero1++;
        break;
      case 2:
        numero2++;
        break;
      case 3:
        numero3++;
        break;
      case 4:
        numero4++;
        break;
      case 5:
        numero5++;
        break;
      case 6:
        numero6++;
        break;
      default:
        break;
    }

  } 
  
  //Saída
  printf("Quantidade de vezes que saiu o número 1: %d\n", numero1);
  printf("Quantidade de vezes que saiu o número 2: %d\n", numero2);
  printf("Quantidade de vezes que saiu o número 3: %d\n", numero3);
  printf("Quantidade de vezes que saiu o número 4: %d\n", numero4);
  printf("Quantidade de vezes que saiu o número 5: %d\n", numero5);
  printf("Quantidade de vezes que saiu o número 6: %d\n", numero6);

  return 0;

}