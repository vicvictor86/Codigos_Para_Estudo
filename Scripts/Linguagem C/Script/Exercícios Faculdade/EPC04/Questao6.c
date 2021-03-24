#include <stdio.h>
#include <math.h>
#define QUANTIDADEDEPONTOS 5

struct Ponto
{
    float x;
    float y;
};
typedef struct Ponto Ponto;

float calculodistancia(float x1, float y1, float x2, float y2)
{
    //Distancia entre dois pontos é: raiz quadradada de (x2 - x1)^2 + (y2 - y1)^2
    return sqrt(pow(x1 - x2, 2) + pow(y1 - y2, 2));
}

void definirpontos(Ponto *pontos)
{
    int i;
    for (i = 0; i < QUANTIDADEDEPONTOS; i++)
    {
        printf("Informe as coordenadas do ponto %d: ", i + 1);
        scanf("%f", &pontos[i].x);
        scanf("%f", &pontos[i].y);
    }
}

int main()
{
    Ponto pontos[5];
    Ponto pontomaisproximo;
    int i;

    definirpontos(pontos);
    //De inicio o ponto mais próximo vai ser o segundo ponto informado
    float valormaisproximo = calculodistancia(pontos[0].x, pontos[0].y, pontos[1].x, pontos[1].y);
    pontomaisproximo = pontos[1];
	//Como temos que comparar com o primeiro e o segundo inicialmente
	//consideramos o mais próximo, devemos comparar o 3° ponto pra frente	
    for (i = 2; i < QUANTIDADEDEPONTOS; i++)
    {
        //Se a nova distância calculada for menor que a menor distância até agora analisada
        //Troca-se os valores
        if (calculodistancia(pontos[0].x, pontos[0].y, pontos[i].x, pontos[i].y) < valormaisproximo)
        {
            pontomaisproximo = pontos[i];
            valormaisproximo = calculodistancia(pontos[0].x, pontos[0].y, pontos[i].x, pontos[i].y);
        }    
    }

    printf("O ponto mais proximo e: (%.2f, %.2f)\n", pontomaisproximo.x, pontomaisproximo.y);

    return 0;
}