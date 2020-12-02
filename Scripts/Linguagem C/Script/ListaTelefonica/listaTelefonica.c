#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include"clientes.h"
#define QUANTIDADE_INFORMACOES 3

int main(){

    int boasvindas(int);

    int sair = 1;
    int escolha;
    int quantidadeDeClientes;
    Usuario cliente;
		char nome[80];

    while (sair)
    {
        FILE* f;
        f = fopen("listadetelefones.txt", "r+");
    
        escolha = boasvindas(escolha);
        switch (escolha){
            case 1:
                printf("O que deseja procurar ?\n");
                printf("1-Nome\n2-numero\n3-email\n");
                scanf("%d", &escolha);
                switch (escolha){
                    case 1:
                    

                    fscanf(f, "%d", &quantidadeDeClientes);
                    printf("Qual nome esta procurando ?\n");
                    scanf("%s", nome);

                    for(int i = 0; i < quantidadeDeClientes * 3; i++){

                        char analise[80];
                        fscanf(f, "%s", analise);

                        if(strcmp(analise, nome) == 0){
                            char textoAtual;
                            do
                            {
                                fseek(f, -1, SEEK_CUR);                              
                                fscanf(f, "%s", &textoAtual);

                            } while (strcmp(&textoAtual, "{"));

                            fscanf(f, "%s", cliente.nome);
                            fscanf(f, "%s", cliente.numero);
                            fscanf(f, "%s", cliente.email);

                        } 
                        
                    }
                    
                }
        }
            

        printf("%s", cliente.nome);
        printf("%s", cliente.numero);
        printf("%s", cliente.email);
				sair = 0;

        
    }
    

}

int boasvindas(int escolha){
    printf("********Boas vindas a nossa agenda telefonica********\n");
    printf("O que deseja ?\n");
    printf("Opcoes:\n1-Procurar alguem na agenda\n2-Cadastrar na nossa agenda\n");
    scanf("%d", &escolha);
    return escolha;
}