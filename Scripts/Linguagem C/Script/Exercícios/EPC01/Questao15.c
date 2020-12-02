#include <stdio.h>

int main(){

    int total = 0;

    //Vai começar de um número par e ir somando 2 para sempre se manter par
    for (int i = 86; i < 908; i+= 2)
    {
        printf("%d\n", i);
        total += i;
    }
    
    printf("A soma de todos esses valores e: %d\n", total);

    return 0;

}