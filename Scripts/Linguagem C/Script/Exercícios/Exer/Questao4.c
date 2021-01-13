#include <stdio.h>

typedef struct{
    int matricula;
    float notas[3];
}Aluno;

void lerAluno(Aluno* aluno)
{
    printf("Digite a matricula: ");
    scanf("%d", &aluno->matricula);

    int i;
    for (i = 0; i < 3; i++)
    {
        printf("Digite a %d nota: ", i+1);
        scanf("%f", &aluno->notas[i]);
    }
    
}

void imprimeTurma(Aluno turma[])
{   
    int i,j ;
    for (i = 0; i < 2; i++)
    {
        printf("Turma %d ", i+1);
        printf("Matricula %d\n", turma[i].matricula);
        for (j = 0; j < 3; j++)
        {
            printf("Notas do Aluno %d e: %.2f\n", i, turma[i].notas[j]);
        }
        
    }
    
}

int main()
{
    Aluno turma[2];
    int i;

    for (i = 0; i < 2; i++)
    {
        lerAluno(&turma[i]);
    }

    imprimeTurma(turma);
    
}