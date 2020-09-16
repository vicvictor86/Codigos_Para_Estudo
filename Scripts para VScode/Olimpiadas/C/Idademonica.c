#include <stdio.h>

int main()
{

    int m, a, b, c, maior;
    scanf("%d", &m);
    scanf("%d", &a);
    scanf("%d", &b);

    c = m - a - b;
    maior = a > b ? a : b;
    maior = c > maior ? c : maior;

    if(a > b){
        maior = a;
    }else{
        maior = b;
    } 

    printf("%d", maior);

}