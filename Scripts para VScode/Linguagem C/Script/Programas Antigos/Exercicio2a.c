#include<stdio.h>
#include<math.h>
#define PI 3.14
int main()
{
    
    float raio,altura,cone,cilindro,esfera;
    raio = 4;
    altura = 2;
    printf("O raio definido foi: 4\n");
    printf("A altura definida foi: 2\n");
    esfera = (4 * PI * pow(raio,3))/3;
    cone = (PI * pow(raio,2) * altura) / 3;
    cilindro = PI * pow(raio,2) * altura;
    printf("O volumde da esfera e %.2f \nO volume do cone e %.2f \nO volu    me do cilindro e %.2f", esfera, cone, cilindro);
    return 0;
    
}
