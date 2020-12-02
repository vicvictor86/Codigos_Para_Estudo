#include <stdio.h>

int main(){

    int n, total = 0, impares = 0, media;

    printf("Digite o numero desejado: ");
    scanf("%d", &n);

    //Vai começar de um número ímpar e ir somando 2 para sempre se manter ímpar
    for(int i = 1; i <= n; i += 2)
    {
        total += i;
        impares++;
    }
    
    printf("%d e %d", total, impares);
    media = total / impares;
    printf("A media dos numeros impares inferiores ou iguais a %d e: %d\n", n, media);   

    return 0;

}