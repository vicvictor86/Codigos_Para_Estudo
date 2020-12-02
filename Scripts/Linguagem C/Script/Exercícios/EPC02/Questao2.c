#include <stdio.h>
#define TAMANHOVETOR 100

int main()
{

    int vetor[TAMANHOVETOR], posicao = 0, continuar = 1, ultimaposicaovetor;

    //A variável ultima posicao é atribuida antes da incrementação de posicao para que não fique com valor excedente
    while (continuar != 999 || posicao >= TAMANHOVETOR)
    {      
        
        printf("Digite o %d numero: ", posicao + 1);
        scanf("%d", &vetor[posicao]);
        ultimaposicaovetor = posicao;
        posicao++;

        printf("Digite 999 caso queira nao queira mais adicionar ");
        scanf("%d", &continuar);

    }

    for (int i = ultimaposicaovetor; i >= 0; i--)
    {
        printf("%d ", vetor[i]);
    }

    return 0;

}