#ifndef _MAPA_H_
#define _MAPA_H_

#define HEROI '@'
#define FANTASMAS 'F'
#define PAREDE_VERTICAL '|'
#define VAZIO '.'
#define PAREDE_HORIZONTAL '-'
#define PILULA 'P'

struct mapa
{
    char** matriz;
    int linhas;
    int colunas;
};
typedef struct mapa MAPA;

struct posicao
{
    int x;
    int y;
};
typedef struct posicao POSICAO;

void lermapa(MAPA* m);
void liberamapa(MAPA* m);
void alocamapa(MAPA* m);
int encontramapa(MAPA* m, POSICAO* p, char c);
int ehvalido(MAPA* m, int x, int y);
int ehvazia(MAPA* m, int x, int y);
void andandomapa(MAPA* m, int origemx, int origemy, int destinox, int destinoy);
void copiamapa(MAPA* destino, MAPA* origem);
int podeandar(MAPA* m, char personagem, int x, int y);
int ehparede(MAPA* m, int x, int y);
int ehpersonagem(MAPA* m, char personagem, int x, int y);
#endif