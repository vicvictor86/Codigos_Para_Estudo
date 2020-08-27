#include<stdio.h>
int main()
{

    float dimensao1,dimensao2,area,potencia;
    printf("Digite a largura do seu comodo: ");
    scanf("%f",&dimensao1);
    printf("Digite o comprimento do seu comodo: ");
    scanf("%f",&dimensao2);
    area = dimensao1 * dimensao2;
    potencia = area * 18;
    printf("O seu comodo tera %.2f metros de area e sera necessario %.2f W de potencia para a iluminacao.",area,potencia);
    return 0;

}