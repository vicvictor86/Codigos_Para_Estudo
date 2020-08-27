#include<stdio.h>

int main(){

    int numero = 0;
    int eprimo = 1;

    scanf("%d", &numero);

    for(int i = 2; i < numero; i++)
    {

        if(numero % i == 0){

            printf("N");
            eprimo = 0;
            break;

        }

    }
    
    if (eprimo == 1)
    {
        printf("S");
    }
    
}