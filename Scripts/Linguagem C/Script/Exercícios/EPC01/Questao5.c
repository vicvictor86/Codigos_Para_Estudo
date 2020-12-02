#include <stdio.h>
#include <math.h>
#define PI 3.1415926535

int main(){

    for (int angulo = 0; angulo <= 360; angulo += 5)
    {

        double seno;
        //Transformação de graus para radiano
        double anguloRadiano = (angulo / 180.0) * PI;
        //Calculo do seno
        seno = sin(anguloRadiano);

        printf("Angulo: %d, seno: %.4f\n", angulo, seno);
        
    }
    
    return 0;

}