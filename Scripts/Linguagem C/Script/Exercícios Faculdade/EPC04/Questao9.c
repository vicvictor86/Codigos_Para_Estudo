#include <stdio.h>
#include <string.h>

struct DataDeNascimento 
{
    int dia;
    int mes;
    int ano;
};
typedef struct DataDeNascimento DataDeNascimento;

struct Usuario
{
    char nome[30];
    char endereco[30];
    DataDeNascimento datadeascimento;
    char estado[30];
    char cidade[30];
    char cep[8];
    char email[30];
};
typedef struct Usuario Usuario;

int diasnomes(int mes, int ano)
{
    //Meses com 31 dias
    if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12)
    {
        return 31;
    }
    //Meses com 30 dias
    else if(mes == 4 || mes == 6 || mes == 9 || mes == 11)
    {
        return 30;
    }
    else
    {
        //Testa se o ano é bissexto
        if (ano % 4 == 0 || ano % 100 == 0 || ano % 400 == 0)
        {
            return 29;
        }
        else
        {
            return 28;
        }
    }
}

int verificanascimento(Usuario usuario)
{
	if (usuario.datadeascimento.ano < 1900 || usuario.datadeascimento.ano > 2010)
    {
        printf("Data invalida, tente novamente.\n");
        return 0;
    }

    if (usuario.datadeascimento.mes <= 12 && usuario.datadeascimento.mes > 0)
    {
        //Vai verificar se a quantidade de dias é menor que a quantidade de dias do mes
        if (usuario.datadeascimento.dia > 0 && usuario.datadeascimento.dia <= diasnomes(usuario.datadeascimento.mes, usuario.datadeascimento.ano))
        {
            return 1;
        }
		else
		{
            printf("Data invalida, tente novamente.\n");
			return 0;
		}
    }

    printf("Data invalida, tente novamente.\n");
    return 0;
}

void deixarmaiusculo(char palavra[])
{
    int i = 0;
    for (i = 0; palavra[i] != '\0'; i++)
    {
        if (palavra[i] >= 97 && palavra[i] <= 122)
        {
            palavra[i] -= 32;
        }
    }
}

//Função criada para diminuir a quantidade de comparações da primeira função
int compararegiao(int regiao, char estado[30])
{   
    if (regiao == 5)
    {
        if (strcmp(estado, "PERNAMBUCO") == 0 || strcmp(estado, "ALAGOAS") == 0 || strcmp(estado, "PARAIBA") == 0 || strcmp(estado, "RIO GRANDE DO NORTE") == 0)
        {
            return 1;
        }        
    }
    else if(regiao == 6)
    {
        if (strcmp(estado, "CEARA") == 0 || strcmp(estado, "PIAUI") == 0 || strcmp(estado, "MARANHAO") == 0 || strcmp(estado, "PARA") == 0 || strcmp(estado, "AMAZONAS") == 0 || strcmp(estado, "ACRE") == 0 || strcmp(estado, "AMAPA") == 0 || strcmp(estado, "RORAIMA") == 0)
        {
            return 1;
        } 
    }
    else if(regiao == 7)
    {
        if (strcmp(estado, "DISTRITO FEDERAL") == 0 || strcmp(estado, "GOIAS") == 0 || strcmp(estado, "TOCANTINS") == 0 || strcmp(estado, "MATO GROSSO DO SUL") == 0 || strcmp(estado, "RONDONIA") == 0)
        {
            return 1;
        }
    }
	return 0;
}

int verificacep(char cep[8], char estado[30], char cidade[30])
{
    
    if (cep[0] == '0' && strcmp(cidade, "SAO PAULO") == 0)
    {
        return 1;
    }
    else if(cep[0] == '1' && strcmp(estado, "SAO PAULO") == 0)
    {
        return 1;
    }
    else if(cep[0] == '2' && (strcmp(estado, "RIO DE JANEIRO") == 0 || strcmp(estado, "ESPIRITO SANTO") == 0))
    {
        return 1;
    }
    else if(cep[0] == '3' && strcmp(estado, "MINAS GERAIS") == 0)
    {
        return 1;
    }
    else if(cep[0] == '4' && (strcmp(estado, "BAHIA") == 0 || strcmp(estado, "SERGIPE") == 0))
    {
        return 1;
    }
    else if(cep[0] == '5' && compararegiao(5, estado))
    {
        return 1;
    }
    else if(cep[0] == '6' && compararegiao(6, estado))
    {
        return 1;
    }
    else if(cep[0] == '7' && compararegiao(7, estado))
    {
        return 1;
    }
    else if(cep[0] == '8' && (strcmp(estado, "PARANA") == 0 || strcmp(estado, "SANTA CATARINA") == 0)) 
    {
        return 1;
    }
    else if(cep[0] == '9' && strcmp(estado, "RIO GRANDE DO SUL") == 0)
    {
        return 1;
    }
    else
    {
        printf("Cep nao condiz com a cidade ou estado, tente novamente.\n");
        return 0;
    }    
}

//Para o email ser aceito ele deve ter o @ e o .com
int verificaemail(char email[])
{
    char *resultado;
    resultado = strstr(email, "@");
    if (resultado != NULL)
    {   
        if (strstr(resultado, ".com") != NULL)
        {
            return 1;
        }
    }
    printf("Email invalido, tente novamente.\n");
    return 0;
}

int verificaregistro(Usuario *usuario)
{
    int valido = 1;
    valido = verificanascimento(*usuario);
    valido = verificaemail(usuario->email);
    valido = verificacep(usuario->cep, usuario->estado, usuario->cidade);
    return valido;
}

int registrarusuario(Usuario *usuario)
{
    int valido = 1;
    printf("Digite seu nome: ");
    gets(usuario->nome);
    deixarmaiusculo(usuario->nome);
    
    printf("Digite seu endereco: ");
    gets(usuario->endereco);
    deixarmaiusculo(usuario->endereco);

    printf("Digite sua data de nascimento: ");
    scanf("%d", &usuario->datadeascimento.dia);
    scanf("%d", &usuario->datadeascimento.mes);
    scanf("%d", &usuario->datadeascimento.ano);
    fflush(stdin);

    printf("Digite o seu cep: ");
    gets(usuario->cep);
    deixarmaiusculo(usuario->cep);
    printf("Digite o seu estado: ");
    gets(usuario->estado);
    deixarmaiusculo(usuario->estado);
    printf("Digite a sua cidade: ");
    gets(usuario->cidade);
    deixarmaiusculo(usuario->cidade);

    printf("Digite o seu email: ");
    gets(usuario->email);

    valido = verificaregistro(usuario);

    return valido;
}

void mostrainformacoes(Usuario usuario)
{
    printf("\n%s\n", usuario.nome);
    printf("%s\n", usuario.email);
    printf("Data de nascimento: %d/%d/%d\n", usuario.datadeascimento.dia, usuario.datadeascimento.mes, usuario.datadeascimento.ano);
    printf("Endereco: %s\n", usuario.endereco);
    printf("Cep: %s\nEstado: %s\nCidade: %s\n", usuario.cep, usuario.estado, usuario.cidade);
}

int main()
{
    Usuario usuario;
    int concluido = 0;

    while (concluido == 0)
    {
        concluido = registrarusuario(&usuario);
    }

    mostrainformacoes(usuario);

    return 0;
}