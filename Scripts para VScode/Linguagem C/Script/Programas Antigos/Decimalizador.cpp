#include <stdio.h>
main()
{
	float a,b,c,d;
	a = 0;
	b = 0;
	printf ("Digite um numero e dps quantas casas decimais vc quer");
	scanf("%f",&a);
	scanf("%f",&b);
	if (b == 1)
	      b = 10;
	else if (b == 2)
	      b = 100;
	else
	      b = 1000;
    c = a/b;
	printf("o resultado sera: %f",c);      
	   
	
}
