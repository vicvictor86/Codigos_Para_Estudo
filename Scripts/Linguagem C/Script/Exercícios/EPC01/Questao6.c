#include <stdio.h>
#define MEMBROS 10

int main(){

    int inferior30 = 0;
    float media, total = 0.0;

    for (int i = 1; i <= MEMBROS; i++)
    {
        
        int idade;
        printf("Digite a idade do %d membro: ", i);
        scanf("%d", &idade);

        total += idade;

        if(idade < 30)
        {
            inferior30++;
        }

    }
    
    media = total / MEMBROS;

    printf("No clube existe %d membros com menos de 30 anos\nE a idade media dos membros sao: %.2f\n", inferior30, media);

    return 0;

}