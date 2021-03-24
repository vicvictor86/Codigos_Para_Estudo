#include <stdio.h>
#include <stdlib.h>
#include "mapa.h"
#include "ui.h"

char desenhoparede[4][7] = {
    {"......" },
    {"......" },
    {"......" },
    {"......" }
};

char desenhoheroi[4][7] = {
    {" .--. "  },
    {"/ _.-'"  },
    {"\\  '-." },
    {" '--' "  }
};

char desenhopilula[4][7] = {
    {"      "},
    {" .-.  "},
    {" '-'  "},
    {"      "}
};

char desenhovazio[4][7] = {
    {"      "},
    {"      "},
    {"      "},
    {"      "}
};

char desenhofantasma[4][7] = {
    {" .-.  " },
    {"| OO| " },
    {"|   | " },
    {"'^^^' " }
};

void impremeparte(char desenho[4][7], int parte){

	printf("%s", desenho[parte]);

}

void imprimemapa(MAPA* m){
    for (int i = 0; i < m->linhas; i++){
			for(int parte = 0; parte < 4; parte++){
				for(int j = 0; j < m->colunas; j++){
					switch(m->matriz[i][j]){

						case FANTASMAS:
							impremeparte(desenhofantasma, parte);
							break;
						case HEROI:
							impremeparte(desenhoheroi, parte);
							break;
						case PILULA:
							impremeparte(desenhopilula, parte);
							break;
						case PAREDE_VERTICAL:
						case PAREDE_HORIZONTAL:
							impremeparte(desenhoparede, parte);
							break;
						case VAZIO:
							impremeparte(desenhovazio, parte);
							break;

					}
				}
				printf("\n");
			}
    }
}