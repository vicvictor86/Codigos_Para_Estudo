#include<stdio.h>
#include<math.h>
 float main()
{
  //Esse programa tem a função de resolver uma equação de segundo grau//
  float a,b,c,delta,resultado1,resultado2;
  printf("A base de uma equacao de segundo grau e: Ax + Bx + c\n");
  printf("Digite o numero equivalente a A:");
  scanf("%f", &a);
  printf("Digite o numero equivalente a B:");
  scanf("%f", &b);
  printf("Digite o numero equivalente a c:");
  scanf("%f", &c);
   delta = b*b - 4*a*c;
   resultado1 = (-b + sqrt(delta))/2*a;
   resultado2 = (-b - sqrt(delta))/2*a;
   if(delta<0)
       printf("Essa equacao nao tem raizes reais");
   else
   printf("As duas raizes para essa equacao sao: %f e %f", resultado1 , resultado2);
    return 0;
}
