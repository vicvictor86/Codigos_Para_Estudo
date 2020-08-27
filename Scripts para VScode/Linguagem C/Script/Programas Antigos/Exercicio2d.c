#include<stdio.h>
int main()
{

    float horas,minutos;
    printf("Digite as horas que transformarei para minutos: ");
    scanf("%f",&horas);
    minutos = horas * 60;
    printf("%.2f horas sao %.2f minutos.",horas,minutos);
    return 0;

}