#include <stdio.h>

int s;

int soma(int i)
{
    int s;
    s = 1;
    s = s + i;
    return s; 
}

int main()
{

    int a;
    s = 10;
    a = soma(15);
    printf("A = %d, S = %d\n",a,s);

    return 0;

}