#include <stdio.h>
#define QUANTIDADEALUNOS 10

struct Alunos
{   
    //Coloca-se em char para que caso o primeiro digito seja 0 ele não seja eliminado
    char matricula[8];
    char nome[30];
    int codigodadisciplina;
    float nota1;
    float nota2;
    float media;
};
typedef struct Alunos Alunos;

void calcularmedia(float nota1, float nota2, Alunos *alunos)
{
    int i;
    for (i = 0; i < QUANTIDADEALUNOS; i++)
    {
        alunos[i].media = (alunos[i].nota1 * 1 + alunos[i].nota2 * 2) / 3;
    }
}

void registraalunos(Alunos *alunos)
{
    int i = 0;
    for (i = 0; i < QUANTIDADEALUNOS; i++)
    {
        printf("Digite a matricula do %d aluno[Apenas numeros]: ", i + 1);
        scanf("%s", alunos[i].matricula);
        fflush(stdin);
        printf("Digite o nome do aluno: ");
        gets(alunos[i].nome);
        printf("Digite o codigo da disciplina: ");
        scanf("%d", &alunos[i].codigodadisciplina);
        fflush(stdin);
        printf("Digite a nota 1: ");
        scanf("%f", &alunos[i].nota1);
        fflush(stdin);
        printf("Digite a nota 2: ");
        scanf("%f", &alunos[i].nota2);
        fflush(stdin);
        calcularmedia(alunos[i].nota1, alunos[i].nota2, alunos);
		printf("\n");
    }
}

void apresentaalunos(Alunos *alunos)
{
    int i;
    for (i = 0; i < QUANTIDADEALUNOS; i++)
    {
        printf("Matricula: %s, Aluno: %s, Codigo da disciplina: %d, Nota 1: %.2f, nota 2: %.2f, media final: %.2f\n", alunos[i].matricula, alunos[i].nome, 
        alunos[i].codigodadisciplina, alunos[i].nota1, alunos[i].nota2, alunos[i].media);
    }
}

int main()
{
    Alunos alunos[QUANTIDADEALUNOS];
    registraalunos(alunos);

    apresentaalunos(alunos);
    
    return 0;
}