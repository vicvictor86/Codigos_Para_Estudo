#include<stdio.h>
 int main()
{
    int num[2],i,primo;
    printf("Digite 3 numeros e direi quais sao primos");
    scanf("%d",&num[0]);
    scanf("%d",&num[1]);
    scanf("%d",&num[2]);
    printf("Os numeros primos sao");
     for(i = 0;i<=2;i++)
     {
         if(num[i]%2 != 0)
            printf("%d",num[i]);

     }

}
