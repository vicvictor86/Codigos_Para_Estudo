#include <stdio.h>
main()
{
	int a,b,c;
	a = 0;
	b = 0;
	printf("Digite um número para criar a tabuada");
	scanf("%d" , &a);
	 while (b<11)
	{
        c = a*b;
        printf("%d com %d = %d\n" , a , b , c);
        b++;
	}
}
