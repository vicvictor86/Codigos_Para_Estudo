#include <stdio.h>
#define QUANTIDADECONTAS 3

struct Conta
{
    char nome[30];
    char cpf[11];
    float saldo;
};
typedef struct Conta Conta;

void registrar(Conta *conta)
{
    int i;
    for(i = 0; i < QUANTIDADECONTAS; i++)
    {   
        printf("Dados para abertura da conta(%d)\n", i + 1);
        printf("Digite o CPF: ");
        gets(conta[i].cpf);
        printf("Digite o nome: ");
        gets(conta[i].nome);
        printf("Digite o saldo inicial: ");
        scanf("%f", &conta[i].saldo);
        fflush(stdin);
        printf("Cliente: %s Conta: %d Saldo inicial:%.2f", conta[i].nome, i, conta[i].saldo);
        printf("\n\n");
    }
}

void sacar(int i, float saldo,Conta *conta)
{
    conta[i].saldo -= saldo;
    printf("Saque: %.2f\n", saldo);
    printf("Cliente: %s Saldo atual: %.2f\n", conta[i].nome, conta[i].saldo);
}

void depositar(int i, float saldo,Conta *conta)
{
    conta[i].saldo += saldo;
    printf("Deposito: %.2f\n", saldo);
    printf("Cliente: %s Saldo atual: %.2f\n", conta[i].nome, conta[i].saldo);
}

int main()
{
    Conta conta[QUANTIDADECONTAS];
    registrar(conta);
    int opcao = 1, posicao;
    float valor;
    
    do
    {
        printf("1-Saque 2-Deposito 3-sair: ");
        scanf("%d", &opcao);
        switch (opcao)
        {
            case 1:
                printf("Informe numero da conta e valor: ");
                scanf("%d", &posicao);
                scanf("%f", &valor);
                sacar(posicao, valor, conta);
                break;
            case 2:
                printf("Informe numero da conta e valor: ");
                scanf("%d", &posicao);
                scanf("%f", &valor);
                depositar(posicao, valor, conta);
            case 3:
                break;
            default:
                printf("Opcao invalida");
                break;
        }
    } while (opcao != 3);

    return 0;
}