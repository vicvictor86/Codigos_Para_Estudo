#include <stdio.h>

int main(){

    int n, fatorial;
    printf("Digite um numero para ser fatorado: ");
    scanf("%d", &n);
    fatorial = n;
    
    //Print de qual número vai ser fatorado
    printf("%d! = ", n);
    
    //Testa se o número é 0 já que ele é uma exceção
    if(n == 0)
    {
        fatorial = 1;
        printf("%d\n", fatorial);
    }
    else
    {
        while (n > 0)
        {
            //Print do número atual
            printf("%d ", n);

            //O if evita zerar o fatorial no final
            if (n - 1 != 0)
            {
                //Calculo do fatorial
                fatorial = fatorial * (n - 1);
                printf("* ");
            
            }

            n--;

        }

        //Print do valor do fatorial
        printf("= %d\n", fatorial);
    }
    
    return 0;

}