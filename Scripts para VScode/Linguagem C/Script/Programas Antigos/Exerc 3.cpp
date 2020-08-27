#include <stdio.h> 
#include <math.h>
  main()
{
	float a,b;
	a = 0;
	printf("escolha um número");
	scanf("%f",&a);
	if (a>0)
         b = pow(a, 1/2);  
    else if (a<0)
    b = a*a;
    printf("%f",b);
  
    
	
	
	
  }  
