#include <stdio.h>
#include <string.h>
#define QUANTIDADERECEITAS 5

struct Ingredientes
{
    char nome[25];
    int quantidade;
};
typedef struct Ingredientes Ingredientes;

struct Receitas
{
    char nome[25];
    int quantidadeingredientes;
    Ingredientes ingredientes[30];
};
typedef struct Receitas Receitas;

void inserirreceita(Receitas *receitas)
{
    int i = 0, j = 0;
    for (i = 0; i < QUANTIDADERECEITAS; i++)
    {
        printf("Digite o nome da %d receita: ", i + 1);
        gets(receitas[i].nome);

        printf("Quantidade de ingredientes na receita: ");
        scanf("%d", &receitas[i].quantidadeingredientes);
        fflush(stdin); 

        for (j = 0; j < receitas[i].quantidadeingredientes; j++)
        {
            printf("Qual o nome do %d ingrediente ?: ", j + 1);
            gets(receitas[i].ingredientes[j].nome);
            
            printf("Quantos deles precisa: ");
            scanf("%d", &receitas[i].ingredientes[j].quantidade);
            fflush(stdin);
        }
    }
}

void procurarreceita(char nome[], Receitas *receita)
{
    int i = 0, j = 0;
    for (i = 0; i < QUANTIDADERECEITAS; i++)
    {
        if (strcmp(nome, receita[i].nome) == 0)
        {
            printf("A receita %s tem os seguintes ingredientes: \n", receita[i].nome);
            for (j = 0; j < receita[i].quantidadeingredientes; j++)
            {
                printf("%s - Quantidade: %d\n", receita[i].ingredientes[j].nome, receita[i].ingredientes[j].quantidade);
                return;
            }
        }
        
    }
    
    printf("Receita nao encontrada, tente novamente\n");
}

int main()
{
    char nomereceita[25];
    Receitas receitas[5];

    inserirreceita(receitas);
    while (1) 
    {
        printf("\nQual receita voce esta buscando ?:");
        gets(nomereceita);

        if (strcmp(nomereceita, "") == 0)
        {
            break;
        }
        
        procurarreceita(nomereceita, receitas);
    }
    
    return 0;
}