#include <stdio.h>
#include <string.h>

int main()
{
    char senha[30];
    char senhacerta[30] = "senhaforte123";

    printf("Digite sua senha: ");
    //Uso do scanf pois em senha n pode ter espaço
    scanf("%s", senha);

    strcmp(senha, senhacerta) == 0 ? printf("Senha correta, fazendo login") : printf("Senha incorreta, tente novamente");

    return 0;
}
