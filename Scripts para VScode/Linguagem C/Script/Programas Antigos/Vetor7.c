#include<stdio.h>

int main()
{
    int n,i,count = 0;
    int quantidade[100];
    float numeros[100];
    printf("Digite a quantidade de numeros: ");
    scanf(" %d", &n);
    for(i = 0 ; i < n; i++)
    {
        printf("Digite o numero %d: ", i + 1);
        scanf(" %f", &numeros[i]);
    }
    for (count = 0; count < n; count++)
    {
        for (i = 0; i < n; i++)
        { 
            if(numeros[count] == numeros[i])
            {
                quantidade[i] += 1;
            }
        }
        
    }
    for (i = 0; i < n; i++)
    {
        printf("%.2f aparece %.2f vezes\n",numeros[i], quantidade);
    }
    

}