#include<stdio.h>

int main()
{
    float nota1, nota2, nota3, media;

    printf("Escreva as notas dos alunos 1,2 e 3 nessa ordem: ");
    scanf("%f %f %f",&nota1,&nota2,&nota3);
    media = (nota1 + nota2 + nota3) / 3; 
    printf("A média dessas 3 notas é: %f", media);
    
}