#include<stdio.h>
#include<stdlib.h>
#include<locale.h>

int main(){
    
  //Declaração de variáveis e set do locale
  setlocale(LC_ALL, "Portuguese");
  char resposta;
  int total = 0;

  //Entrada do usuário
  printf("Você considera 0 par ? :");
  scanf("%c", &resposta);

  //Saída
  if(resposta == 's'){

    //Inicia do 0
    for(int i = 0; i <= 98; i += 2 ){

      total += i;

    }

    printf("A soma dos 50 primeiros números pares(contando com o 0) é: %d.", total);

  }
  else if(resposta == 'n'){

    //Inicia do 2
    for(int i = 2; i <= 100; i += 2 ){

      total += i;

    }

    printf("A soma dos 50 primeiros números pares(sem contar com o 0) é: %d.", total);

  }
  else{
    printf("Digite uma resposta válida.");
  }
  
  return 0;

}