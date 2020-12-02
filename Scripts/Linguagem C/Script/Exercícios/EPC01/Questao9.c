#include <stdio.h>
#include <string.h>
#define PESSOAS 10

int main(){

    float maioraltura, totalalturamulheres = 0.0, mediaalturamulheres, porcentagemmulheres;
    int homens = 0, mulheres = 0;
    char maiornome[40];

    for (int i = 1; i <= PESSOAS; i++)
    {
        
        float altura;
        char nome[40], sexo;

        printf("Digite a nome da %d pessoa: ", i);
        scanf("%s", &nome);
        printf("Digite a altura da %d pessoa: ", i);
        scanf("%f", &altura);
        printf("Digite o sexo da %d pessoa[m/f]: ", i);
        scanf(" %c", &sexo);

        if(i == 1)
        {
            maioraltura = altura;
            strcpy(maiornome, nome);
        }
        else
        {
            if (altura > maioraltura)
            {
                maioraltura = altura;
                strcpy(maiornome, nome);
            }
        }

        if(sexo == 'm') 
        {
            homens++;
        }
        else if(sexo == 'f')
        {

            totalalturamulheres += altura;
            mulheres++;

        }

    }
    
    mediaalturamulheres = totalalturamulheres / mulheres;
    porcentagemmulheres = (mulheres * 100.0) / PESSOAS;

    printf("A maior altura do grupo foi do %s que foi: %.2fm\n", maiornome, maioraltura);
    printf("A media da altura das mulheres foi: %.2f\n", mediaalturamulheres);
    printf("O numero de homens no grupo foi: %d\n", homens);
    printf("A porcentagem de mulheres em relacao a quantidade de pessoa foi: %.2f\n", porcentagemmulheres);

    return 0;

}