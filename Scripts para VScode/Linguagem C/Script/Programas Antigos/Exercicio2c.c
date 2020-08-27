#include<stdio.h>
int main()
{

    float comissao,consumo;
    printf("Quanto o usuario consumiu ?\n");
    scanf("%f",&consumo);
    comissao = consumo * 0.1;
    printf("A comissao do garcom foi de %.2f reais.",comissao);
    return 0;

}