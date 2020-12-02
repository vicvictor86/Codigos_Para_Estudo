#include <stdio.h>

int main(){

    float a, b, n;
    
    printf("Digite quantos alunos voce quer exibir a media: ");
    scanf("%f", &n);

    while (n > 0)
    {

        printf("Digite a primeira nota do aluno: ");
        scanf("%f", &a);

        printf("Digite a segunda nota do aluno: ");
        scanf("%f", &b);

        float media = (a + b) / 2.0;
        printf("A media desse aluno foi: %.2f\n", media);

        //Decremento para controlar o fluxo
        n--;

    }

    return 0;

}