#include <stdio.h>
main()
{
  float c,f;
  c = 0;
  printf("digite um grau em celsius para transformar em Kelvin");
  scanf("%f" , &c);
  f = c+273;
  printf("o valor em Kelvin e: %f" , f );
  return 0;

}
