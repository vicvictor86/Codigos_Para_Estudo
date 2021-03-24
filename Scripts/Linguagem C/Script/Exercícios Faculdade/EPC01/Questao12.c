#include <stdio.h>
#define ALUNOS 10

int main(){

    float idadetotalmenos170 = 0, alturatotalmais20 = 0, mediaidade = 0, mediaaltura = 0;
    int menosde170 = 0, maisde20 = 0;

    for (int i = 1; i <= ALUNOS; i++)
    {
        
        float altura;
        int idade;
        printf("Digite a altura do %d aluno: ", i);
        scanf("%f", &altura);
        printf("Digite a idade do %d aluno: ", i);
        scanf("%d", &idade);

        if(altura < 1.70)
        {
            //Armazena a idade dos alunos que possuem altura menor que 1,70
            idadetotalmenos170 += idade;
            menosde170++;
        }

        if(idade > 20)
        {   
            //Armazena a idade dos alunos que possuem idade maior que 20
            alturatotalmais20 += altura;
            maisde20++;
        }

    }


    //Evitar a divisão por 0
    if(menosde170 != 0)
    {
        mediaidade = idadetotalmenos170 / menosde170;
    }
    
    if(maisde20 != 0)
    {
        mediaaltura = alturatotalmais20 / maisde20;
    }
    
    printf("A idade media dos alunos com menos de 1,70m e: %.2f\n", mediaidade);
    printf("A altura media dos alunos com mais de 20 anos e: %.2f\n", mediaaltura);
    
    return 0;

}