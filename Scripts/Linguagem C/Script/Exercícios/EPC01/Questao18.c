#include <stdio.h>

int main(){

    int numero1, numero2, numeromenor, numeromaior, produto = 0;

    printf("Digite o numero 1: ");  
    scanf("%d", &numero1);
    printf("Digite o numero 2: ");
    scanf("%d", &numero2);

    //Verificar qual numero utilizar para a soma pois em um caso especifico como
    //1 * 2147483647(valor máximo suportado pelo tipo int), caso o código sempre pegasse o primeiro numero para fazer a soma ele iria somar 1 2147483647 vezes
    //Com essa verificação, o compilador agora somara o 2147483647 apenas 1 vez sendo assim, transformando os 5 segundos em 0 segundos
    numeromenor = numero1 < numero2 ? numero1 : numero2;
    numeromaior = numero1 > numero2 ? numero1 : numero2;

    for (int i = 0; i < numeromenor; i++)
    {
        produto += numeromaior;
    }

    printf("\nO produto desses numeros e: %d\n", produto);

    return 0;

}