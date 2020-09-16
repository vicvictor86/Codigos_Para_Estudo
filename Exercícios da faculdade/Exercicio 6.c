#include<stdio.h>
#include<stdlib.h>
#include<locale.h>

int main(){

    //Declaração de variáveis e set do locale	
    setlocale(LC_ALL, "Portuguese");

    //Protótipo local da função
    double setNota ();

    // trabalho de laboratório : peso 2; avaliação : peso 3; exame final : peso 5;
    double notaLaboratorio = 0.00, notaAvalicacao = 0.00, notaExame = 0.00, notaFinal = 0.00;
    //O tipo das variáveis é double devido este tipo possuir maior precisão
    //tornando possível a comparação da nota nos if's

    //Entrada
    printf("Digite sua nota no trabalho de laboratório: ");
    notaLaboratorio = setNota();

    printf("Agora a da avaliação semestral: ");
    notaAvalicacao = setNota();

    printf("Agora a do exame final: ");
    notaExame = setNota();

    //Saída
    notaFinal = (notaLaboratorio * 2 + notaAvalicacao * 3 + notaExame * 5) / 10;
    printf("Sua nota final foi: %.2f logo ", notaFinal);

    if(notaFinal >= 3 && notaFinal <= 4.9){
        printf("vocé está de recuperação.");
    }
    //Não precisa verificar se é maior ou igual a 0, pois a função setNota já
    //verifica se a nota é maior que 0 e 0 está incluido nos números menores que 2,9
    else if (notaFinal <= 2.9){
        printf("você foi reprovado.");
    }
    else if(notaFinal >= 5 && notaFinal <= 10){
        printf("você foi aprovado");
    }
	
    return 0;
}

//Vai pedir a nota e verificar se a nota é maior ou igual a 0 e menor ou igual a 10
double setNota(){

    //Foi conveniente criar uma função devido com ela ser possível evitar a repetição de código
    //E fazer um input generalizado
    int notaValida = 0.00;
    double nota = 0.00;

    scanf("%lf", &nota);

    while (notaValida == 0){

        if(nota >= 0 && nota <= 10){
            notaValida = 1;
        }
        else{

            printf("\nNota inválida, por favor tente novamente.\n");
            printf("Digite a nota novamente: ");
            scanf("%lf", &nota);
            
        }

    }

    return nota;

}