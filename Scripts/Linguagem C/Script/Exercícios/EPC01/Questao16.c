#include <stdio.h>

int main(){

    float h;

    for (int i = 1; i < 11; i++)
    {   
        //Nos numeros em que o i for par há uma subtração do h enquanto nos ímpares há uma adição
        if(i % 2 == 0)
        {
        
            h -= (float)i / (i * i);
            //Evita que na ultima divisão o 10/100 não possua um + sem nenhum número seguinte
            i != 10 ? printf("%d/%d + ", i, i * i) : printf("%d/%d", i, i * i);

        }
        else
        {

            h += (float)i / (i * i);
            printf("%d/%d - ", i, i * i);

        }
        
    }
    
    printf("\nO resultado dessas operacoes e: %.3f\n", h);

    return 0;

}