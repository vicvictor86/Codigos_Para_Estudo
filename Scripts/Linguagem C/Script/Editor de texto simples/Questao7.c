#include <stdio.h>
#include <stdlib.h>
#include <string.h>

//Verifica se o arquivo foi aberto com sucesso
void verificaarquivo(FILE *fr)
{
    if(fr == NULL)
    {
        printf("Erro na abertura do arquivo");
    }
}

//Mostra o texto inteiro
void mostratexto()
{
    FILE *fr = fopen("textoinicial.txt", "r");
    int ch = 0, quantidadedelinhas = 0;
    
    verificaarquivo(fr);
    printf("0:");
    while((ch = fgetc(fr)) != EOF)
    {
        printf("%c", ch);
        if(ch == '\n')
        {
            quantidadedelinhas += 1;
            printf("%d:", quantidadedelinhas);
        }
    }
    printf("\n\n");
    fclose(fr);
}

//Conta linhas e os caracteres existentes no texto
void contalinhas(int *quantidadedelinhas, int *quantidadedecaracteres)
{
    FILE *fr = fopen("textoinicial.txt", "r");
    int ch = 0;
    verificaarquivo(fr);

    while((ch = fgetc(fr)) != EOF)
    {
        *quantidadedecaracteres += 1;
        if(ch == '\n')
        {
            *quantidadedelinhas += 1;
        }
    }
    fclose(fr);
}

//Armazena o texto inicial no vetor
void armazenarstring(char **textoinicial)
{   
    int i = 0, j = 0, estavazio = 1, ch = 0;
    FILE *fr;
    
    fr = fopen("textoinicial.txt", "r");
    verificaarquivo(fr);

    while((ch = fgetc(fr)) != EOF)
    {   
        textoinicial[i][j] = ch;
        if (ch == '\n')
        {
            j = 0;
            i++;
        }
        else
        {
            j++;
        }
    }
    fclose(fr);
}

//Escreve no arquivo o texto vindo do vetor
void escrevetexto(char **textoinicial, int quantidadedelinhas)
{   
    int i = 0, j = 0;
    FILE *fw = fopen("textoinicial.txt", "w");
    verificaarquivo(fw);

    for (i = 0; i < quantidadedelinhas; i++)
    {
        for (j = 0; j < strlen(textoinicial[i]); j++)
        {
            fputc(textoinicial[i][j], fw); 
        }
    }

    fclose(fw);
}

//Printa o texto entre linhas escolhidas
void listar(int linhainicial, int linhafinal, char **textoinicial, int quantidadedelinhas)
{   
    printf("\n");
    int i = 0, j = 0;
    if(linhafinal > quantidadedelinhas - 1|| linhafinal < 0 || linhainicial < 0 || linhainicial > quantidadedelinhas - 1)
    {
        printf("Linha digitada nao existente no arquivo\n");
        return;
    }
    for (i = linhainicial; i <= linhafinal; i++)
    {
        for (j = 0; j < strlen(textoinicial[i]); j++)
        {
            printf("%c", textoinicial[i][j]);
        }
    }
    printf("\n");
}

//Edita a linha
void editar(int linha ,char **textoinicial, int quantidadedelinhas)
{   
    char novafrase[300] = {""};
    listar(linha, linha, textoinicial, quantidadedelinhas);

    printf("Digite uma nova frase: ");
    gets(novafrase);
    strcat(novafrase, "\n");

    strcpy(textoinicial[linha], novafrase);
    printf("Linha editada com sucesso\n");
}

void inserirlinha(int linha, char **textoinicial, int *quantidadedelinhas)
{

    if(linha > *quantidadedelinhas - 1 || linha < 0)
    {
        printf("Linha digitada nao existente no arquivo\n");
        return;
    }

    char novafrase[300] = {""};
    char stringalterada[300][300] = {""};
    printf("\nDigite a frase que voce quer inserir: ");
    gets(novafrase);

    int i = 0;
    for (i = 0; i < *quantidadedelinhas + 1; i++)
    {
        if(i < linha + 1)
        {
            strcpy(stringalterada[i], textoinicial[i]);
        }
        else if(i == linha + 1)
        {
            //Verifica se a linha que eu quero inserir é a ultima
            //Pois caso seja, o pulo da linha tem que vim antes
            if(linha + 1 == *quantidadedelinhas)
            {
                strcat(stringalterada[i-1], "\n");
            }

            strcpy(stringalterada[i], novafrase);

            if (linha + 1 != *quantidadedelinhas)
            {
                strcat(stringalterada[i], "\n"); 
            }
        }
        else
        {
            strcpy(stringalterada[i], textoinicial[i-1]);
        }
    }
    
    //O numero de linhas capaz de ser amazenado no vetor aumenta em 1 para caber a nova linha
    *quantidadedelinhas += 1;
    textoinicial = (char **) realloc(textoinicial, (*quantidadedelinhas + 1) * sizeof(char *)); 
    textoinicial[*quantidadedelinhas - 1] = (char *) calloc(strlen(stringalterada[*quantidadedelinhas - 1]), sizeof(char));
    for (i = 0; i < *quantidadedelinhas; i++)
    {   
        strcpy(textoinicial[i], stringalterada[i]);
    }
}

void apagarlinha(int linha, char **textoinicial, int *quantidadedelinhas)
{

    if(linha > quantidadedelinhas - 1 || linha < 0)
    {
        printf("Linha digitada nao existente no arquivo\n");
        return;
    }

    char novafrase[300] = {""};
    char confirmacao;
    printf("Texto selecionado: ");
    listar(linha, linha, textoinicial, quantidadedelinhas);

    while (confirmacao != 's' && confirmacao != 'n' && confirmacao != 'S' && confirmacao != 'N')
    {
        printf("Tem certeza que quer excluir essa linha ?[S/N]: ");
        scanf("%c", &confirmacao);
        fflush(stdin);
    }
    
    if (confirmacao == 'S' || confirmacao == 's')
    {
        int i = 0;
        for (i = linha; i < *quantidadedelinhas; i++)
        {
            if(i + 1 == *quantidadedelinhas)
            {
                strcpy(textoinicial[i], "");
            }
            else
            {
                strcpy(textoinicial[i], textoinicial[i + 1]);
            }            
        }
        *quantidadedelinhas -= 1;
        printf("Linha apagada com sucesso\n");
    }
    
}

void salvaresair(char **textoinicial, int quantidadedelinhas)
{
    char confirmacao;

    printf("Tem certeza que quer salvar e sair ?[S/N]: ");
    scanf("%s", &confirmacao);

    if(confirmacao)
    {
        escrevetexto(textoinicial, quantidadedelinhas);
    }
}

void opcoesdisponiveis()
{
    printf("Suas opcoes sao:\n");
    printf("1-Listar\n2-Editar\n3-Inserir\n4-Apagar\n5-Abandonar\n6-Sair\n");
}

int main()
{
    int quantidadedecaracteres = 0, quantidadedelinhas = 1, i = 0, sair = 0, opcao = 0;
    char **textoinicial;

    contalinhas(&quantidadedelinhas, &quantidadedecaracteres);
    mostratexto();    
        
    //Aloca espaço
    textoinicial = (char **) calloc(10, sizeof(char *));
    for (i = 0; i < quantidadedelinhas; i++)
    {
        textoinicial[i] = (char *) calloc(100, sizeof(char));
    }
    armazenarstring(textoinicial);

    do
    {
        opcoesdisponiveis();
        printf("O que quer fazer ?: ");
        scanf("%d", &opcao);
        fflush(stdin);

        int linhainicial = 0, linhafinal = 0;
        switch (opcao)
        {
        case 1:
            printf("Linha inicial: ");
            scanf("%d", &linhainicial);
            printf("Linha final: ");
            scanf("%d", &linhafinal);
            fflush(stdin);
            
            listar(linhainicial, linhafinal, textoinicial, quantidadedelinhas);
            break;
        case 2:
            printf("Qual linha deseja editar ?: ");
            scanf("%d", &linhainicial);
            fflush(stdin);

            editar(linhainicial, textoinicial, quantidadedelinhas);
            break;
        case 3:
            printf("Depois de qual linha deseja abrir um espaco e escrever nela ?: ");
            scanf("%d", &linhainicial);
            fflush(stdin);

            inserirlinha(linhainicial, textoinicial, &quantidadedelinhas);
            break;
        case 4:
            printf("Qual linha deseja remover ?: ");
            scanf("%d", &linhainicial);
            fflush(stdin);

            apagarlinha(linhainicial, textoinicial, &quantidadedelinhas);
            break;
        case 5:
            printf("Deseja mesmo sair do programa sem salvar ?[0/1]: ");
            scanf("%d", &sair);
            break;
        case 6:
            printf("Deseja mesmo salvar e sair do programa ?[0/1]: ");
            scanf("%d", &sair);
            escrevetexto(textoinicial, quantidadedelinhas);
            break;
        default:
            printf("Opcao nao existente tente novamente\n");
            break;
        }
        system("pause");
        system("cls");
    } while (sair == 0);

    return 0;
}