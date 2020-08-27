#include<stdio.h>
  main()
{
    int Digito1;
    printf("Digite 1-Elogio\n");
    printf("Digite 2-Ofensa\n");
    printf("Digite 3-Xau\n");
    scanf("%d",&Digito1);
      switch(Digito1)
    {
      case 1:
        printf("Vc e lindo");
        break;
      case 2:
        printf("Vc e um monstro");
        break;
      case 3:
       printf("xau");
        break;
      default:
        printf("Algo de errado não está certo");
    }

}
