#include <stdio.h>
typedef struct
{
	int matricula;
	float notas[3];
} Aluno;

void LeAluno(Aluno *turmaaux){
	int i;
	printf("Informe a matricula: ");
	scanf("%d", &turmaaux->matricula);
	
	for(i=0;i<3;i++){
	printf("Informe a nota %d: ", i+1);
	scanf("%f", &turmaaux->notas[i]);
	
	}
	
}

void ImprimeTurma(Aluno imprime[]){
	int i, j;
	for(i = 0; i<2; i++){
		printf("Matricula: %d\n", imprime[i].matricula);
		for(j= 0; j<3; j++){
			printf("Nota %d: %f\n", j+1, imprime[i].notas[j]);
		}
	}
	
	
}

int main()
{
	int i;
	Aluno Turma[2];
	for(i = 0; i < 2; i++)
	{
		LeAluno(&Turma[i]); // função que lê de teclado os dados do aluno
	}
	ImprimeTurma(Turma); // Função que imprime os dados de todos os alunos
	// for(i = 0; i < 5; i++)
	// {
	// 	media = CalculaMediaAluno(.......);// função que calcula a média das notas de um
	// 	aluno
	// 	printf("Aluno %d - Media = %f\n"); // imprime os dados do aluno
	// }
	return 0;
}