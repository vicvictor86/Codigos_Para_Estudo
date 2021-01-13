#include <stdio.h>
#include <string.h>

struct Livro
{
    int id;
    char nomeautor[30];
    char titulo[30];
    int foiemprestado;
};
typedef struct Livro Livro;

struct AcervoDeLivro
{
    Livro livros[100];
    int numerodelivros;
    int numerodelivrosdisponiveis;
};
typedef struct AcervoDeLivro AcervoDeLivro;

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

AcervoDeLivro adicionarlivro(char nomeautor[30], char titulodolivro[30], AcervoDeLivro acervo)
{
    //Registro dos livros
    acervo.livros[acervo.numerodelivros].id = acervo.numerodelivros;

	strcpy(acervo.livros[acervo.numerodelivros].nomeautor, nomeautor);
    deixarmaiusculo(acervo.livros[acervo.numerodelivros].nomeautor);

	strcpy(acervo.livros[acervo.numerodelivros].titulo, titulodolivro);
    deixarmaiusculo(acervo.livros[acervo.numerodelivros].titulo);

    acervo.livros[acervo.numerodelivros].foiemprestado = 0;
    acervo.numerodelivros += 1;
    acervo.numerodelivrosdisponiveis += 1;
    
    return acervo;
}

void estadisponivel(AcervoDeLivro acervo, int id)
{
    acervo.livros[id].foiemprestado == 0 ? printf("Disponivel: sim\n") : printf("Disponivel: nao\n");
}

//Mostra quantos livros há na biblioteca
void totaldelivros(AcervoDeLivro acervo)
{
	printf("Numero de livros na biblioteca: %d\n", acervo.numerodelivrosdisponiveis);
}

void apresentacaodoslivros(AcervoDeLivro acervo, int i)
{
    printf("%s / %s / ID: %d / ", acervo.livros[i].titulo, acervo.livros[i].nomeautor, acervo.livros[i].id);
    estadisponivel(acervo, acervo.livros[i].id);
}

//Mostra todos os livros do acervo
void todososlivros(AcervoDeLivro acervo)
{
	int i = 0;
	for (i = 0; i < acervo.numerodelivros; i++)
    {   
        apresentacaodoslivros(acervo, i);
    } 
}

void procurarlivroid(int id, AcervoDeLivro acervo)
{   
    int i = 0;
    for (i = 0; i < acervo.numerodelivros; i++)
    {
        //Verifica se os ids são iguais
        if (id == acervo.livros[i].id)
        {
            apresentacaodoslivros(acervo, i);
            //Return colocado para parar a execução da função aqui para que não apareça a mensagem de erro
            //Não tem problema fazer isso já que o id é único logo quando encontrar o primeiro livro a busca não precisa continuar
            return;
        }    
    }
    
    printf("Nao existe livro com esse id\n");
}

void procurarlivroautor(char autor[30], AcervoDeLivro acervo)
{
    int i = 0, livroencontrado = 0;
    for (i = 0; i < acervo.numerodelivros; i++)
    {
        //Verifica se o nome do autor escrito existe nos livros do acervo e se ele já não foi emprestado
        if (strcmp(acervo.livros[i].nomeautor, autor) == 0 && acervo.livros[i].foiemprestado == 0)
        {
            apresentacaodoslivros(acervo, i);
            livroencontrado = 1;
        }    
    }
    
    if (livroencontrado == 0)
    {
        printf("Nao existe nenhum livro com esse autor no nosso acervo\n");
    }
}

void procurarlivrotitulo(char titulo[30], AcervoDeLivro acervo)
{  
    int i = 0, quantidadelivros = 0;
    for (i = 0; i < acervo.numerodelivros; i++)
    {
        if (strcmp(acervo.livros[i].titulo, titulo) == 0 && acervo.livros[i].foiemprestado == 0)
        {
            quantidadelivros += 1;
        }
    }

    if (quantidadelivros > 0)
    {
        printf("Com o titulo %s temos %d livros em nosso acervo\n", titulo, quantidadelivros);
    }
    else
    {
        printf("Nao existe livro com esse titulo em nosso acervo\n");
    }
}

AcervoDeLivro pegarlivroemprestado(int id, AcervoDeLivro acervo)
{
    //Coloca a flag para emprestado e decrementa a quantidade de livros disponiveis
    if (acervo.livros[id].foiemprestado == 0 && strcmp(acervo.livros[id].nomeautor, "") != 0)
    {
        acervo.livros[id].foiemprestado = 1;
        acervo.numerodelivrosdisponiveis -= 1;
        printf("O livro %s foi emprestado com sucesso\n", acervo.livros[id].titulo);
        return acervo;
    }
    else if(strcmp(acervo.livros[id].nomeautor, "") == 0)
    {
        printf("Nao existe nenhum livro com esse id\n");
    }
	else
	{
		printf("Esse livro ja foi emprestado.\n");
	}

	return acervo;
}

void opcoesdisponiveis()
{
    system("cls");
    printf("\nOpcoes:\n1-Pesquisa via ID\n2-Adicionar um livro ao acervo\n");
    printf("3-Pesquisa via autor\n4-Total de livros no acervo\n");
    printf("5-Pesquisa via titulo\n6-Pegar um livro emprestado\n");
    printf("7-Todos os livros\n");
    printf("0-Sair\n\n");
}

int main()
{   
    //Protótipo
	AcervoDeLivro livrosiniciais();

    int continuar = 1, opcao = 0;
    AcervoDeLivro acervoatual;
    //Adicionando os livros na biblioteca
    acervoatual = livrosiniciais();

    printf("***Bem vindo a nossa biblioteca***\n\n");

	while(1)
    {
        opcoesdisponiveis();
        printf("Digite sua escolha: ");
        scanf("%d", &opcao);
        //Limpar o buffer do teclado para que o gets não pegue o que foi escrito no scanf
        fflush(stdin);
		
		int id = 0;
		char autor[30], titulo[30];

        //Resolver problema do gets
        switch (opcao)
        {
            case 1:
                printf("Digite o id desejado: ");
                scanf("%d", &id);
                procurarlivroid(id, acervoatual);
                break;
            case 2:
                printf("Digite o nome do autor: ");
                gets(autor);
                printf("Digite o titulo do livro: ");
                gets(titulo);
                acervoatual = adicionarlivro(autor, titulo, acervoatual);
                printf("Adicionado com sucesso\n");
                break;
            case 3:
                printf("Digite o nome do autor: ");
                gets(autor);
                deixarmaiusculo(autor);
                procurarlivroautor(autor, acervoatual);
                break;
            case 4:
                totaldelivros(acervoatual);
                break;
            case 5:
                printf("Digite o titulo do livro: ");
                gets(titulo);
                deixarmaiusculo(titulo);
                procurarlivrotitulo(titulo, acervoatual);
                break;
            case 6:
                printf("Digite o id desejado: ");
                scanf("%d", &id);
                acervoatual = pegarlivroemprestado(id, acervoatual);
                break;
            //Esse case é só para facilitar para a correção pra ver quais os livros estão no acervo
            //E facilitar na correção, mas n irá aparecer nas opções do menu
            case 7:
                todososlivros(acervoatual);
                break;
            case 0:
                return 0;
            default:
                printf("Opcao inexistente tente novamente\n");
                break;
        }

        system("pause");
    }
}

AcervoDeLivro livrosiniciais()
{
    AcervoDeLivro acervoatual;
    //Inicialização da quantidade de livros
    int i;
    for (i = 0; i < 100; i++)
    {
        strcpy(acervoatual.livros[i].nomeautor, "");
    }
    acervoatual.numerodelivros = 0;
    acervoatual.numerodelivrosdisponiveis = 0;
    //Adição de livros
    acervoatual = adicionarlivro("Antoine de Saint", "Pequeno Principe", acervoatual);
    acervoatual = adicionarlivro("Sarah J. Maas", "Trono de vidro", acervoatual);
    acervoatual = adicionarlivro("Sarah J. Maas", "Trono de vidro", acervoatual);
    acervoatual = adicionarlivro("J. K. Rowling", "Harry Potter", acervoatual);
    acervoatual = adicionarlivro("Stephen King", "IT - A coisa",  acervoatual);
    acervoatual = adicionarlivro("Stephen King", "IT - A coisa",  acervoatual);
    acervoatual = adicionarlivro("Antoine de Saint", "Pequeno Principe", acervoatual);
    acervoatual = adicionarlivro("Stephen Hawking", "O universo numa casca de noz", acervoatual);
    acervoatual = adicionarlivro("Stephen King", "IT - A coisa",  acervoatual);
    acervoatual = adicionarlivro("Stephen Hawking", "O universo numa casca de noz", acervoatual);

    return acervoatual;
}
