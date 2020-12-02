#include <stdio.h>

int main(){

    int n, sequencia = 2;
    
    printf("Quantas parcelas da sequencia voce quer que apareca?\n");
    scanf("%d", &n);

    while (n > 0) 
    {

        printf("%d ", sequencia);
        //Aumento do valor da sequencia
        sequencia += 2;
        //Decremento das parcelas
        n--;

    }

    return 0;

}